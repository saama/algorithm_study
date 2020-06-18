// You may use import as below.
//import java.util.*;

import java.util.Stack;

class Solution1 {
    public long solution(long num) {
        num++;
        long digit = 1;
        while (num / digit % 10 == 0) {
            System.out.println(num+" "+digit);
            num += digit;
            digit *= 10;
        }
        return num;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution1 sol = new Solution1();
//        long num = 9949999;
        long num = 99999;
        long ret = sol.solution(num);

        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret + " .");
    }
}
//1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21
//1 2 3 4 5 6 7 8 9 11 12 13 14 15 16 17 18 19 21 22 23

//22 23 24 25 26 27 28 29 30 31 32 33 34 35 36
//24 25 26 27 28 29 31 32 33 34 35 36 37 38 39
