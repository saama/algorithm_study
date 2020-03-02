package algoritmExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exam15_DivideAndConquer_1780 {
	
	public static int N;
	public static int [][]paper;
	public static int paperCntMinusOne=0;
	public static int paperCntZero=0;
	public static int paperCntOne=0;
	public static int depthCnt=0;
	
	public static void main(String[] args) throws Exception {
		
		
//9
//0 0 0 1 1 1 -1 -1 -1
//0 0 0 1 1 1 -1 -1 -1
//0 0 0 1 1 1 -1 -1 -1
//1 1 1 0 0 0 0 0 0
//1 1 1 0 0 0 0 0 0
//1 1 1 0 0 0 0 0 0
//0 1 -1 0 1 -1 0 1 -1
//0 -1 1 0 1 -1 0 1 -1
//0 1 -1 1 0 -1 0 1 -1
		
		/*입력받기*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		paper = new int[N][N];
		for (int i = 0; i < paper.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < paper[i].length; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/*입력받기 끝*/
		dividePaper(paper);
		System.out.println(paperCntMinusOne);
		System.out.println(paperCntZero);
		System.out.println(paperCntOne);
	}
	//종이를 3*3으로 나누는 함수(재귀)
	public static void dividePaper(int [][]targetPaper) {
//		showArr(targetPaper);
			if(checkPaper(targetPaper)) { //배열의 숫자가 모두 같으면 해당 숫자 cnt++
				if(targetPaper[0][0]==-1) paperCntMinusOne++;
				if(targetPaper[0][0]==0) paperCntZero++;
				if(targetPaper[0][0]==1) paperCntOne++;
			}else{ //각숫자들이 3*3등분 가능하고 배열의 숫자들이 같지 않음
				int s = targetPaper.length/3;
				int [][]tempPaper = new int[s][s];
					//3*3등분하는 작업시작
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							//tempPaper만들기(원래 배열에서 3*3등분된 배열)
							for (int k = i*s; k < i*s+s; k++) {
								for (int a = j*s; a < j*s+s; a++) {
									tempPaper[k-i*s][a-j*s]=targetPaper[k][a];
									//temPaper 0부터 시작하기 위함
								}
							}
							dividePaper(tempPaper);
						}
					}
				}
	}
	//종이의 구성이 같은숫자로 이루어졌는지 체크
	public static boolean checkPaper(int [][]paper) {
		boolean isSame = true;
		int first = paper[0][0];
		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper[i].length; j++) {
				if(first != paper[i][j]) isSame = false;
			}
		}
		return isSame;
	}
	public static void showArr(int [][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}

