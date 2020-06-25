package algorithm;

public class Exam37_Programers_level2_8 {
	
	public String solution(int n) {
        int val = 0;
        StringBuffer sb = new StringBuffer();
        while(n>0) {
        	val = n / 3;
        	if(n%3==0) {
        		val--;
        		sb.append(4);
        	}else{
        		sb.append(n%3);
        	}
        	n = val;
        }
        return sb.reverse().toString();
    }
	
	public static void main(String[] args) {
		Exam_35 e = new Exam37_Programers_level2_8();
		e.solution(60);
		/*
		 * 7  21
		 * 8  22
		 * 9  24
		 * 10 41
		 * 11 42
		 * 12 44
		 * 13 111
		 * 14 112
		 * 15 114
		 * 16 121
		 * 17 122
		 * 18 124
		 * 19 141
		 * 20 142
		 * 21 144
		 * 22 211
		 * 1 2 4 11 12 14 21 22 24 41 42 44
		 * 
		 * 3으로 나눈 나머지가 1이면 1
		 * 				  2이면 2
		 * 				  0이면 4 
		 * 
		 * 3...1             1
		 * 1...0			 4
		 * 					 2
		 */
	}
}
