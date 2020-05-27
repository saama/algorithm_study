package algorithm;

public class Exam31_Programers_level2_5_ing {
	
	 public int solution(String arrangement) {
	        int answer = 0;
	        arrangement = arrangement.replace("()", ".");
//	        StringBuffer sb = new StringBuffer(arrangement);
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < 3000; i++) {
	        	sb.append("(");
			}
	        for (int i = 0; i < 5000; i++) {
	        	sb.append(".");
			}
	        for (int i = 0; i < 3000; i++) {
	        	sb.append(")");
			}
	        
	        long startTime = System.currentTimeMillis(); // 시작시간
	        answer = f(sb,answer);
	        System.out.println(answer);
	        System.out.println("완료 : " + (System.currentTimeMillis() - startTime) / 1000.000);
	        return answer;
	    }
	 public int f(StringBuffer sb, int answer) {
		 if(sb.indexOf("(")==-1) return answer;
//	        System.out.println(sb);
	        for (int i = 0; i < sb.length(); i++) {
	        	String sBrack = Character.toString(sb.charAt(i));
	        	if("(".equals(sBrack)) {
	        		for (int j = i+1; j < sb.length(); j++) {
	        			String eBrack = Character.toString(sb.charAt(j));
	        			if("(".equals(eBrack)) {
	        				break;
	        			}else if(")".equals(eBrack)) {
//	        				System.out.println(i+"  "+j);
	        				//로직
	        				answer += j-i;
	        				sb.deleteCharAt(i);
	        				sb.deleteCharAt(j-1);
	        				//로직끝
	        				break;
	        			}
					}
	        	}
			}
//	        System.out.println(answer);
//	        System.out.println(sb);
//	        System.out.println("============");
	        return f(sb,answer);
	 }
	
	public static void main(String[] args) {
		Exam_29 e = new Exam_29();
		String arrangement = "()(((()())(())()))(())";
//		.(((..)(.).))(.)
		e.solution(arrangement);
	}
}
