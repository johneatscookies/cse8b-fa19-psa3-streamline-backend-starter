import java.util.*;
import java.io.*;

public class Streamline
{
    /* Provided constants */
    final static int DEFAULT_HEIGHT = 6;
    final static int DEFAULT_WIDTH = 5;
    final static String OUTFILE_NAME = "saved_streamline_game";

    /* Add your `final static` constants here */


    /* Instance variables, do not add any */
    GameState currentState;
    List<GameState> previousStates;

    public Streamline()
    {
        // TODO
    }

    public Streamline(String filename)
    {
        // TODO
    }

    protected void loadFromFile(String filename) throws IOException
    {
        // TODO
        throw IOException; // TODO: remove this
    }
    
    void recordAndMove(Direction direction)
    {
        // TODO
    } 

    void undo()
    {
        // TODO
    }

    void play()
    {
        // TODO
    }

    void saveToFile()
    {
        // TODO
    }
}
