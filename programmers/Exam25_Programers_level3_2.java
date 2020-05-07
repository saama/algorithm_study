package algorithm;

import java.util.Arrays;

public class Exam25_Programers_level3_2 {
	
	/* 규칙성
	 * 1. 접은 부분(중간값)은 무조건 0이됨
	 * 2. 중간값 기준으로 우로한칸씩 증가하는 값들은 좌로한칸씩 증가하는 값들의 반대이다
	 */
	
    public int[] solution(int n) {
        int[] answer = new int[(int)Math.pow(2,n)-1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        f(answer,n);
        return answer;
    }
    
    public void f(int[] answer,int depth) {
    	if(depth==1) {
    		answer[0]=0;
    		return;
    	}
    	//재귀함수를 여기서 써주면 가장 하위depth가 먼저 실행됨
    	f(answer,depth-1);
//    	System.out.println("depth = "+depth);
    	
    	//해당 depth의 중간index
    	int mid = (int)Math.pow(2,depth-1)-1;
    	//해당 depth의 마지막 index
    	int last = (int)Math.pow(2,depth)-2;
//    	System.out.println("mid = "+mid);
//    	System.out.println("last = "+last);
    	answer[mid]=0;
    	for (int i = 0; i < mid; i++) {
//    		System.out.println((mid+i+1)+" "+(i));
			answer[last-i] = answer[i] == 1 ? 0 : 1;
		}
//    	System.out.println(Arrays.toString(answer));
    }
    
    public static void main(String[] args) {
    	Exam_25 e = new Exam_25();
    	e.solution(3);
	}
}
