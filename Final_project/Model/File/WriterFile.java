package Model.File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class WriterFile {
    
    public static void writeFile(StringBuilder sb, String fileName) {
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            
            writer.write(sb.toString());
            
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + fileName);
        }
    }
}

    