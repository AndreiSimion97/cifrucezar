/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrulluicezar;

import java.io.Serializable;

/**
 *
 * @author asimion
 */

//OBS: se trimit mesaje intre PartenerRx si PartenerTx
public class Mesaj implements Serializable{
     private String mContinut;
     Mesaj(String continut){
         mContinut = continut;
     }
     
     @Override
     public String toString(){
         return mContinut;
     }
}
