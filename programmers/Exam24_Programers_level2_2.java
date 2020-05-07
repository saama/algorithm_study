package algorithm;

import java.util.Arrays;

public class Exam24_Programers_level2_2 {
	
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        Arrays.fill(answer, 0); // answer배열 0으로 채움
        for (int i = heights.length-1; i >= 0; i--) {
        	answer[i] = f(heights,i);
		}
        return answer;
    }
    
    //idx부터 배열을 검사에 큰숫자가 있는 index를 반환함
    public int f(int[] arr,int idx) {
    	int start = arr[idx];
    	for (int i = idx-1; i >= 0; i--) {
			if(arr[i]>start) return i+1;
		}
    	return 0;
    }
	
	public static void main(String[] args) {
		Exam_24 e = new Exam_24();
		int[] heights = {1,5,3,6,7,6,5};
		e.solution(heights);
	}
}
