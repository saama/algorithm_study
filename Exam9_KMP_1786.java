package algoritmExam;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Exam9_KMP_1786 {
	/*
	 * 백준 1786
	 * 
	 */
//	ABC ABCDAB ABCDABCDABDE
//	ABCDABD
//	pi[0] = 0 (A)
//	pi[1] = 0 (AB)
//	pi[2] = 0 (ABC)
//	pi[3] = 0 (ABCD)
//	pi[4] = 1 (ABCDA)
//	pi[5] = 2 (ABCDAB)
//	pi[6] = 0 (ABCDABD)
//	3. i= 0 cnt= 0 / string[0] = A / pattern[0] = A
//	3. i= 1 cnt= 1 / string[1] = B / pattern[1] = B
//	3. i= 2 cnt= 2 / string[2] = C / pattern[2] = C
//	1. i= 3 cnt= 3 / string[3] =   / pattern[3] = D
//	2. pi[2] 0
//	cnt변경 후. i= 3 cnt= 0 / string[3] =   / pattern[0] = A
//	3. i= 4 cnt= 0 / string[4] = A / pattern[0] = A
//	3. i= 5 cnt= 1 / string[5] = B / pattern[1] = B
//	3. i= 6 cnt= 2 / string[6] = C / pattern[2] = C
//	3. i= 7 cnt= 3 / string[7] = D / pattern[3] = D
//	3. i= 8 cnt= 4 / string[8] = A / pattern[4] = A
//	3. i= 9 cnt= 5 / string[9] = B / pattern[5] = B
//	1. i= 10 cnt= 6 / string[10] =   / pattern[6] = D
//	2. pi[5] 2
//	cnt변경 후. i= 10 cnt= 2 / string[10] =   / pattern[2] = C
//	1. i= 10 cnt= 2 / string[10] =   / pattern[2] = C
//	2. pi[1] 0
//	cnt변경 후. i= 10 cnt= 0 / string[10] =   / pattern[0] = A
//	3. i= 11 cnt= 0 / string[11] = A / pattern[0] = A
//	3. i= 12 cnt= 1 / string[12] = B / pattern[1] = B
//	3. i= 13 cnt= 2 / string[13] = C / pattern[2] = C
//	3. i= 14 cnt= 3 / string[14] = D / pattern[3] = D
//	3. i= 15 cnt= 4 / string[15] = A / pattern[4] = A
//	3. i= 16 cnt= 5 / string[16] = B / pattern[5] = B
//	1. i= 17 cnt= 6 / string[17] = C / pattern[6] = D
//	2. pi[5] 2
//	cnt변경 후. i= 17 cnt= 2 / string[17] = C / pattern[2] = C
//	3. i= 17 cnt= 2 / string[17] = C / pattern[2] = C
//	3. i= 18 cnt= 3 / string[18] = D / pattern[3] = D
//	3. i= 19 cnt= 4 / string[19] = A / pattern[4] = A
//	3. i= 20 cnt= 5 / string[20] = B / pattern[5] = B
//	3. i= 21 cnt= 6 / string[21] = D / pattern[6] = D
//	1
//	16
	
	
    private static String T;
    private static String P;
    public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 문자열
		T = scan.nextLine();
		// 패턴문자열
		P = scan.nextLine();
		char[] string = T.toCharArray();
		char[] pattern = P.toCharArray();
		int[] pi = getPI(P);
		for(int i=0; i<pi.length; i++) {
        	System.out.println("pi["+i + "] = "+pi[i] + " ("+P.substring(0,i+1)+")");
        }
        List<Integer> searchIndex = new ArrayList<>();
        int n = T.length();
        int m = P.length();
        // 패턴 글자수 파악용
        int cnt = 0;
        for (int i = 0; i < n; i++) {
        	// cnt > 0 : 한 글자 라도 일치한 것이 있는지
        	// 패턴이 갖지 않으면 글자수 만큼 건너뜀
        	// cnt가 0이거나 string[i] == pattern[cnt]이면 탈출
            while (cnt > 0 && string[i] != pattern[cnt]) {
            	//무한로프돌것같았는데 cnt가 0이 되는경우에서 탈출함
            	System.out.println("1. i= "+i+" cnt= "+cnt +" / string["+i+"] = " + string[i] + " / pattern["+cnt+"] = "+pattern[cnt]);
            	System.out.println("2. pi["+(cnt - 1)+"] "+pi[cnt - 1]);
            	cnt = pi[cnt - 1];
            	System.out.println("cnt변경 후. i= "+i+" cnt= "+cnt +" / string["+i+"] = " + string[i] + " / pattern["+cnt+"] = "+pattern[cnt]);
            }
            //i와 cnt가 같으면 i,cnt모두 +1씩 되는 방식
            if (string[i] == pattern[cnt]) {
            	System.out.println("3. i= "+i+" cnt= "+cnt +" / string["+i+"] = " + string[i] + " / pattern["+cnt+"] = "+pattern[cnt]);
            	// 패턴글자수와 같으면 문자열이 일치한다고 판단
                if (cnt == m - 1) {
                    searchIndex.add(i - m + 1);
                    cnt = pi[cnt];
                } else {
                	cnt++;
                }
            }
        }
        System.out.println(searchIndex.size());
        for(Integer i : searchIndex) {
        	System.out.println(i+1);
        }
	}
public static int[] getPI(String pattern) {
        int cnt = 0;
        char[] p = pattern.toCharArray();
        int[] pi = new int[pattern.length()];
        // 1 부터 시작하는 이유는 pi[o] = 0; 이기 때문.
        for (int i = 1; i < pattern.length(); i++) {
            while (cnt > 0 && p[i] != p[cnt]) {
            	cnt = pi[cnt - 1];
            }
            if (p[i] == p[cnt]) {
                pi[i] = ++cnt;
            }
        }
        return pi;
    }
}
