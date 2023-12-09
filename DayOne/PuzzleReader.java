package DayOne;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class PuzzleReader {

    public PuzzleReader() {
        super();
    }

    public ArrayList<String> LoadPuzzle(String path)
    {
        ArrayList<String> puzzle = new ArrayList<String>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String currentLine = "";
            while (currentLine != null)
            {
               currentLine = reader.readLine();
               puzzle.add(currentLine);
            }            
            reader.close();
        }
        catch(Exception e)
        {
            return null;
        }
        return puzzle;
    }
}
