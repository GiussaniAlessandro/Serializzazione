/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializzazione;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giussani.alessandro
 */
public class Serializzazione {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
    Studente s= new Studente("Tommaso","Galimberti",12);
    
        try {
            FileOutputStream FO = new FileOutputStream("test.ser");
            ObjectOutputStream OS= new ObjectOutputStream(FO);
            OS.writeObject(9);
            OS.writeObject("CIAO");
            float a=(float)0.345;
            OS.writeObject(a);
//            OS.writeObject(false);
//            OS.writeObject('i');
            OS.flush();
            OS.close();
            FO.close();
          FileInputStream FI= new FileInputStream("test.ser");  
          ObjectInputStream IS= new ObjectInputStream(FI);
          int v1=(int) IS.readObject();
            System.out.println("v1: "+v1);
            String v2=(String) IS.readObject();
            System.out.println("v2: "+v2);
            Double v3=(Double) IS.readObject();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Serializzazione.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("impossibile trovare il file");
        } catch (IOException ex) {
            Logger.getLogger(Serializzazione.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Hai rotto java");
        }
    
    }
    
}
