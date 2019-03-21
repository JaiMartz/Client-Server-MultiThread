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
public class Tarea extends Thread {
    private Socket client = null;
    private ObjectInputStream ois = null;
    private ObjectOutputStream oos = null;
    
    public Tarea(Socket socket){
    this.client=socket;
    }
    public void run(){
        try{
            try{
                System.out.println("Connection done by IP: "+client.getInetAddress());

                ois = new ObjectInputStream(client.getInputStream());
                oos = new ObjectOutputStream(client.getOutputStream());

                String nom = (String) ois.readObject();

                String greeting = "Hi! I'm happy to see you "+nom+" - "+System.currentTimeMillis();

                oos.writeObject(greeting);

                System.out.println("Greeting sended!");


            }catch(Exception ex){
                ex.getStackTrace();
            }finally{
                if(oos != null) oos.close();
                if(ois != null) ois.close();
                if(client != null) ois.close();
            }
        }catch(IOException ioe){
            ioe.getStackTrace();
        }
    }
}
