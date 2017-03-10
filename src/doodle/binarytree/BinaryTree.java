/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doodle.binarytree;

import java.util.PriorityQueue;

/**
 *
 * @author bjo
 * @param <T>
 */
public class BinaryTree<T> {
    
    private BinaryTreeNode<T> root;
    
    public void add(T data) {
        if(root == null) {
            root = new BinaryTreeNode<>(data);
            return;
        }
        
        BinaryTreeNode<T> newNode = new BinaryTreeNode<>(data);
        BinaryTreeNode<T> workingNode = root;
        
        while(true) {
            if(workingNode.getLeft() == null) {
                workingNode.setLeft(newNode);
                return;
            } else if (workingNode.getRight() == null) {
                workingNode.setRight(newNode);
                return;
            } else {
                if(workingNode.getLeft().rightMostLength() == workingNode.getRight().rightMostLength()) {
                    workingNode = workingNode.getLeft();
                } else {
                    workingNode = workingNode.getRight();
                }
            }
        }
    }
    
    public void printLevels() {
        PriorityQueue<PriorityQueueWrapper<BinaryTreeNode<T>>> queue = new PriorityQueue<>();
        addNodeToQueue(queue, root, 0);
        
        while(!queue.isEmpty()) {
            System.out.println((int) (queue.element().getPriority()) + "  " + queue.element().getItem().getData());
            queue.remove();
        }
        
    }
    
    private void addNodeToQueue(PriorityQueue queue, BinaryTreeNode currentNode, double level) {
        if(currentNode != null) {
            queue.add(new PriorityQueueWrapper<>(currentNode, level));
            addNodeToQueue(queue, currentNode.getLeft(), level+1);
            addNodeToQueue(queue, currentNode.getRight(), level + 1 + (1 / Math.pow(2, Math.floor(level + 1))));
        }
    }
}

class PriorityQueueWrapper<T> implements Comparable<PriorityQueueWrapper<T>>{
    private double priority;
    private T item;
    
    public PriorityQueueWrapper(T item, double priority) {
        this.item = item;
        this.priority = priority;
    }

    @Override
    public int compareTo(PriorityQueueWrapper<T> o) {
        if(this.priority == o.priority) {
            return 0;
        } else if(this.priority < o.priority) {
            return -1;
        } else {
            return 1;
        }
    }
    
    public double getPriority() {
        return priority;
    }
    
    public T getItem() {
        return item;
    }
}