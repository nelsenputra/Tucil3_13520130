# Tucil Stima 3 by Nelsen Putra
> Word Ladder Solver written in Java. Based on the concept of UCS, Greedy Best First Search, and A* algorithm.


## Table of Contents
* [Introduction](#introduction)
* [General Information](#general-information)
* [Technologies Used](#technologies-used)
* [Features](#features)
* [Setup](#setup)
* [Project Status](#project-status)
* [Room for Improvement](#room-for-improvement)
* [Acknowledgements](#acknowledgements)


## Introduction
Hello, everyone! Welcome to my GitHub Repository!

This project was created by:
| Name | Student ID | Class |
| :---: | :---: | :---: |
| Nelsen Putra | 13520130 | IF2211-02


## General Information
Word ladder (also known as Doublets, word-links, change-the-word puzzles, paragrams, laddergrams, or word golf) is a word game that is well known to all circles. Word ladder was discovered by Lewis Carroll, a writer and mathematician, in 1877. In this game, players are given two words called a start word and an end word. To win the game, players must find a chain of words that can connect the start word and end word. The number of letters at the start word and end word is always the same. Each adjacent word in the word chain can only differ by one letter. In this game, the optimal solution is expected, namely the solution that minimizes the number of words included in the word chain. 

The program is a solution to the mentioned game where it is supposed to be an easy-to-use tool for players who stuck and need help to find the solution for the game. This program was written in Java language, implementing the UCS, Greedy Best First Search, and A* algorithm. User can choose between the three algorithm to solve their cases. This scenario is made for author to compare their performance and analyze factors such as memory usage, complexity, and execution time. This comparison is in order to determine which algorithm best suits different problem sets.


## Technologies Used
The whole program was written in Java.


## Features
- [x] Find a series of words (word path) from starting word to ending word according to the rules of the game with the UCS algorithm
- [x] Find a series of words (word path) from starting word to ending word according to the rules of the game with the Greedy Best First Search algorithm
- [x] Find a series of words (word path) from starting word to ending word according to the rules of the game with the A* algorithm
- [x] Show the solving process such as path result, execution time, and total of visited nodes
- [x] **(Bonus)** Can be run using Graphical User Interface (GUI)


## Setup
### Installation
- Download and install [Java](https://www.java.com/en/) (Prerquisite: Java 19 or newer)
- Install the whole modules and libraries used in the source code if needed
- Download the whole folders and files in this repository or do clone the repository

### Execution
1. Clone this repository in your own local directory

    `git clone https://github.com/nelsenputra/Tucil3-13520130.git`

2. Open the command line and change the directory to 'src' folder

    `cd Tucil3-13520130/src`
    
3. For GUI: Run `javac WordLadderGUI.java && java WordLadderGUI` on the command line or use the code runner extension
4. For CLI: Run `javac Main.java && java Main` on the command line or use the code runner extension


## Project Status
Project is: _complete_

All the specifications were implemented.


## Room for Improvement
- A more advanced and efficient algorithm to make the program run quicker
- A better interface development to improve user satisfaction


## Acknowledgements
- This project was based on [Spesifikasi Tugas Kecil 3 IF2211 Strategi Algoritma](https://docs.google.com/document/d/1TUvKn-vPXhLsxga8K7mjSUbYnInHp2TSRtGFWlngwYk/edit)
- Thanks to God
- Thanks to Mrs. Masayu Leylia Khodra, Mrs. Nur Ulfa Maulidevi, and Mr. Rinaldi as our lecturers
- Thanks to academic assistants
- This project was created to fulfill our Small Project for IF2211 Algorithm Strategies
