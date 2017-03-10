/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doodle;

/**
 *
 * @author bjo
 */
public class CharToBytesToChars {
    public static void main(String[] args) {
        char a = 'a', b = '\u5555';
        System.out.println(b);
        byte[] charBytes = new byte[4];
        charBytes[3] = (byte) (b);
        charBytes[2] = (byte) (b >>> 8);
        charBytes[1] = (byte) (a);
        charBytes[0] = (byte) (a >>> 8);
        System.out.println((char)((charBytes[2] << 8) + charBytes[3]));
        
        char[] putTogether = new char[2];
        char workingChar = ' ';
        for(int i = 0; i < charBytes.length; i++) {
            if(i % 2 == 0) {
                workingChar = (char) (charBytes[i] << 8);
            } else {
                workingChar += charBytes[i];
                putTogether[i/2] = workingChar;
            }
        }
        System.out.println(new String(putTogether));
    }
}
