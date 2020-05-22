package algorithm;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Exam28_Programers_level3_3 {
	//https://programmers.co.kr/learn/courses/30/lessons/17676
	/*
	 * ###쓸만한 소스###
	 * String -> Timestamp 형식으로 바꿔 문자열 -> 숫자로 시간을 처리하는것이아닌
	 * Timestamp.getTime()으로 간단하게 숫자연산을 할 수 있음
	 * Double형은 실수 long은 정수형!
	 * 따라서 '2.0'같은 문자열은 Double형으로 받아줘야함(long으로 안됨)
	 * */
    public int solution(String[] lines) {
        int answer = 0;
        int counter = 1;
        List<Timestamp[]> timeList = new ArrayList<Timestamp[]>();
        
        //문자열가공
        for (int i = 0; i < lines.length; i++) {
        	Timestamp[] line = new Timestamp[2];
        	
        	//마지막시간 넣기(String 2016-09-15 20:59:57.421 -> Timestamp 2016-09-15 20:59:57.421)
        	String timeFormat = lines[i].split(" ")[0]+" "+lines[i].split(" ")[1];
        	Timestamp e = Timestamp.valueOf(timeFormat);
			line[1] = e;
			
			//시작시간 계산(2.0s -> long 2000)
			double tempRange = Double.parseDouble(lines[i].split(" ")[2].replace("s","").trim())*1000-1; //문제를 잘보고 끝시간의 범위를 잘 생각해야함
			long range = (long)tempRange;
			Timestamp s = new Timestamp(e.getTime() - range);
			line[0] = s;
			timeList.add(line);
		}
        //끝
        //로직 시작
        for (int i = 0; i < lines.length; i++) {
        	counter = 1;
			for (int j = i+1; j < lines.length; j++) {
				if(timeList.get(j)[0].getTime()<timeList.get(i)[1].getTime()+1000) {//  list[시작시간 j]<list[끝시간 i]+1000(1초)
					counter++;
				}
			}
			answer = Math.max(answer, counter);
		}
        //끝
        return answer;
    }
    //2개의 시간을 매개변수로하고 1
    public void f() {
    	
    }
    public static void main(String[] args) {
		Exam_28 e = new Exam_28();
//		String []lines = 
//			{
//				"2016-09-15 01:00:04.001 2.0s",
//				"2016-09-15 01:00:07.000 2s"
//			};
//		String []lines = 
//			{
//				"2016-09-15 01:00:04.002 2.0s",
//				"2016-09-15 01:00:07.000 2s"
//			};
		String []lines =
			{
				"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"
			};
//		e.solution(lines);
		System.out.println(e.solution(lines));
	}
}
