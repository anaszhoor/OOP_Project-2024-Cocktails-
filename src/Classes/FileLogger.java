package Classes;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger {
    
    private String filePath;
    
    
    public FileLogger (String filePath){
        this.filePath = filePath;
    }
    
    @Override
    public void log(String message){
        try {
            FileWriter fw = new FileWriter(this.filePath , true);
            fw.write(message);
            fw.close();
        } catch (IOException ex) {
            System.out.println("Something wrong!!");
        }
    }
        
    
}
