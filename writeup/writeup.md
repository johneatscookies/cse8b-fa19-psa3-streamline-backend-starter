# PSA 3: Streamline Backend Logic and Data Structure
**Checkpoint submission** is due Tuesday, **October 29th**, at 11:59 pm

**Final submission** is due Tuesday, **November 5th**, at 11:59 pm

## Introduction to PSA3
For this assignment, you’ll be recreating a version of an innovative game combining classic Snake and Club Penguin's Thin Ice -- **STREAMLINE**! This is a two week assignment where you’ll be making an interactive game of Streamline using some of the concepts you have learned in this class so far, such as overloaded constructors, (a lot of) array manipulation, (a lot of) boolean conditioning, file I/O, taking input from console, etc. By the time you finish this PSA, you’ll love playing Streamline as much as you love CSE 8B.

**IMPORTANT!**

This assignment has a **mandatory checkpoint submission**. Make sure to submit the necessary checkpoint files by the checkpoint due date.

## Starter Code

Copy the starter code using the same command `cp -r` as in the previous PSAs (refer to PSA 0 if you need a refresher). The starter code is located at the following path:
```
~/../public/psa3
```
To open all files simultaneously, be inside the directory and open all the files using the command:
```
[1] vim -p File1.java File2.java File3.java File4.java 
```
OR
```
[2] vim -p *.java
```
Command [1] is safer to execute. Command [2] is more convenient -- but in the wrong directory it can open a headache amount of files.

* Consider: what does * do in this context? Try searching it up if you do not know.
* Backup your code frequently as you progress through the assignment. We are not responsible for recovering your code.

## Frequently Asked Questions
**Q: Can I add instance variables?**

A: You are only allowed to do so in your Extra Credit file, StreamlineEC.java. All instance variables you create must be private. For GameState.java and Streamline.java, you cannot create new instance variables at all. You must ensure that the provided instance variables always store what they are supposed to store.

**Q: Can I add helper methods?**

A: Yes. They must be private.

**Q: Can I modify the type of given variables, or the return value / name / parameters of given methods?**

A: No. 

**Q: Do I have to write test cases for this assignment?**

A: For Checkpoint, you are not required to turn in any tests; however, it is highly recommended to test your own implementation using whatever methodology you choose. The reason is simple: we test your code using our testing cases, which we use to determine your grade for the PA. A simple way to start testing, at least for checkpoint, is to "visually test" your code by running your game and seeing if it behaves correctly (i.e. writing print statements and visually confirm that the output is as you expect). 

For Final Submission, you will be required to explicitly test your code. Detail will be provided in the final submission portion of the write up.

**Q: The write-up mentioned “no hard-coding”, what is hard-coding?**

A: For this assignment, writing in your code all rotation states of all pieces is considered hard-coding. For the purpose of this assignment, no hard-coding rotation states means you cannot define any new (other than what's given in the starter code) array literals like the following, or something equivalent. Defining an array literal is something like the following: 
```java
int [][] rotated_board = {{0,1,0}, {0,1,1}, {0,0,1}};
```
Or equivalently in non-literal: 
```java
int [][] rotated_board = new int[3][3];
rotated_board[0][0] = 0;
rotated_board[0][1] = 1;
// ...
```
Make sure you do not have anything like the above in your code. You must use some nested loops of some sort.

**Q: What’s a enum and how do I use it?**

A: enum in Java is short for “enumerator”. It defines a set of constants as numeric values (literally). For this assignment, you only need to use enums as constant. For example, calling the method move() passing in the direction “left” looks like the following:
```java
move(Direction.LEFT);
```
See [Java enum documentation](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html).


## Streamline Game Rules 
**Please read through the entire write-up very carefully.** 

This section will go over how the game of Streamline works. It is important that you implement your game following the exact rules stated in this writeup. The game that this PSA is based on is https://francoisvn.itch.io/streamline. 

## Overview

There are a few main parts to the Streamline game. The Snake is the single block that the player will move and manipulate using the WASD keys. The goal is one single block in the grid that the player wants to reach. However, their path is blocked by immobile obstacles randomly distributed around the grid and the visible trail that the player has already passed through. So, the player must maneuver through the open spots to the right/up/left/down of them or retrace their steps to get to the goal. Each of these elements are denoted by a different character value. See the given constants at the top of `GameState.java` for more detail.

### The Board
Streamline is played on a rectangular grid of rows and columns. There are a number of rows and columns on the board, with a default size of 6 rows and 5 columns. The grid is initially populated with some obstacles, with a goal and player position. As the game goes on, the grid will be updated to reflect the path that the player has taken.

### The Snake
When the Snake is first created, it will start at the bottom left corner of the grid by default. However, depending on the constructor you use, you may specify a different start location. The diagram below demonstrates a Snake immediately after it is created. This means that the Snake can move up or right from its initial default position if there are open spaces available. 

![](./writeup_pics/snake_goal_board.png)

### Movement
The Snake can move in four directions from its current position: right, up, left, and down. It can only move to open spaces; the Snake cannot get past obstacles (not a flying snake) or slither on tiles where it has previously been before (it's a bit of a germaphobe). 

Once the Snake moves (i.e. the player chooses a direction to move in), it slides along a straight line and cannot stop or change direction until it hits an obstacle, itself, or the goal. If the Snake reaches the goal the player wins and the game is over! Otherwise, the Snake will do something different based on what is encountered. Each obstacle is denoted by a different char, all of which are already defined as constants for you at the top of the starter code. 

#### Goal
The Snake may encounter the goal. In this case, the Snake should move on top of the goal and the game is over. In all cases where the Snake and the Goal occupy the same space on the board, the Snake should be the one that appears. 

#### Obstacles
The Snake may encounter an obstacle. In this case, the Snake will stop at the tile before the obstacle. 

#### Walls
The Snake may hit the wall. In this case, the Snake will stop moving at the tile before the wall.

#### Trails
The Snake may encounter a tile that it has already been on previously. In this case, the Snake will stop moving at the tile before the "trail." In this sense, a "trail" is the same as an obstacle. 

#### Zappers
The Snake may encounter a zapper tile. In this case, the Snake is zapped in the direction of the zapper tile, in a straight line, until it is stopped for some other reason. If the Snake cannot move in the direction that the zapper tries to move it, then the Snake should sit still on the tile of the zapper. 


### Original Game
You can play the original game here to get a better picture: https://francoisvn.itch.io/streamline. Remember that we do not implement all the same functionalities as the original Streamline game. 

### Level Passed
A single Streamline level is passed when the player successfully guides the Snake to the goal.

## Checkpoint Implementation (GameState.java)
You will implement methods in `GameState.java` for the checkpoint submission and `Streamline.java` for the final submission. Complete all methods that are marked as TODO. You cannot change the types, name, or any signature of any provided variables/methods.

You are free to add any helper methods. **Helper methods must be private**.

You are provided with some instance and static variables. First, **read through the comments on each variable, and understand what they should store**. You **MAY NOT** add any instance variables to help your implementation, but you may add private static final variables for magic numbers. You must complete this assignment without adding any instance variables. You may not add any non-final static variables. 

**Try your best to implement this assignment in the order of this write-up. It is arranged this way to ease implementation.**

**Warning!**

* Absolutely no hard-coding! Make sure not to hard-code when checking which shape you are trying to rotate. Hard-coding is when you write down all possible array states in your code, and use them in the method bodies of `rotateCounterClockwise()`. Instead, you must use some sort of nested loops to rotate your array. There will be severe penalties for hard-coding. (See the FAQ section for more on hard-coding). Note that checking the zapper and changing it to a different zapper is not hard coding. Hard coding simply means that the method should be general enough that, for example, different board sizes contents do not break your implementation. 
* You may not add any additional instance variables to  `GameState.java` or `Streamline.java` other than what is provided. You may add instance variables only for the extra credit portion.

## GameState.java
This class, as the name suggests, defined the state of the game. It defines the grid on which we will play the game and the positions of the pieces on the board. In `Streamline.java` for the final submission, you will define how the player controls the pieces. 

### Instance Variables
**Warning:** 

**DO NOT ADD any additional instance variables to `GameState.java`**. The only place you may introduce your own instance variables is in the extra credit portion of this assignment.

#### board
```java
char[][] board
```
This is a 2D array that will hold everything in your Streamline game. Think about what `board[0]` points to and what it represents in Streamline. What about `board[0][0]`?

#### playerRow and playerCol
```java
int playerRow
int playerCol
```
These are the row and column coordinates of the player's current position.

#### goalRow and goalCol
```java
int goalRow
int goalCol
```
These are the row and column coordinates of the goal.

#### levelPassed
```java
boolean levelPassed
```
This is the flag telling the program whether the player has reached the goal or not.

### Methods

#### Constructor I
```java
public GameState(int height, int width, 
                 int playerRow, int playerCol, 
                 int goalRow, int goalCol)
```
This is the detailed constructor of GameState. 

In this constructor:

1. Initialize the board with the given parameters and fill it with `SPACE_CHAR`s.
1. Put `PLAYER_CHAR` and `GOAL_CHAR` on the board in their respective positions.
1. Initialize all other instance variables with the given parameters. Remember to initialize `levelPassed` (how do we know if the level is already over?). 

**Note**: We are not defining a no-arg constructor in GameState. Usually Java initializes an implicit no-arg constructor if we do not define any constructors at all. If a class has defined constructors, we need to explicitly define a no-arg constructor ourselves if we want to have one.

**Note**: The rows are denoted by the height and the columns are denoted by the width. The row is the first dimension in a 2-d array and the column is the second dimension. If you want the element at row `r` and column `c` of a 2-d array named `array`, assuming the indices are in-bounds, we want to use `array[r][c]`. 

**Note**: You should not do any form of "error-checking" in this constructor, you should implicitly trust the caller of the constructor. 

#### Constructor II
```java
public GameState(GameState other)
```
This is the copy constructor of GameState.

In this constructor, use GameState's detailed constructor to initialize all instance variables (not class variables) of this using the respective instance variables from `other`.

* Be sure that when copying an array, make a deep copy (completely different object with the same contents) (Hint: which instance variable do you need to deep-copy?). 
* Copy the other object exactly, you should implicitly trust the caller as with the other constructor. Do not check the input for any weird things. For example, you should not check if the height instance variable matches the height of the board instance variable. 

#### toString()
```java
public String toString()
```
Override the `toString()` method for GameState class. This method originates from the Object class in Java, and so every object created in Java inherently has a `toString()` method. 

This method should return a String representation of the calling GameState object. You need to build the String that displays all the information of the GameState object, using the String or StringBuilder methods you have learned before. 

Keep in mind that once you implement the `toString()` method, you can use it to "visually test" your code. Once you have written the constructors, you can create a new GameState object and call `toString()` to see if the board looks "correct" and corresponds to the arguments you passed into your constructor. 

Let's look at this example, we have
```
playerRow = 5
playerCol = 0
goalRow = 0
goalCol = 4
```
and a 6 x 5 game `board` that contains the following chars
```
{{'O',' ',' ',' ','G'},
 {' ','O','<',' ',' '},
 {' ',' ',' ','O',' '},
 {' ',' ','^',' ',' '},
 {' ',' ',' ',' ',' '},
 {'@',' ',' ',' ',' '}}
```
then the output of `toString()` is:
```
-------------
| O       G |
|   O <     |
|       O   |
|     ^     |
|           |
| @         |
-------------
```
**Warning**: The border characters (-) and (|) are **NOT** part of the initial 6 x 5 game board, but they should be in the returned String from `toString()`. 

Your goal is to build and return a String in the same format as the given example. Remember the following:
* There is a **space** Char between each element in a row.
* There is a **space** Char between the element and the left/right side border. There is no space after the right side border.
* There is a **newline** Char at the end of each row, **including** at the end of the last row

As an example, the second row of the board in the sample output above is the following with 'Sp' denoting a space character (bolded **Sp** = space char in `this.board`):

> |Sp**Sp**Sp**O**Sp**Sp**Sp**Sp**Sp**Sp**Sp|\n

Note that there are five bolded characters in the output above. Each bolded character represents one column of the second row on the grid. 

The `toString()` method will be automatically called when a GameState instance (object) is passed as an argument to the System's `print()` method and the user will be able to see the String on the console via standard I/O.

#### countEmptyTiles()
```java
int countEmptyTiles()
```
This method should iterate through all the tiles in `this.board` and return the total number of them that are "empty" (have value of `SPACE_CHAR`). We will use `countEmptyTiles()` as a helper method to the next two methods. 

#### addRandomObstacles()
```java
void addRandomObstacles(int count)
```
Add `count` number of obstacles (drawn on the board with `OBSTACLE_CHAR`) into `this.board` at random positions. 

Things to consider:
* If `count` is a larger number than there are empty spaces available or `count` is less than 0, `return` immediately. Do not add any obstacles.
* The location of any obstacle should **not** overwrite the player's position, the goal position, or other entities (i.e. the tile should be an empty space prior to adding the obstacle). 

You may want to use a Random object to generate random rows and columns for each obstacle. Remember that both the rows and columns of the blocks should vary. 

Random Javadocs: https://docs.oracle.com/javase/10/docs/api/java/util/Random.html


#### addRandomZappers()
```java
void addRandomZappers(int count)
```
Add `count` number of random zappers (drawn on the board with one of `*_ZAP_CHAR`) into `this.board` at random positions. Note that this will be slightly different from `addRandomObstacles()` because you have to find a random position for the zapper as well as a random zapper to place at that position. 

Things to consider: 
* If `count` is a larger number than there are empty spaces available or `count` is less than 0, `return` immediately. Do not add any zappers.
* The location of any zapper should **not** overwrite the player's position, the goal position, or other entities (i.e. the tile should be an empty space prior to adding the zapper). 


#### rotateCounterClockwise()
```java
void rotateCounterClockwise()
```
Rotate the board counter clockwise once. This rotation should account for **all instance variables**; that is, all the instance variables of GameState should be rotated as appropriate. 

**No hard-coding** (i.e. don't store all possible states of a given board and just copy the location out when `rotateCounterClockwise()` is called). You should use matrix manipulation to complete the rotation. 

Hints:

* Take out a piece of paper and pencil and draw it out. Write down the indices and what the rotated indices should be. What is the relationship between these numbers?
* The following diagram demonstrates rotating a particular 6x5 array. Your program should be able to handle rotating 2D arrays of any size.

![](./writeup_pics/rotateCounterClockwise.png)

**Note**: You will also have to rotate the zappers along with rotating their position. 

#### moveLeft()
```java
void moveLeft()
```
Move the Snake's current position (playerRow, playerCol) left (in the negative column direction) until it is stopped. Leave a trail of `TRAIL_CHAR`s for all positions on the board that were passed through before stopping (i.e. see the light blue areas on the diagram below `move()`). 

If the player reaches the goal, set `levelPassed` to `true` and `return`.

**Note**: the player and the goal **overlap** when the game ends, such that, if `moveLeft()` results in passing the level, the following should all evaluate to true:
```java
playerRow == goalRow
playerCol == goalCol
levelPassed == true
board[playerRow][playerCol] == board[goalRow][goalCol]
board[playerRow][playerCol] == PLAYER_CHAR
```

#### move()
```java
void move(Direction direction)
```
To move in any direction in Streamline is simpler than it seems! We will use `rotateCounterClockwise()` and `moveLeft()` in conjunction with each other instead of implementing methods for every single direction. 

1. Rotate some number of times to orient the Snake in the correct direction.
1. Move left. 
1. Rotate back to the original board position/orientation. 

**Hints**
* Take a look at Direction.java. It has an instance variable for how many times you should rotate. 
* Read the FAQ on the first page if you are confused about how to use enums in Java.

#### equals()
```java
public boolean equals(Object other)
```
Override the `equals()` method. In general, the `equals()` method compares two objects for equality and returns true if they are equal. This method originates from the Object class in Java, and so every object created in Java inherently has an `equals()` method, but this `equals()` method is not very useful (it is essentially just `==`) if we do not override it.

By calling this method, you compare two GameState objects -- that is, the `calling object` (i.e. **`this`**) and **`other`**. If all fields of the two GameState objects match, return `true`. Otherwise return `false`. 
* If the parameter is `null`, return `false`.
* Since the parameter is an Object type, make sure you check whether it is actually a GameState type first. To do this type checking, you should use the `instanceof` operator. Return `false` for all edge cases.

For more information about the `Object` class in Java, read the following Javadocs.
https://docs.oracle.com/javase/10/docs/api/java/lang/Object.html

At this point, you have implemented all required functionality in `GameState.java`!

Test your implementation and ensure your methods are bug-free. One way to do so is to add a (properly commented) `main()` method in `GameState.java`. Make sure to comment it out after you are done testing. In `main()`, call methods you wrote and use print statements to check correct functionality, do some equality (`==`) checks on values, and make sure your copy constructor truly does a **deep** copy. Do some visual checks with print statements as well.

It will only get harder to debug from here on out. You may continue to work on `Streamline.java` if you finish early with testing `GameState.java`.

#### How to Test
Even though it is not required that you submit your written tests to the checkpoint submission, there is no other way to make sure your code works correctly than writing some test cases and observing their behavior. For the checkpoint, because there is not yet an interactive part that we can play the game with, we test it by coding up a `main()` in GameState.java and observing its output. For instance:
```java
public static void main(String[] args) {
   // params: int height, int width, int playerRow, int playerCol, 
   //         int goalRow, int goalCol
   GameState state = new GameState(6, 5, 5, 0, 0, 4);   // modify yourself
   System.out.println(state.toString());  // print out the initial state
   state.rotateCounterClockwise();
   System.out.println(state.toString());  // print out the new state to observe it is as expected
}
```
Compile and run the code and confirm that it is behaving as expected. Similarly, to test out movement:
```java
public static void main(String[] args) {
   // params: int height, int width, int playerRow, int playerCol, 
   //         int goalRow, int goalCol
   GameState state = new GameState(6, 5, 5, 0, 0, 4);   // modify yourself
   System.out.println(state.toString());  // print out the initial state
   state.move(Direction.UP);
   System.out.println(state.toString());  // print out the new state to 
                                          // observe it is as expected
   state.move(Direction.RIGHT);
   System.out.println(state.toString());  // print out the new state to 
                                          // observe it is as expected
}
```
Write different method calls and print statements to sufficiently test out all cases and convince yourself that your program is working correctly, or fix any bug that you find, before making a submission. You may want to test out your `equals()` method as well.

## Checkpoint Submission
You must submit your `GameState.java` by **October 29th** to GradeScope.

We will not grade on style for the Checkpoint, but we will for the final submission (including both `GameState.java` when you submit it again in the final submission).

## After-Checkpoint (Streamline.java) and Extra Credit
The instructions for this portion will be added to this writeup on Saturday, October 26th, so you can get a head-start on the final submission early. 