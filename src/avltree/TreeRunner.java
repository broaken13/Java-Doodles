/*
 *  License Overland West, Inc.  2016
 */

package avltree;

/**
 *
 * @author bjo
 */
public class TreeRunner {
    public static void main(String[] args) {
        AvlTree<Integer> tree1 = new AvlTree<>();
        tree1.insert(5);
        tree1.insert(7);
        tree1.insert(2);
        tree1.insert(4);
        tree1.insert(3);
        tree1.insert(6);
        tree1.insert(8);
        tree1.printTree();
    }

}
