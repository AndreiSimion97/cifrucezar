/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrulluicezar;

/**
 *
 * @author asimion
 */
public class Codec {
    private Codor mCodor;
    private Decodor mDecodor;
    
    Codec(int numarDeplasare){
        mCodor = new Codor(numarDeplasare);
        mDecodor = new Decodor(numarDeplasare);
    }
    
    public Mesaj codeaza(Mesaj mesajNecodat){
        Mesaj criptedMsg = mCodor.codeaza(mesajNecodat);
        System.out.println("Mesaj codat: " + criptedMsg.toString() + " Mesaj original( " + mesajNecodat.toString() + " )");
        return criptedMsg;
    }
    
    public void decodeaza(Mesaj mesajCodat){
        Mesaj decriptedMsg = mDecodor.decodeaza(mesajCodat);
        System.out.println("Mesaj decodat: " + decriptedMsg.toString() + " Mesaj criptat( " + mesajCodat.toString() + " )");
    
    }
}
