/*
 *  License Overland West, Inc.  2016
 */

package doodle;

/**
 *
 * @author bjo
 */
public class StringFormat {
    public static void main(String[] args) {
        System.out.println(String.format("%25s %s", "Hi there", "()").replace(" ", "-"));
        System.out.println(String.format("%-25s %s", "Hi there", "()"));
        System.out.println(String.format("%-5s %s", "Hi there", "()"));
    }
}
