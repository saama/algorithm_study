package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Exam34_Programers_level3_6 {
//문제풀이 참고 사이트 -> https://gurumee92.tistory.com/164
//https://programmers.co.kr/learn/courses/30/lessons/42895
//	#쓸만한 소스
	/* 
	 * 1.
		public static void main(String[] args) {
			for (int i = 1; i < 5; i++) {
				for (int j = 0; j < i; j++) {
					System.out.println(i+" "+j+" "+(i-j-1));
				}
			}
		}
		결과값->
		1 0 0
		-----
		2 0 1
		2 1 0
		-----
		3 0 2
		3 1 1
		3 2 0
		-----
		4 0 3
		4 1 2
		4 2 1
		4 3 0
		->i가 증가함에 따라 0 ~ i-1, i-1 ~ 0에 접근할수있다.
		
		2.
		Set중 HashSet이 가장 성능이 좋으며, Set은 수학의 집합과 
		비슷한 개념으로 순서 상관없고, 중복허용이 되지않는다.
		데이터 존재유무만 파악할때 유용하다.

		LinkedSet
		- 다른 Set들과 동일하게 중복은 허용하지 않으나
		.add() 한 순서대로 값이 저장된다

 		TreeSet
		- 오름차순으로 값을 정렬해 가지고 있으며
		다른 set보다 대량의 데이터를 검색할 시 훨씬 빠르다
	 */
	public int solution(int N, int number) {
		//N = 현재 숫자
		//number = 만들어야할 숫자
        int answer = -1;
        int MIN = 8;
        
        List<HashSet<Integer>>list = new ArrayList<HashSet<Integer>>();
        for (int i = 1; i <= MIN; i++) {
			HashSet<Integer> set = new HashSet<Integer>();
			set.add(f(N,i));
			list.add(set);
		}
        if(list.get(0).contains(number)) return answer = 1; //첫번째에서 일치하는경우
        //로직
//        long startTime = System.currentTimeMillis(); // 시작시간
        for (int i = 1; i < list.size(); i++) {
			for (int j = 0; j < i; j++) {
				for (Integer s : list.get(j)) {
					for (Integer ss : list.get(i-j-1)) {
						list.get(i).add(s+ss);
						list.get(i).add(s*ss);
						list.get(i).add(s-ss);
						if(ss!=0) list.get(i).add(s/ss);
					}
				}
			}
			if(list.get(i).contains(number)){
				answer = i+1;
				break;
			}
		}
//        System.out.println("완료 : " + (System.currentTimeMillis() - startTime) / 1000.0);
        System.out.println(list);
        
        return answer;
    }
	//N , NN , NNN ... 
	public int f(int N, int cnt) {
        int result = 0;
        while(cnt > 0) {
        	cnt -= 1;
        	result += N * (int)Math.pow(10, cnt); //10을 cnt만큼 제곱
        }
        return result;
	}
	
	public static void main(String[] args) {
		Exam_31 e = new Exam_31();
		int N = 5;
		int number = 1223;
		System.out.println(e.solution(N, number));
	}
}
