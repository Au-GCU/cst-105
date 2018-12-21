/**
 * @author Jack Hall
 * @course CST-105
 * @professor Amr Elchouemi
 * <p>
 * This code was written by me for class - week 4.
 * @since 12-20-2018
 */

import java.io.*;

public class TwoDimensionalArray {
    /**
     * Main method
     * Sorry to go crazy on the javadoc comments - I am learning to use them
     *
     * @param args Not used
     * @return nothing
     * @throws IOException
     * @throws FileNotFoundException
     * @see FileNotFoundException
     * @see IOException
     */
    public static void main(String[] args) {
        //file name and location -> feed into file object -> to FileReader -> to FileBuffer. Again - had to use absolute path for IDE. Relative path works for javac in console.
        String fileName = "C:\\Users\\jackv\\IdeaProjects\\TwoDimensionalArray\\out\\production\\TwoDimensionalArray\\input.txt";
        File file = new File(fileName);
        String line = null;

        try {
            // FileReader reads text file
            FileReader fileReader = new FileReader(file);

            // wrapping FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                createArrayFromFile(line);
            }

            // Closing file - I'm just using same exceptions as tutorial.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }

    /**
     * createArrayFromFile method:
     * This method includes the output function.
     * @param line
     * @return nothing
     */
    public static void createArrayFromFile(String line) {
        // create array object from line and convert to character array
        char[] array = line.toCharArray();
        char[][] newArray = new char[20][45];

        // create index external to the loop to keep track of character in array
        int i = 0;

        // instantiate newArray with values from input.txt (held in array)
        for (int row = 0; row < newArray.length; row++) {
            for (int column = 0; column < newArray[row].length; column++) {
                // logic for filling unused space with @
                if (i > array.length - 1) {
                    newArray[row][column] = '@';
                } else {
                    // convert spaces to _ before assigning to matrix
                    if (array[i] == ' ') {
                        array[i] = '_';
                    }
                    // assign value to coordinate [row] x [column] in newArray
                    newArray[row][column] = array[i];
                    i++;
                }
            }
        }
        /* Above I instantiated by using for loop to populate elements.
           The for loop for displaying in column major order must occur
           with columns first and rows iterating inside the column loop.
           Basically the opposite of the instantiation loop. */
        StringBuilder string = new StringBuilder();
        for (int column = 0; column < newArray[0].length; column++) {
            for (int row = 0; row < newArray.length; row++) {
                string.append(newArray[row][column]);
            }
        }
        System.out.println(string);
    }
}
