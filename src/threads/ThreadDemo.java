/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author bjo
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new DisplayJob(), "Thread 1");
        Thread thread2 = new Thread(new DisplayJob(), "Thread 2");
        Thread thread3 = new Thread(new DisplayJob(), "Thread 3");
        
        thread1.start();
        thread2.start();
        thread3.start();
    }
    
}
