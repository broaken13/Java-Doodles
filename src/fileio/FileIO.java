/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileio;

import java.io.*;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bjo
 */
public class FileIO {
    public static void main(String[] args) {
        Path path = Paths.get("file.txt");
        
        try {
            ContactProgram contactProgram = new ContactProgram(path);
            contactProgram.run();
        } catch (Exception ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
