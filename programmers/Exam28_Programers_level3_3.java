package algorithm;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Exam28_Programers_level3_3 {
    //https://programmers.co.kr/learn/courses/30/lessons/17676
    public int solution(String[] lines) {
        int answer = 0;
        int counter = 1;
        List<Timestamp[]> timeList = new ArrayList<Timestamp[]>();
        
        for (int i = 0; i < lines.length; i++) {
        	Timestamp[] line = new Timestamp[2];
        	
        	//마지막시간 넣기(String 2016-09-15 20:59:57.421 -> Timestamp 2016-09-15 20:59:57.421)
        	String timeFormat = lines[i].split(" ")[0]+" "+lines[i].split(" ")[1];
        	Timestamp e = Timestamp.valueOf(timeFormat);
			line[1] = e;
			
			//시작시간 계산(2.0s -> long 2000)
			double tempRange = Double.parseDouble(lines[i].split(" ")[2].replace("s","").trim())*1000-1;
			long range = (long)tempRange;
			Timestamp s = new Timestamp(e.getTime() - range);
			line[0] = s;
			timeList.add(line);
//			System.out.println(timeList.get(i)[0].getTime()+" | "+timeList.get(i)[1].getTime());
		}
//        System.out.println("========================================");
        for (int i = 0; i < lines.length; i++) {
        	counter = 1;
			for (int j = i+1; j < lines.length; j++) {
				if(timeList.get(j)[0].getTime()<timeList.get(i)[1].getTime()+1000) {//  a[시작시간 j]<a[끝시간 i]+60
					counter++;
				}
			}
//			System.out.println(i+" "+counter);
			answer = Math.max(answer, counter);
		}
//        System.out.println(answer);
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


