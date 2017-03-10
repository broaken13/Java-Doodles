/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doodle;

import javax.crypto.IllegalBlockSizeException;

/**
 *
 * @author bjo
 * 
 * Trying to see if rethrowing exceptions changes them
 */
public class ExceptionExample {

    public static void main(String[] args) {
        try {
            middleFunc(false, true);
        } catch (IllegalAccessException e) {
            System.out.println("Illegal Access");
        } catch (IllegalBlockSizeException e) {
            System.out.println("Block size");
        } catch (Exception e) {
            System.out.println("Basic exception");
        }
    }

    private static void middleFunc(boolean thr, boolean first) throws Exception {
        try {
            errorFunc(thr, first);
        } catch (Exception e) {
            throw e;
        }
    }

    private static void errorFunc(boolean thr, boolean first) throws Exception {
        if (thr) {
            if (first) {
                throw new IllegalAccessException();
            } else {
                throw new IllegalBlockSizeException();
            }
        }
        throw new Exception();
    }

}
