import java.io.*;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        //file name and location -> feed into file object -> to FileReader -> to FileBuffer
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

            // Closing file
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");


        }
    }
    public static void createArrayFromFile(String line) {
        // create array object from line and convert to character array
        char[] array = line.toCharArray();
        char[][] newArray = new char[20][45];

        // create index external to the loop to keep track of character in array
        int i = 0;


        // instantiate newArray with values from input.txt (held in array)
        for (int row = 0; row < newArray.length; row++) {
            for (int column = 0; column < newArray[row].length; column++) {
                if (i > array.length - 1) {
                    newArray[row][column] = '@';
                } else {
                    // convert spaces to _ before assigning to matrix
                    if (array[i] == ' ') {
                        array[i] = '_';
                    }
                    newArray[row][column] = array[i];
                    i++;
                }
            }
        }


        // this is where i'm having issues.
       for (int row = 0; row < newArray.length; row++) {
            for (int column = 0; column < newArray[row].length; column++) {
                System.out.print(newArray[row][column]);

            }
        }

        // display matrix
       /* for (char[] a : newArray) {
        *   for (char b : a) {
        *       System.out.print(b + "\t");
        *   }
        *   System.out.println("\n"); }
        */

    }
}
