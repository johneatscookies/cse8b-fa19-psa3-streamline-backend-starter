import java.util.*;

public class GameState
{
    /* Provided constants */
    final static char PLAYER_CHAR = '@';
    final static char GOAL_CHAR = 'G';
    final static char SPACE_CHAR = ' ';
    final static char TRAIL_CHAR = '+';
    final static char OBSTACLE_CHAR = 'O';
    final static char DOWN_ZAP_CHAR = 'v'; 
    final static char UP_ZAP_CHAR = '^'; 
    final static char LEFT_ZAP_CHAR = '<'; 
    final static char RIGHT_ZAP_CHAR = '>'; 
    final static char NEWLINE_CHAR = '\n';
    final static char HORIZONTAL_BORDER_CHAR = '-';
    final static char SIDE_BORDER_CHAR = '|';

    /* Add your `final static` constants here */


    /* Instance variables, do not add any */
    char[][] board; // 2-D array containing the tiles of the board, each tile has a value
    int playerRow; // the row of the playerin the board (0-indexing), access using board[playerRow][playerCol]
    int playerCol; // the column of the player in the board (0-indexing)
    int goalRow; // the row of the goal in the board (0-indexing)
    int goalCol; // the colum of the goal in the board (0-indexing)
    boolean levelPassed; // denotes whether the level is passed

    public GameState(int height, int width, int playerRow, int playerCol, int goalRow, int goalCol)
    {
        // TODO
    }


    public GameState(GameState other)
    {
        // TODO
    }

    int countEmptyTiles()
    {
        // TODO
        return -1; 
    }

    void addRandomObstacles(int count)
    {
        // TODO
    }

    void addRandomZappers(int count)
    {
        // TODO   
    }

    int indexOfZapper(char zapChar)
    {
        // TODO
        return -1; 
    }

    void rotateCounterClockwise()
    {
        // TODO
    }

    void moveLeft()
    {
        // TODO 
    }

    void move(Direction direction)
    {
        // TODO
    }


    @Override
    public String toString()
    {
        // TODO
        return null; 
    }


    @Override
    public boolean equals(Object other)
    {
        // TODO
        return false;
    }
}
