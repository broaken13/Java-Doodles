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
public class ReverseString {
    public static void main(String[] args) {
        String s = "Reverse me!";
        
        System.out.println(reverse(s));
    }
    
    public static String reverse(String s) {
        char[] chars = s.toCharArray();
        
        for(int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        
        return new String(chars);
    }
}
