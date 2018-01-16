/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrulluicezar;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author asimion
 */

//Client
public class PartenerTx {
   private Socket mSocket;
   private DataOutputStream mDos;
   private ObjectOutputStream mOos;
   
   PartenerTx(String host, int port) throws IOException{
       mSocket = new Socket(host, port);
       mDos = new DataOutputStream(mSocket.getOutputStream());
       mOos = new ObjectOutputStream(mDos);
   }
   
   
   public void sendMesaj(Mesaj msg) throws IOException{
       mOos.writeObject(msg);
       System.out.println("Am trimis :" + msg);
       //mOos.close();
   }
   
}
