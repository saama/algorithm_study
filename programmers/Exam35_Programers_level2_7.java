package algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Exam35_Programers_level2_7 {
	public int solution(int[] priorities, int location) {
		//https://programmers.co.kr/learn/courses/30/lessons/42587
		/*
		 * #쓸만한 소스
		 * int[] -> List<Integer>
		 * List<Integer> list  = Arrays.stream( priorities ).boxed().collect( Collectors.toList() );
		 * 
		 * List<Integer> -> ArrayDeque<Integer>
		 * ArrayDeque<Integer> ad = new ArrayDeque<>(list);
		 * 
		 */
		
		List<Map> list = new ArrayList<Map>();
		for (int i = 0; i < priorities.length; i++) {
			Map<String,Integer> map = new HashMap<String,Integer>();
			map.put("first", i); //A , B , C , D 
			map.put("second", priorities[i]); //출력 우선순위
			list.add(map);
		}
		ArrayDeque<Map> ad = new ArrayDeque<>(list);
		
		 List<Map> res = new ArrayList<>();
		 while(!ad.isEmpty()) {
			 boolean flag = true;
			 Map first = ad.pollFirst();
			 Iterator<Map>it = ad.iterator();
			 while(it.hasNext()) {
				 if((int)first.get("second")<(int)it.next().get("second")) {
					 ad.addLast(first);
					 flag = false;
					 break;
				 }
			 }
			 if(flag) {
				 res.add(first);
			 }
		 }
		 int answer = 0;
		 for (int i = 0; i < res.size(); i++) {
			if((int)res.get(i).get("first")==location) {
				answer = i+1;
				break;
			}
		}
	        return answer;
	}
	public static void main(String[] args) {
		Exam_33 e = new Exam_33();
		int [] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		System.out.println(e.solution(priorities, location));
	}
}
