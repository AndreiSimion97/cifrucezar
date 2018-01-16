/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrulluicezar;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author asimion
 */

//Server
public class PartenerRx {
    private ServerSocket mServerSocket;
    private DataInputStream mDis;
    private ObjectInputStream mOis;
    
    PartenerRx(int port) throws IOException{
        mServerSocket = new ServerSocket(port);
        Socket server = mServerSocket.accept();
        mDis = new DataInputStream(server.getInputStream());
        mOis = new ObjectInputStream(mDis);
    }
    
    public Mesaj receiveMesaj() throws IOException, ClassNotFoundException{
        Mesaj receiveMesaj = (Mesaj)mOis.readObject();
        System.out.println("Am primit mesajul : " + receiveMesaj.toString());
        return receiveMesaj;
    }
    
}
