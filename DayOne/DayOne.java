package DayOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DayOne {

    static Map<String, String> wordToDigit = new HashMap<>();

    static {
        wordToDigit.put("one", "1");
        wordToDigit.put("two", "2");
        wordToDigit.put("three", "3");
        wordToDigit.put("four", "4");
        wordToDigit.put("five", "5");
        wordToDigit.put("six", "6");
        wordToDigit.put("seven", "7");
        wordToDigit.put("eight", "8");
        wordToDigit.put("nine", "9");
    };

    /**
     * @param args
     */
    public static void main (String[] args) {
        PuzzleReader puzzleReader = new PuzzleReader();
        ArrayList<String> puzzle = puzzleReader.LoadPuzzle("DayOne/puzzleDemoDayOne.txt");

        Integer totalCalibrationPart1 = ResolveDayOnePartOne(puzzle);

        System.out.println(String.format("Solution to part 1 is %d", totalCalibrationPart1));

        puzzle = puzzleReader.LoadPuzzle("DayOne/puzzleDemoDayOnePart2.txt");

        Integer totalCalibrationPart2 = ResolveDayOnePartTwo(puzzle);

        System.out.println(String.format("Solution to part 2 is %d", totalCalibrationPart2));
        
    }

    private static Integer ResolveDayOnePartTwo(ArrayList<String> puzzle) {
        for (int i = 0; i < puzzle.size()-1; i++)
        {
            puzzle.set(i, parseLine(puzzle.get(i)));
        }

        return ResolveDayOnePartOne(puzzle);
    }

    private static String parseLine(String string) 
    {
        String result = "";
        int i = 0;
        while ( i < string.length())
        {
            if (isNumber(string.charAt(i)))
            {
                result = result + string.charAt(i);
            }
            for (Map.Entry<String, String> entry : wordToDigit.entrySet()) {                
                if (string.startsWith(entry.getKey(), i))
                {
                    result = result.concat(entry.getValue());
                }
            }
            i++;
        }
        
        return result;
    }

    private static Integer ResolveDayOnePartOne(ArrayList<String> puzzle) 
    {
        int number = 0;
        int totalCalibration = 0;
        for (int i=0; i< puzzle.size()-1; i++)
        {            
            
            number = findNumber(puzzle.get(i));
            totalCalibration += number;
                
        }

        return totalCalibration;
    }

    private static int findNumber(String calibString) 
    {
        int number = 0;
        char c = '\0', lastNumberChar = '\0';
        boolean isFirstNumberFound = false;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i < calibString.length(); i++)
        {
            c = calibString.charAt(i);
            if ( isNumber(c) && !isFirstNumberFound)
            {
                stringBuilder.append(c);
                isFirstNumberFound = true;
                lastNumberChar = c;
            }
            else if (isNumber(c) && isFirstNumberFound)
            {
                lastNumberChar = c;
            }
        }
        stringBuilder.append(lastNumberChar);

        number = Integer.parseInt(stringBuilder.toString());
        
        return number;
    }

    private static boolean isNumber(char c) {
        try 
        {
            String s = String.valueOf(c);
            Integer.parseInt(s);
        } 
        catch (NumberFormatException e) 
        {
            return false;
        }
        return true;
    }

}