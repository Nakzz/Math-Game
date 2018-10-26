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

import java.util.Random;


/**
 * The GameNode class represents a single number within this linked list.
 * 
 * @author: Ajmain Naqib
 * @email: naqib@wisc.edu
 */

public class GameNode {
  private int number; // the number held within this node
  private GameNode next; // the next GameNode in the list, or null for the last node

  /**
   * Creates a new node, initializing it's number to a random 1-9 value, and next to null.
   * 
   * @param Random rng A random object
   */
  public GameNode(Random rng) {
    this.number = rng.nextInt(9) + 1;
    this.next = null;
  }

  /**
   * Accessor method for the number field
   * 
   * @return the number of this object
   */
  public int getNumber() {
    return this.number;
  }

  /**
   * Accessor method for the next GameNode's reference
   * 
   * @return the next GameNode
   */
  public GameNode getNext() {
    return this.next;

  }

  /**
   * Mutator method that sets the next GameNode's reference
   * 
   */
  public void setNext(GameNode next) {
    this.next = next;
  }

  /**
   * This method changes this nodes number and next fields. The new number for this node is calculated
   * by applying the provided operator to this node’s number (the first operand), and the next node’s
   * number (the second operand). The new next reference for this node should be copied from the next
   * reference of the following node in the list so that the following node is effectively removed
   * from the list. When this method is called on the node that is at the end of a list, then a
   * NullPointerException may be thrown to indicate this problem.
   * 
   */
  public void applyOperator(GameOperator operator) {

    GameNode nextNode = this.next; // reference to next GameNode
    GameNode newNextRef = null; // initialize GameNode to null

    if (nextNode == null) { // if this GameNode is the last node, throw exception
      throw new NullPointerException();
    }

    int newNumber = operator.apply(this.number, nextNode.number);
    // apply method is called to get new number

    newNextRef = nextNode.getNext(); // next node's next reference

    this.number = newNumber; // sets new number
    this.next = newNextRef; // sets new next reference

  }
}
