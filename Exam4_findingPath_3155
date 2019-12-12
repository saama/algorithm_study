package algoritmExam;

import java.util.Arrays;
import java.util.Scanner;

public class Exam4_findingPath_3155 {
	
	static int N; //배열의 크기가됨
	static int X=1; // 1부터 N-2까지 로직 동작
	static int Y=0;
	static int [] ceilngArr;
	static int [] floorArr;
	static int [] resultArr;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		//천장,바닥,결과 배열 초기화
		ceilngArr = new int[N];
		floorArr = new int[N];
		resultArr = new int[N];
		for (int i = 0; i < N; i++) {
			ceilngArr[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			floorArr[i] = sc.nextInt();
		}
		
//		System.out.println("N = "+N);
//		System.out.println("ceilngArr = "+Arrays.toString(ceilngArr));
//		System.out.println("floorArr = "+Arrays.toString(floorArr));
		
		//처음과 끝배열 초기화
		initResulArr();
		
		//X가 증가하지 않을때도 있으므로 for문대신 while써줌
		while(X<N-1) {
			if(isCheckBumpNextY()) {
//				System.out.println("X "+X+" Y "+Y);
				resultArr[X-1]=Y;
			}
		}
		System.out.println(Arrays.toString(resultArr).replace("[", "").replace("]", "").replace(",", ""));
	}
	
	public static boolean isCheckBumpNextY() {
		//천장이나 바닥에 닿지 않을때
		if(ceilngArr[X+1]>Y && floorArr[X+1]<Y) {
//			System.out.println("X 1증가");
			X++;
			return true;
		}else {
			//다음칸이 바닥에 닿을때
			if(floorArr[X+1]>=Y) {
//				System.out.println("Y에 바닥+1");
				Y = floorArr[X+1]+1;
			//다음칸이 천장에 닿을때
			}else if(ceilngArr[X+1]<=Y) {
//				System.out.println("Y에 천장-1");
				Y = ceilngArr[X+1]-1;
			}
			return false;
		}
	}
	public static void initResulArr() {
		resultArr[0]=0;
		resultArr[N-1]=0;
	}
}

