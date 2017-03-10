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
public class BitCounter {
    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        System.out.println(countBits(max)); // 31
        System.out.println(countBits(5)); // 2
        System.out.println(countBits(8)); // 1
        System.out.println(countBits(15)); // 4
    }
    
    private static int countBits(int number) {
        int count = 0;
        
        while(number != 0) {
            //System.out.println(number);
            count += number & 1;
            number = number >>> 1;
            
        }        
        
        return count;
    }
}
