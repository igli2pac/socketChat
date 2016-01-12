/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketchatinterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pm
 */
public class Java5bSocketUebung {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Parameter zut Verbindung
        String host = "localhost";
        //host = "www.raywenderlich.com";
        int port = 4000;
        
        // OutputStream Container
        PrintWriter pw = null;
        // InputStream Container
        BufferedReader br = null;
        
        try {
            // zum Host verbinden
            Socket s = new Socket(host, port);
            // Verbindung erfolgreich aufgebaut
            System.out.println("Connected");
            
            // OutputStream mit PrintWriter koppeln
            pw = new PrintWriter(s.getOutputStream(), true);
            // String der an der Server gesendet werden soll
            // zusammenstellen
            String message = JOptionPane.showInputDialog("Schrei was in den Canyon...");
            //System.out.println(message);
            // Stream mit message fuellen
            pw.println(message);
            
            // BufferedReader anlegen
            br = new BufferedReader(
                    new InputStreamReader(
                            s.getInputStream()));
            
            // Stream auslesen (Antwort vom Server)
            String response = null;
            while((response = br.readLine()) != null) {
                JOptionPane.showMessageDialog(null, response);
                //System.out.println(response);
            }
            
            // Streams schliessen
            br.close();
            pw.close();
            
            // Verbindung schliessen
            s.close();
            System.out.println("Connection closed");
        } catch (IOException ex) {
            Logger.getLogger(Java5bSocketUebung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
