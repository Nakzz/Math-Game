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
 * Test class for GameList and GameNode class
 * 
 * @author: Ajmain Naqib
 * @email: naqib@wisc.edu
 */

public class GameTests {
  public static void main(String[] args) {

    int test = 4;

    if (testGameNode1())
      test--;
    else
      System.out.println("testGameNode1 failed!");

    if (testGameNode2())
      test--;
    else
      System.out.println("testGameNode2 failed!");

    if (testGameList1())
      test--;
    else
      System.out.println("testGameList1 failed!");

    if (testGameList2())
      test--;
    else
      System.out.println("testGameList2 failed!");

    System.out.println(test + " tests failed!");
  }


  /**
   * Checks if next node is being set properly.
   * 
   * @return true if works properly, false otherwise
   * 
   */

  public static boolean testGameNode1() {

    Random rand = new Random();
    GameNode testNode = new GameNode(rand); // new GameNode object

    int testNodeVal = testNode.getNumber(); // number of that object
    GameNode nextNode = testNode.getNext(); // next reference of that object

    if (nextNode != null) { // if nextNode isn't null, something is wrong
      return false;
    }

    GameNode testNode2 = new GameNode(rand); // new GameNode object
    testNode.setNext(testNode2); // sets next reference of that object
    nextNode = testNode.getNext(); // gets next reference of first object again

    if (!nextNode.equals(testNode2)) { // if both aren't same, something is wrong
      return false;
    }

    return true;

  }

  /**
   * Checks if applyOperator method works properly
   * 
   * @return true if works properly, false otherwise
   * 
   */

  public static boolean testGameNode2() {

    Random rand = new Random();
    GameNode testNode = new GameNode(rand);// new GameNode object

    int testNodeVal = testNode.getNumber();
    GameNode nextNode = testNode.getNext();

    if (nextNode != null) {
      System.out.println("ERROR: Next node is not null.");
      return false;
    }


    GameNode testNode2 = new GameNode(rand);// new GameNode object
    testNode.setNext(testNode2); // sets the second node as the next for first node
    nextNode = testNode.getNext();


    GameOperator testOperator = GameOperator.getFromChar('+');
    testNode.applyOperator(testOperator); // operator applied on first node

    nextNode = testNode.getNext(); // next reference of the first node

    if (nextNode != null) { // next reference should be null
      System.out.println("applyOperator didn't remove node2");
      return false;
    }


    return true;

  }


  /**
   * Checks if contains method works properly
   * 
   * @return true if works properly, false otherwise
   * 
   */
  public static boolean testGameList1() {
    GameList testList = new GameList();
    Random rand = new Random();

    GameNode testNode = new GameNode(rand); // new GameNode object
    int testNode1Val = testNode.getNumber();
    GameNode testNode2 = new GameNode(rand);// new GameNode object
    int testNode2Val = testNode2.getNumber();

    testList.addNode(testNode); // adds node to list when list is empty
    testList.addNode(testNode2); // adds node to list when list contains node

    if (!testList.contains(testNode1Val)) { // check's if the same value contains
      System.out.println("List doesn't contain node1's value");
      return false;
    }

    if (!testList.contains(testNode2Val)) { // check's if the same value contains
      System.out.println("List doesn't contain node2's value");
      return false;
    }

    return true;

  }


  /**
   * Checks if toString method works properly
   * 
   * @return true if works properly, false otherwise
   * 
   */
  public static boolean testGameList2() {
    GameList testList = new GameList();
    Random rand = new Random();

    GameNode testNode = new GameNode(rand); // new GameNode object
    int testNode1Val = testNode.getNumber();
    GameNode testNode2 = new GameNode(rand);// new GameNode object
    int testNode2Val = testNode2.getNumber();

    testList.addNode(testNode); // adds node to list when list is empty
    testList.addNode(testNode2); // adds node to list when list contains node


    String expected = testNode1Val + " -> " + testNode2Val + " -> " + "END"; // expected result
    String result = testList.toString(); // actual result

    // System.out.println(expected);
    // System.out.println(result);

    if (result.equals(expected))
      return true; // if expected matches the result

    return false;

  }

}
