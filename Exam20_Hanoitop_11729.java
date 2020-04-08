package algorithmExam;

import java.util.Scanner;
/*
 * 하노이탑 : 위치 1,2,3중에 1에 N개의 탑이있을때
 * 1.한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
 * 2.아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
 * 위 규칙에 맞게 N개의 탑 전부를 3으로 옮기는 게
 * */
public class Exam20_Hanoitop_11729 {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		hanoi(N,1,2,3);
		System.out.println((int)Math.pow(2,N)-1); //장판 N이 늘어날때마다 2^n -1번의 이동횟수가됨(등비수열의 점화식)
		System.out.println(sb);
		
	}
	//그냥 하노이 로직나오면 외워야 할듯
	public static void hanoi(int n, int from ,int by, int to){
		if(n == 1){
//			System.out.println(from + " " + to);
			sb.append(from + " " + to + "\n");
			return;
		}
		hanoi(n-1, from, to, by);
//		System.out.println(from + " " + to);
		sb.append(from + " " + to + "\n");
		hanoi(n-1,by,from,to);
	}
}
