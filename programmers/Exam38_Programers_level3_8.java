package algorithm;

public class Exam38_Programers_level3_8 {
	
	public long solution(int N) {
  //https://programmers.co.kr/learn/courses/30/lessons/43104
  //stack으로 해봤었는데 더 느렸음
  //규칙성1. N-1번째 변의 길이 하나와 N-2번째 길이 + N-1번째길이 합은
  //각각의 너비와 높히의 길이가됨
        if(N>=2){
	        long []arr = new long[N];
	        arr[0] = 1;
	        arr[1] = 1;
	        for (int i = 2; i < N; i++) {
	        	arr[i] = arr[i-2]+arr[i-1];
			}
	        long width1 = arr[arr.length-1];
	        long width2 = arr[arr.length-2]+arr[arr.length-1];
	        return width1*2+width2*2;
        }else {
        	return 4;
        }
    }
	
	public static void main(String[] args) {
		Exam38_Programers_level3_8 e = new Exam38_Programers_level3_8();
		System.out.println(e.solution(1000));
//		e.solution(80);
	}
}
