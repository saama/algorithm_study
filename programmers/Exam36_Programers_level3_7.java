package algorithm;

public class Exam36_Programers_level3_7 {

	/*
	 * 	#쓸만한소스
	 *  피보나치수열 로직
	 */
	public int solution(int n) {
		int[] arr = new int[n];
		arr[0] = 1;
		arr[1] = 2;
		for (int i = 2; i < n; i++) {
			arr[i] = (arr[i-1] + arr[i-2])%1000000007;
		}
		return arr[n-1];
    }
	
	public static void main(String[] args) {
		Exam36_Programers_level3_7 e = new Exam36_Programers_level3_7();
		int n = 5;
		System.out.println(e.solution(n));
	}
}
