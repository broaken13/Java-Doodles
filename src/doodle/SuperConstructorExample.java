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
public class SuperConstructorExample {
    public static void main(String[] args) {
        B thing = new B();
        A a = new B(5);
        A aa = new B(false);
    }
}

class A {

    public A() {
        System.out.println("a"); 
    }
    
    public A(int i) {
        System.out.println("a: " + i);
    }
}

class B extends A {

    public B() {
        System.out.println("b");
        // super() X - must be first statement in constructor
    }
    
    public B(int i) {
        super(i);
        System.out.println("b: " + i);
    }
    
    public B(boolean b) {
        System.out.println("^ Call default constructor if super not specified.  " + b);
    }
}