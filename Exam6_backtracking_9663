package algoritmExam;

import java.util.Arrays;
import java.util.Scanner;



public class Exam6_backtracking_9663 {
	static int ans, n; //ans 결과갯수, 퀸의갯수 n와 체스판의 크기 n * n
	static int[] rowNumArr;
//	[0, 1, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0] 
//	위 모양은 아래를 의미
//	■□□□□...
//	□□■□□...
//	□□□□□...
//	□■□□□...
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    n = sc.nextInt();
		 
	    for (int i = 1; i <= n; i++) {
	        rowNumArr = new int[15]; //15는 단순 체스판 최대크기를 임시로 정해놓은것 n>15가되면 소스상 에러
	        rowNumArr[1] = i; //i는 맨첫번째열의 행넘버가 됨 , 0은 배열index 이해하기 쉽도록 비워놓은거같음
	        dfs(1);
	    }
	    System.out.println(ans);
	    sc.close();
	}
	
	//col 현재 배열의 위치 [0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	public static void dfs(int col) {
//		System.out.println("col "+col);
//		System.out.println("rowNumArr "+Arrays.toString(rowNumArr));
	    if (col == n) { //col이 n까지 돌아도 백트래킹하지 않았기때문에 가능한 결과갯수가 1개 늘어남
	        ++ans;
	    } else {
	        for (int i = 1; i <= n; i++) { //행의 대한 for문
	            rowNumArr[col + 1] = i; // (행을 위에서 아래로 내려가면서)
	            if (isPossible(col + 1)) {//유망한지 판단후 dfs
	                dfs(col + 1);
	            } else {//가볼 필요도없으니 0대입
	            	//col에 대한 백트래킹
	                rowNumArr[col + 1] = 0;    
	            }
	        }
	    }
	    //마지막 재귀함수까지 들어갔으면 현재 배열의 위치에 0을 넣어줌(모두 탐색했다는 의미)
	    //(결과값 ans는 이미 계산이 된 상태)
	    rowNumArr[col] = 0;
	}
	 
	public static boolean isPossible(int c) {
	 
	    // 이전 열들을 탐색하면서 배치 가능 여부 확인
	    for (int i = 1; i < c; i++) {
	        // 같은 행인지 비교
	        if (rowNumArr[i] == rowNumArr[c]) {
//	        	System.out.println("동일 행");
	            return false;
	        }
	        // 대각선상에 있는지 비교
	        if (Math.abs(rowNumArr[i] - rowNumArr[c]) == Math.abs(i - c)) {
//	        	System.out.println("동일 대각선");
	            return false;
	        }
	    }
	    return true;
	}

}

