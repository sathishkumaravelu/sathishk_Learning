package mandatoryHomeWork.Week16.Day5;

import org.testng.annotations.Test;

import java.util.Arrays;

public class W16D5_AssignCookies {
    /*
        input - 2 int arrays
        output - int

        positive data -
        input : g = [1,2,3], s = [1,1]
        output : 1
        edge data -
        input : g = [1], s = [2,3,1,1]
        output : 1
        negative data : g =[3, 5, 7], s = [1, 2, 4]
        output : 1
     */

    @Test
    public void positiveData() {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        int contentChildren = findContentChildren(g, s);
        System.out.println(contentChildren);
    }
    @Test
    public void edgeData() {
        int[] g = {1};
        int[] s = {2, 3, 1, 1};
        int contentChildren = findContentChildren(g, s);
        System.out.println(contentChildren);
    }
    @Test
    public void negativeData() {
        int[] g = {3, 5, 7};
        int[] s = {1, 2, 4};
        int contentChildren = findContentChildren(g, s);
        System.out.println(contentChildren);
    }


    /*
        pseudocode:
        1. sort the given inputs
        2. keep two pointer at startChild and startCookies to zero
        3. iterate through both the cookies and child array till length of the arrays
            if greed of the child is less than or equal to cookies
            increment the cookies count and increase the startChild and startCookies pointer
           else
            increment the cookies pointer
        4. return the count

     */

    //Time Complexity - O(NlogN)
    //Space Complexity - O(1)
    public int findContentChildren(int[] g, int[] s) {
        int startChild = 0, startCookies = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        while (startChild < g.length && startCookies < s.length) {
            if (g[startChild] <= s[startCookies]) {
                count++;
                startChild++;
                startCookies++;
            } else {
                startCookies++;
            }
        }
        return count;
    }
}
