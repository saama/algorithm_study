package algorithmExam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam21_LCS_9251 {
	
	/*
	 * LCS(Longest Common Subsequence)
	 * 두문자열 ABAD BAAD가있을때의 LCS는 AAD이다.
	 * 부분집합은 ABAD전부가 되지만 LCS는 순서도포함이됨
	 * 
	 * 문제해결의 포인트 점화식만들기
	 * A[last]==B[last]이면
	 * f(A[last-1],B[last-1]) + 1
	 * 
	 * A[last]!=B[last]이면
	 * MAX(f(A[last-1],B[last]),f(A[last],B[last-1]))
	 *  
	 * 각 문자열의 끝자리끼리 비교 
	 * -> 같다면 A,B의 길이 -1 후 + 1
	 * -> 같지않다면 A의 길이 -1, B의길이 또는 B의길이 -1, A의길 중 큰값반환
	 * 
	 * */
	
	static String A;
	static String B;
	static int result;
	
	public static int f(int a,int b){
		if(a==0||b==0) return 0; //재귀함수의 끝지점 지정
		int x = f(a-1,b);
		int y = f(a,b-1);
		
		int aa = 0;
		int z = f(a-1,b-1) + (A.charAt(a-1)==B.charAt(b-1)?1:0); //연산자우선순위때문에 괄호 쳐줘야함
		return Integer.max(Integer.max(x, y), z);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = br.readLine();
		B = br.readLine();

		//logic
		result = f(A.length(),B.length());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(result));
		bw.flush(); //종료
	}
}

