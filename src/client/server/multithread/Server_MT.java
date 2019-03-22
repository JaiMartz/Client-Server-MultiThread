/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.server.multithread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Yleve
 */
public class Server_MT {
    public static void main(String[] args) {
        try{
            System.out.println("SERVER APP\n");
            Socket client = null;
            ServerSocket server = new ServerSocket(9090);
            Tarea task = null;

            while(true){
                try{
                    client = server.accept();

                    //Launch thread Tarea
                    task = new Tarea(client);
                    task.start();
                    
                }catch(Exception e){
                    e.getStackTrace();
                }
            }
        }catch(IOException ioe){}
    }
}
