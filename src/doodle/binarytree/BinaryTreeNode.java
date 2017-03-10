/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doodle.binarytree;

/**
 *
 * @author bjo
 * @param <T>
 */
public class BinaryTreeNode<T> {
    private T data;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;
    
    public BinaryTreeNode() {}
    
    public BinaryTreeNode(T data) {
        this.data = data;
    }
    
    public T getData() {
        return data;
    }
    
    public void setData(T data) {
        this.data = data;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }
    
    public int leftMostLength() {
        BinaryTreeNode<T> currentNode = left;
        int count = 0;
        while(currentNode != null) {
            count++;
            currentNode = currentNode.left;
        }
        return count;
    }
    
    public int rightMostLength() {
        BinaryTreeNode<T> currentNode = right;
        int count = 0;
        while(currentNode != null) {
            count++;
            currentNode = currentNode.right;
        }
        return count;
    }
}
