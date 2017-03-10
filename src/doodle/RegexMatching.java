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
public class RegexMatching {
        public static void main(String[] args) {
        
        String[] strings = {"LC123421mn", "TR98392332", "Bobby kicked the ball", "801-123-9875", "EM998838pu", "12-546-2323-9090-76123", "UY902bb", "192389-19823", "RQ9068q3"};
        
        System.out.println("Error Codes: ");
        for(String s : strings) {
            
            if(s.matches("[A-Z]{2}[0-9]{6}..")) {
                System.out.println(s);
            }
        }
        System.out.println();
        
        System.out.println("Dashed Numbers: ");
        for(String s : strings){
            if(s.matches("(([0-9]+)-)+[0-9]+")) {
                System.out.println(s);
            }
        }
        System.out.println();
        
        System.out.println("Error Codes V2: ");
        for(String s : strings) {
            if(s.matches("[A-Z]{2}[0-9]{3,6}..")) {
                System.out.println(s);
            }
        }
        System.out.println();
        
        String combined = String.join(";\n", strings);
        System.out.println(combined);
        
    }
}
