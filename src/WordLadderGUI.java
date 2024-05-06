import javax.swing.*;

import algorithm.WordLadderAStar;
import algorithm.WordLadderGBFS;
import algorithm.WordLadderUCS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import utils.Dictionary;

public class WordLadderGUI extends JFrame implements ActionListener {
    private JTextField startingWordField, endingWordField;
    private JButton solveButton;
    private JTextArea resultArea;
    private JRadioButton jRadioButton1, jRadioButton2, jRadioButton3;
    private ButtonGroup algorithmGroup;

    public static String get_information(String algorithm_name, List<String> path, long exec, int node_number) {
        long convert = TimeUnit.MILLISECONDS.convert(exec, TimeUnit.NANOSECONDS);
        String resultText = "The selected algorithm is " + algorithm_name + ". Here is the result.\n";
        if (path.isEmpty()) {
            resultText += "No path found\n";
        } else {
            resultText += "Path result: " + path.toString() + "\n";
        }
        resultText += "Execution time: " + convert + " ms.\n";
        resultText += "Total of nodes visited: " + node_number + " nodes.\n";
        return resultText;
    }

    public WordLadderGUI() {
        setTitle("Word Ladder Solver");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(247, 224, 146));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);

        JLabel startingWordLabel = new JLabel("Starting Word:");
        startingWordLabel.setForeground(new Color(245, 130, 15));
        c.gridx = 0; c.gridy = 0;
        formPanel.add(startingWordLabel, c);

        startingWordField = new JTextField(15);
        startingWordField.setForeground(new Color(100, 65, 0));
        startingWordField.setBackground(new Color(255, 255, 224));
        c.gridx = 1;
        formPanel.add(startingWordField, c);

        JLabel endingWordLabel = new JLabel("Ending Word:");
        endingWordLabel.setForeground(new Color(245, 130, 15));
        c.gridx = 0; c.gridy = 1;
        formPanel.add(endingWordLabel, c);

        endingWordField = new JTextField(15);
        endingWordField.setForeground(new Color(100, 65, 0));
        endingWordField.setBackground(new Color(255, 255, 224));
        c.gridx = 1;
        formPanel.add(endingWordField, c);

        jRadioButton1 = new JRadioButton("UCS");
        jRadioButton2 = new JRadioButton("GBFS");
        jRadioButton3 = new JRadioButton("A*");
        jRadioButton1.setBackground(formPanel.getBackground());
        jRadioButton2.setBackground(formPanel.getBackground());
        jRadioButton3.setBackground(formPanel.getBackground());
        algorithmGroup = new ButtonGroup();
        algorithmGroup.add(jRadioButton1);
        algorithmGroup.add(jRadioButton2);
        algorithmGroup.add(jRadioButton3);
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        radioPanel.setBackground(new Color(255, 198, 64));
        radioPanel.add(jRadioButton1);
        radioPanel.add(jRadioButton2);
        radioPanel.add(jRadioButton3);

        c.gridx = 0; c.gridy = 2; c.gridwidth = 2;
        formPanel.add(radioPanel, c);

        solveButton = new JButton("Solve");
        solveButton.setBackground(new Color(245, 130, 15));
        solveButton.addActionListener(this);
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2;
        formPanel.add(solveButton, c);

        resultArea = new JTextArea(5, 20);
        resultArea.setLineWrap(true);
        resultArea.setEditable(false);
        resultArea.setBackground(new Color(255, 255, 255)); 
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(255, 198, 64), 2));

        add(formPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Dictionary.load_word("./utils/words.txt");
        if (e.getSource() == solveButton) {
            String startingWord = startingWordField.getText().toLowerCase();
            String endingWord = endingWordField.getText().toLowerCase();

            if (!Dictionary.word_valid_checker(startingWord)) {
                JOptionPane.showMessageDialog(this, "Invalid input words. Starting word is not defined in the dictionary.");
                return;
            }

            if (!Dictionary.word_valid_checker(endingWord)) {
                JOptionPane.showMessageDialog(this, "Invalid input words. Ending word is not defined in the dictionary.");
                return;
            }

            if (startingWord.length() != endingWord.length()) {
                JOptionPane.showMessageDialog(this, "Invalid input length. The starting word and the ending word input must have the same length.");
                return;
            }

            String selectedAlgorithm = getSelectedAlgorithm();

            if (selectedAlgorithm == "No algorithm selected") {
                JOptionPane.showMessageDialog(this, "Invalid algorithm selection. Please select one of the algorithm provided.");
                return;
            }

            Runtime runtime = Runtime.getRuntime();
            long initialMemory = runtime.totalMemory() - runtime.freeMemory();
            switch (selectedAlgorithm) {
                case "UCS":
                    WordLadderUCS solverUCS = new WordLadderUCS(new ArrayList<>(), 0, 0);
                    solverUCS.find_path_solution_UCS(startingWord, endingWord);
                    resultArea.setText(get_information("Uniformed Cost Search", solverUCS.getPath(), solverUCS.getExecutionTime(), solverUCS.getNodesVisited()));
                    break;
                case "GBFS":
                    WordLadderGBFS solverGBFS = new WordLadderGBFS(new ArrayList<>(), 0, 0);
                    solverGBFS.find_path_solution_GBFS(startingWord, endingWord);
                    resultArea.setText(get_information("Greedy Best First Search", solverGBFS.getPath(), solverGBFS.getExecutionTime(), solverGBFS.getNodesVisited()));
                    break;
                case "A*":
                    WordLadderAStar solverAStar = new WordLadderAStar(new ArrayList<>(), 0, 0);
                    solverAStar.find_path_solution_AStar(startingWord, endingWord);
                    resultArea.setText(get_information("A-Star", solverAStar.getPath(), solverAStar.getExecutionTime(), solverAStar.getNodesVisited()));
                    break;
            }
            long finalMemory = runtime.totalMemory() - runtime.freeMemory();
            long memoryUsed = finalMemory - initialMemory;
            System.out.println("Memory used: " + memoryUsed + " bytes");
        }
    }

    private String getSelectedAlgorithm() {
        if (jRadioButton1.isSelected()) return "UCS";
        if (jRadioButton2.isSelected()) return "GBFS";
        if (jRadioButton3.isSelected()) return "A*";
        return "No algorithm selected";
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WordLadderGUI gui = new WordLadderGUI();
            gui.setVisible(true);
        });
    }
}
