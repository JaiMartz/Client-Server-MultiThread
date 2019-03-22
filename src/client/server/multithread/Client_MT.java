/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.server.multithread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Yleve
 */
public class Client_MT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ObjectOutputStream oos=null;
        ObjectInputStream ois=null;
        Socket client=null;
        System.out.println("CLIENT APP\n");
        try{
            try{
                client = new Socket("127.0.0.1", 9090);
                oos = new ObjectOutputStream(client.getOutputStream());
                ois = new ObjectInputStream(client.getInputStream());

                oos.writeObject("Jairo");

                String ret = (String) ois.readObject();

                System.out.println(ret);

            }catch(Exception ex){
            }finally{
                if(oos != null) oos.close();
                if(ois != null) ois.close();
                if(client != null) client.close();
            }
        }catch(IOException ioe){
            ioe.getStackTrace();
        }
        
        
    }
    
}
