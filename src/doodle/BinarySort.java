/*
 *  License Overland West, Inc.  2016
 */
package doodle;

/**
 *
 * @author bjo
 */
public class BinarySort {

    public static void main(String[] args) {
        int[] test1 = new int[0];
        System.out.println(findFirstInstance(test1, 0));
        int[] test2 = {1, 2, 3, 4, 5};
        System.out.println(findFirstInstance(test2, 2));
        int[] test3 = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5};
        System.out.println(findFirstInstance(test3, 2));

        int[] test4 = {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7};
        System.out.println(findFirstInstance(test4, 3));
        System.out.println(findFirstInstance(test4, 9));
        System.out.println(findFirstInstance(test4, 1));
        System.out.println(findFirstInstance(test4, 7));

        for (int i = 0; i < test4.length; i++) {
            if (test4[i] == 7) {
                System.out.println(i);
                break;
            }
        }

    }

    public static int findFirstInstance(int[] list, int n) {
        if (list.length == 0) {
            return -1;
        }

        int lowerBound = 0, upperBound = list.length - 1, middle = (lowerBound + upperBound) / 2;

        while (lowerBound <= upperBound) {
            if (list[middle] == n && (middle == 0 || list[middle - 1] < n)) {
                return middle;
            } else if (list[middle] < n) {
                lowerBound = middle + 1;
            } else {
                upperBound = middle - 1;
            }
            middle = (lowerBound + upperBound) / 2;
        }

        return -1;

    }

}
