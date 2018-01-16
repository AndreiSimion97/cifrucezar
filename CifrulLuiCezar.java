/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrulluicezar;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asimion
 */
public class CifrulLuiCezar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException {
       Codec codex = new Codec(2);
       Thread th1 = new Thread(new Runnable(){
            PartenerRx _prx;
           @Override
           public void run() {
               
               try {
                   _prx = new PartenerRx(5678);
               } catch (IOException ex) {
                   Logger.getLogger(CifrulLuiCezar.class.getName()).log(Level.SEVERE, null, ex);
               }
               while(true){
               try {
                   codex.decodeaza(_prx.receiveMesaj());
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(CifrulLuiCezar.class.getName()).log(Level.SEVERE, null, ex);
               }   catch (IOException ex) {
                       Logger.getLogger(CifrulLuiCezar.class.getName()).log(Level.SEVERE, null, ex);
                   }
               
           }
           }   
       });
       
       Thread th2 = new Thread(new Runnable(){
           PartenerTx _ptx;
           @Override
           public void run() {
               try {
                   // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   _ptx = new PartenerTx("127.0.0.1", 5678);
                   Mesaj msg1 = new Mesaj("anaaremere");
                   Mesaj msg2 = new Mesaj("portocala");
                   Mesaj msg3 = new Mesaj("colocviupoo");
                   _ptx.sendMesaj(codex.codeaza(msg1));
                   _ptx.sendMesaj(codex.codeaza(msg2));
                   _ptx.sendMesaj(codex.codeaza(msg3));
               } catch (IOException ex) {
                   Logger.getLogger(CifrulLuiCezar.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       
       });
       
       th1.start();
       th2.start();
       
       th2.join();
       th1.join();
    }
    
}
