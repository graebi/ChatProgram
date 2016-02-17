package IE.DIT.CHAT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thorsten
 */
public class Client {
    
    public static void main(String[] args) {
        
        try {
            Socket client = new Socket("localhost",5555);
            System.out.println("Client started!!");
            
            //Data stream to client from server
            OutputStream out = client.getOutputStream();
            PrintWriter writer = new PrintWriter(out);
            
            //Data stream from client to server
            InputStream in = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            
            writer.write("Hi server \n");//put "\n" in for reader.readLine to regnise line end
            writer.flush();
                        
            String s = null;
            //Read in until end of line
            while ((s = reader.readLine())!=null){
                System.out.println("Received from Server: " + s);
            }//end while loop
            
            
        } catch (UnknownHostException e) {
            e.printStackTrace();
             
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
