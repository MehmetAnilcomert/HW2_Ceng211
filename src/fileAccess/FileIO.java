package fileAccess;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads files and returns ArrayList of String lines <br>
 * If the file not found, program exits <strong>with status code 1</strong>.
 */
public class FileIO {
	
	/**
	 * Reads files and returns ArrayList of String lines <br>
	 * If the file not found, program exits <strong>with status code 1</strong>.
	 */
	public static ArrayList<String> readCsv(String filePath) {
        ArrayList<String> soldArrayList = new ArrayList<>(); // an ArraList to put selling informations in.
        // Try-catch usage for prevent leaks.
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) soldArrayList.add(scanner.nextLine());
            scanner.close();
        } 
        catch (FileNotFoundException error) {
            System.out.println("File not found: "+filePath);
            System.exit(1);
        }
        return soldArrayList;
    }
}
