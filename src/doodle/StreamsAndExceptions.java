/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doodle;

import java.util.ArrayList;

/**
 *
 * @author bjo
 */
public class StreamsAndExceptions {
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        for(int i = 1; i <= 40; i++) {
            ints.add(i);
        }
        
        ints.stream().forEach(i -> {
            if (i == 25) {
                throw new IllegalArgumentException();
            }
            print(i);
        });
        System.out.println("Don't come here");
    }
    
    public static void print(Integer i) {
        
        System.out.println(i);
    }
}
