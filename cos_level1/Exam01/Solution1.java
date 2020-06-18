// You may use import as below.
//import java.util.*;

import java.util.Stack;

class Solution1 {
    public long solution(long num) {
        /*9진수 숫자를 매개변수로 받아 +1 시킨수를 9진수로 반환하는 문제
        *9진수에 +1 한뒤 (+1함과 동시에 0이 포함될수있음)
        *그 숫자에 digit(1,10,100,1000...)을 나눠서 0이 되는놈(위에 말한 +1이됐을때 0이 포함되는애들)
        *에 현재 digit을 더해주어 0을 없앤다.
        */
        num++;
        long digit = 1;
        while (num / digit % 10 == 0) { //num에서 digit나눈거에 10의 나머지를 확인해야함!!
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
