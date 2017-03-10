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
public class AvlTree<T extends Comparable> {
    private AvlTreeNode<T> root;
    
    
    public void insert(T elem) {
        AvlTreeNode<T>  newNode = new AvlTreeNode<>(elem);
        newNode.setBalanceFactor(0);
        if(root == null) {
            root = newNode;
            return;
        } 
        
        AvlTreeNode<T> current = root;
        Stack<AvlTreeNode<T>> trail = new Stack<>();
        while(current != null) {
            trail.add(current);
            if(elem.compareTo(current.getInfo()) < 0) {
                current = current.getLeft();
            } else if (elem.compareTo(current.getInfo()) > 0) {
                current = current.getRight();
            } else {
                throw new RuntimeException("No duplicates allowed");
            }
        }
        
        current = trail.pop();
        if(elem.compareTo(current.getInfo()) < 0) {
            current.setLeft(newNode);
            current.setBalanceFactor(current.getBalanceFactor() - 1);
        } else {
            current.setRight(newNode);
            current.setBalanceFactor(current.getBalanceFactor() + 1);
        }
        
        while(!trail.empty()) {
            current = trail.pop();
            current.setBalanceFactor(treeHeight(current.getRight()) - treeHeight(current.getLeft()));
            if(current.getBalanceFactor() < -1) {
                
            }
        }   
        
    }
    
    private static int treeHeight(AvlTreeNode root) {
        if(root == null) {
            return -1;
        } else {
            return Math.max(treeHeight(root.getLeft()), treeHeight(root.getRight())) + 1;
        }
    }
    
    
    public void printTree() {
        if(root == null) {
            System.out.println("Empty tree");
        } else {
            if(root.getLeft() != null) {
                printSubTrees(root.getLeft());
            }
            root.printNode();
            if(root.getRight() != null) {
                printSubTrees(root.getRight());
            }
        }
    }
    
    private void printSubTrees(AvlTreeNode node) {
        if(node.getLeft() != null) {
            printSubTrees(node.getLeft());
        }
        node.printNode();
        if(node.getRight() != null) {
            printSubTrees(node.getRight());
        }
    }
}
