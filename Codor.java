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
public class Codor {

    private int mNumarDeplasare;
    private Mesaj mMesajCodat;
    Codor(int numarDeplasare) {
        mNumarDeplasare = numarDeplasare;
    }

    public Mesaj codeaza(Mesaj mesaj_in_clar) {
        String _mesajClar = mesaj_in_clar.toString();
        String _mesajCifrat = "";
       
        for (int i = 0; i < _mesajClar.length(); i++) {
           /* if (_mesajClar.charAt(i) == 'z') {
                _mesajCifrat = _mesajCifrat + (char)('a' + mNumarDeplasare - 1);
            } else {
                _mesajCifrat = _mesajCifrat + (char)(_mesajClar.charAt(i) + mNumarDeplasare);
            }*/
           _mesajCifrat = _mesajCifrat + criptLetter(_mesajClar.charAt(i));
        }
        mMesajCodat = new Mesaj(_mesajCifrat);
        return mMesajCodat;
    }

    private char criptLetter(char letter){
        int count = 1;
        while(count <= mNumarDeplasare){
            if(letter == 'z'){
                letter = 'a';
            }else{
                letter = (char) (letter + 1);
            }
            count ++;
        }
        return letter;
    }
}
