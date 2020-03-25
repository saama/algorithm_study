package algorithmExam;

import java.util.Arrays;
import java.util.Scanner;

public class Exam17_DivideAndConquer_2447 {
	static char arr[][]; //n크기만큼 2차원 배열을 생성한다.
	public static void star(int a,int b,int n) {
		int div = 0;
		if(n==1) { // 재귀 호출이 끝나는 부분 필수로 존재해야함
			System.out.println("a "+a+" b "+b+" n "+n);
			arr[a][b] = '*';
			return;
		}
		 div= n/3; // 입력받은 n 값을 계속 3씩 나눠준다.
		for(int i=0;i<3;i++) { //3x3크기의 별을 만든다.
			for(int j=0;j<3;j++) {
				if(i==1 && j ==1) continue; //현재 돌고있는 재귀함수의 1,1위치에있는곳은 *을찍지않음
				star(a+(div*i),b+(div*j),div);
				//이건 그냥 분할정복 공식인듯
				//매개변수 = 가로시작값,세로시작값,등분된길이
				//재귀함수 들어갈때의 값 
				//이전 가로시작값 + 이전 등분된 길이/등분값 * for문의 i
				//이전 세로시작값 + 이전 등분된 길이/등분값 * for문의 j
				//이전 등분된 길이/등분값
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		arr = new char[n][n];
		for(int i=0;i<arr.length;i++) {
			Arrays.fill(arr[i],' ');
		}
		star(0,0,n);
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}

