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
public class Decodor {
    private int mNumarDeplasare;
    private Mesaj mMesajDecriptat;
    
    Decodor(int numarDeplasare){
        mNumarDeplasare = numarDeplasare;
    }
    
    public Mesaj decodeaza(Mesaj mesaj_cifrat){
        String _mesajCriptat = mesaj_cifrat.toString();
        String _mesajDecriptat = "";
        for(int i = 0; i < _mesajCriptat.length(); i++){
            /*if(_mesajCriptat.charAt(i) == 'a'){
                _mesajDecriptat = _mesajDecriptat + (char)('z' - (mNumarDeplasari - 1));
            }else{
                _mesajDecriptat = _mesajDecriptat + (char)(_mesajCriptat.charAt(i) - mNumarDeplasari);
            }*/
            _mesajDecriptat = _mesajDecriptat + decriptLetter(_mesajCriptat.charAt(i));
            mMesajDecriptat = new Mesaj(_mesajDecriptat);
        }
        
        return mMesajDecriptat;
    }
    
    private char decriptLetter(char letter){
        int count = 1;
        while(count <= mNumarDeplasare){
            if(letter == 'a'){
                letter = 'z';
            }else{
                letter = (char) (letter - 1);
            }
            count ++;
        }
        return letter;
    }
}
