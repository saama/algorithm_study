package algorithm;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Exam33_Programers_level2_6 {
	public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
		int checkIdx = 0;
		int cnt = 0;
//		Stack<Integer> res = new Stack<Integer>();
		Queue<Integer> res = new LinkedList<>();
    	while(checkIdx<progresses.length) {
    		//로직
    		for (int i = checkIdx; i < progresses.length; i++) {
				if(progresses[i]>=100) {
					checkIdx++;
					cnt++;
				}else {
					break;
				}
			}
    		if(cnt>0) {
    			res.add(cnt);
    			cnt=0;
    		}
    		//로직 끝
    		for (int i = 0; i < progresses.length; i++) {
    			progresses[i] += speeds[i];
			}
    	}
    	answer = new int[res.size()];
    	Iterator<Integer>it = res.iterator();
    	int idx = 0;
    	while(it.hasNext()) {
    		answer[idx] = it.next();
    		idx++;
    	}
        return answer;
    }
	
	public static void main(String[] args) {
		Exam_32 e = new Exam_32();
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		System.out.println(Arrays.toString(e.solution(progresses, speeds)));
	}
}
//#천재의 풀이
//public int[] solution(int[] progresses, int[] speeds) {
//    int[] dayOfend = new int[100];
//    int day = -1;
//    for(int i=0; i<progresses.length; i++) {
//        while(progresses[i] + (day*speeds[i]) < 100) {
//        	//progresses배열의 시작부터 완료되는 시점(day)을 그다음 배열에 한번에 speed와 곱하여 ++해줘서 체크
//            day++;
//        }
//        dayOfend[day]++;
//    }
//    //[0,0,0,0,2,0,0,0,1] -> [2,1]
//    return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
//}
