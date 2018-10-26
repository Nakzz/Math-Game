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


/**
 * The GameList class represents a list that contains all the GameNodes.
 * 
 * @author: Ajmain Naqib
 * @email: naqib@wisc.edu
 */

public class GameList {

  private GameNode list; // reference to the first GameNode in this list

  /**
   * Initializes new list to start out empty.
   * 
   */
  public GameList() {
    this.list = null; // initializes list to null
  }

  /**
   * Adds a new node to the end of this list
   * 
   */
  public void addNode(GameNode newNode) {

    GameNode currNode = this.list;

    if (currNode == null) { // if first node of the list
      this.list = newNode;
    } else {
      while (currNode.getNext() != null) { // iterates until last node of the list
        currNode = currNode.getNext();
      }
      currNode.setNext(newNode); // add node to the end of the list
    }

  }

  /**
   * Check's if list contains a node that has the number given. Only returns true when this list
   * contains a node with the specified number
   * 
   * @param int number to check if contains in the list
   * @return returns true when this list contains a node with the specified number
   */
  public boolean contains(int number) {
    GameNode currNode = this.list;

    while (currNode != null) { // iterates until last node of the list
      if (currNode.getNumber() == number) // checks if node's number matches
        return true;

      currNode = currNode.getNext();
    }

    return false;
  } //

  /**
   * Returns a string representation of all the node's number separated by " -> "s, and ending with "
   * -> END"
   * 
   * @return returns a string with each number in the list formatted
   */

  public String toString() {
    String text = "";
    GameNode currNode = this.list;

    while (currNode != null) { // iterates until last node of the list
      text += currNode.getNumber() + " -> ";

      currNode = currNode.getNext();

      if (currNode == null) // if last node is reached add's "END"
        text += "END";
    }

    return text;
  } //

  /**
   * This applyOperatorToNumber() method scans through this list searching for the first occurrence of
   * a node with the specified number. After finding a node with that number, it calls the
   * applyOperator method on that GameNode, passing along the specified operator object reference. If
   * the node that applyOperator() is called on happens to be the last node in the list, then
   * applyOperator() will throw a NullPointerException. Your applyOperatorToNumber() method should not
   * catch such exceptions; it should instead allow them to be thrown from this method. 
   * 
   * @param int number that will be checked within the list
   * @param GameOperator operator that will be applied
   */
  public void applyOperatorToNumber(int number, GameOperator operator) {

    if (contains(number)) {
      list.applyOperator(operator);
    }

  }
}
