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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pm
 */
public class EchoServer {

    /**
     * @param args the command line arguments
     */
        static PrintWriter pw = null;
        // InputStream Container
        static BufferedReader br = null;
        private String request;
        private String response;

    public static void main(String[] args) {

        System.out.println("main");
        
    }
    EchoServer(){
        System.out.println("Request");
        int port = 4000;
        interfaceGUI ig = new interfaceGUI();
        
        // OutputStream Container
        
        try {
            System.out.println("Hi?");
            // Socketverbindung auf Port 4199 öffnen
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started on port " +port);
            
            System.out.println("Waiting for connection...");
            
            // wartet auf eine Client-Verbindung
            Socket s = server.accept();
            System.out.println("Client connected");
            
            // Streams anlegen
         
            // BufferedReader anlegen
            
            
            
            // Client-Anfrage verarbeiten
            
            //System.out.println("Request from Client: " + request);

            
            // Verbindungen schliessen
            pw = new PrintWriter(s.getOutputStream(), true);
            br = new BufferedReader(
               new InputStreamReader(
                       s.getInputStream()));

            
            while(server.isClosed() == false){
            
            setRequest(br.readLine());
            
            String response = JOptionPane.showInputDialog(request);
            pw.println(getResponse());
            
           
            }
           
            br.close();
                pw.close();
                s.close();
                server.close();
            System.out.println("Server closed");
        } catch (IOException ex) {
            Logger.getLogger(EchoServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the request
     */
    public String getRequest() {
        return request;
    }

    /**
     * @param request the request to set
     */
    public void setRequest(String request) {
        this.request = request;
    }

    /**
     * @return the response
     */
    public String getResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(String response) {
        this.response = response;
    }
    
}
