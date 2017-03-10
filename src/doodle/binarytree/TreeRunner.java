/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doodle.binarytree;

/**
 *
 * @author bjo
 */
public class TreeRunner {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        
        for(int i = 31; i > 0; i--) {
            tree.add((int) (Math.random() * 1000));
        }
        
        tree.printLevels();
        
    }
}
