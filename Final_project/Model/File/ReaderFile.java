package Model.File;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;




public class ReaderFile {

    //  try (Scanner scanner = new Scanner(new File(fileName)))
    public static Scanner readFile(String fileName) {

        Scanner scanner = null;
  
        try  {
            
            scanner = new Scanner(new File(fileName));
              
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + fileName);
        }
        
        return scanner;
       
    }
}


/*
public class ReaderFile {

    //  try (Scanner scanner = new Scanner(new File(fileName)))
    public static Scanner readFile(String fileName) {

        Scanner scanner = null;
  
        try  {
            
            scanner = new Scanner(new File(fileName));
              
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + fileName);
        }
        
        return scanner;
       
    }
}
*/