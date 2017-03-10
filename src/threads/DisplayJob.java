/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bjo
 */
public class DisplayJob implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 11; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep((int)(Math.random() * 20) + 40);
            } catch (InterruptedException ex) {
                System.out.println("Interrupted: " + Thread.currentThread().getName());
            }
        }
    }
    
}
