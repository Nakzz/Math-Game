//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Math Game
// Files: GameApplication.java, GameList.java, GameNode.java, GameOperator.java, GameTests.java,
// Course: CS300, Fall 2018
//
// Author: Ajmain Naqib
// Email: naqib@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:
// Partner Email:
// Partner Lecturer's Name:
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// __ Write-up states that pair programming is allowed for this assignment.
// __ We have both read and understand the course Pair Programming Policy.
// __ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: None
// Online Sources: None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Application Class for the Math Game with the user interface. 
 * 
 * @author: Ajmain Naqib
 * @email: naqib@wisc.edu
 */

public class GameApplication {

  public static void main(String[] args) {
    Random rand = new Random(); // initialize random object
    Scanner scnr = new Scanner(System.in); // initialize scanner object
    String userInput;
    boolean gameOver = false;
    char inputChar;
    int inputInt;
    GameOperator inputOperator;
    
    int movesTaken = 0; // initialize number of moves taken
    int targetGoalNumber = rand.nextInt(90) + 10; // random number between 10-99 inclusive

    GameList gamesList = new GameList();    // initialize GameList object

    // 7 GameNodes added to the List
    for (int node = 0; node < 7; node++) {
      gamesList.addNode(new GameNode(rand));
    }

    List<GameOperator> operators = GameOperator.ALL_OPERATORS;  // All the avaialbe operators

    //loop to run the game
    while (!gameOver) {

      System.out.println("Goal: " + targetGoalNumber + " Moves Taken: " + movesTaken);
      System.out.println("Puzzle: " + gamesList.toString());
      System.out.println("Number and Operation " + operators.toString() + " to Apply: ");

      userInput = scnr.nextLine().trim(); //process input
      
      if(userInput.equalsIgnoreCase("quit")) { // ends loop if quit is entered
        System.out.println("Goodbye!");
        break;
      } 
      try {
        inputChar = userInput.charAt(userInput.length() -1);    // extracts Char from input
        inputInt = Integer.parseInt(userInput.substring(0, userInput.length()-1));  // extracts number from input
        inputOperator = GameOperator.getFromChar(inputChar);    // matches char with Operator
        
        if(inputOperator != null && gamesList.contains(inputInt)) { // if valid input
          movesTaken++;
          gamesList.addNode(new GameNode(rand));    // new Node added
          gamesList.applyOperatorToNumber(inputInt, inputOperator); // operator applied
        } else {
          throw new Exception();    // If any exception caught while parsing input, throw error
        }
        
      } catch(Exception e){
        System.out.println("WARNING: Invalid Input. Try again.");   // warning message
      }


      if(gamesList.contains(targetGoalNumber)) {
        gameOver = true;
        System.out.println("Congratulations!  You've won the game in "+ movesTaken+ " moves."); // win message
      }
      
      System.out.println();

    }

  }

}
