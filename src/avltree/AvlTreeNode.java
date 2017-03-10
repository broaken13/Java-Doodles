/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltree;

import java.util.Stack;

/**
 *
 * @author bjo
 * @param <T>
 */
public class AvlTreeNode <T extends Comparable> {
    private T info;
    private AvlTreeNode left;
    private AvlTreeNode right;
    private int balanceFactor;
    
    
    public AvlTreeNode() {}
    public AvlTreeNode(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public AvlTreeNode getLeft() {
        return left;
    }

    public AvlTreeNode getRight() {
        return right;
    }

    public int getBalanceFactor() {
        return balanceFactor;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public void setLeft(AvlTreeNode left) {
        this.left = left;
    }

    public void setRight(AvlTreeNode right) {
        this.right = right;
    }

    public void setBalanceFactor(int balanceFactor) {
        this.balanceFactor = balanceFactor;
    }
    
    public void printNode() {
        System.out.println("Info: " + info.toString() + "\tBalance factor: " + balanceFactor);
    }
    
    
}
