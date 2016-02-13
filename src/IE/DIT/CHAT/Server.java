package IE.DIT.CHAT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thorsten
 */
public class Server {
    public static void main(String[] args){
        
        try { 
            //Creating socket
            ServerSocket server = new ServerSocket(5555);
            System.out.println("Server started!!");
            
            //Connection which is comming from client to server
            Socket client = server.accept();
            
            //Data stream to client from server
            OutputStream out = client.getOutputStream();
            PrintWriter writer = new PrintWriter(out);
            
            //Data stream from client to server
            InputStream in = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
