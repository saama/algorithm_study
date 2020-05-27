package algorithm;

public class Exam31_Programers_level2_5 {
	
	 public int solution(String arrangement) {
		 /* https://programmers.co.kr/learn/courses/30/lessons/42585
		  * #속도이슈로 실패한 소스
		  * #이유: 재귀함수가 depth가 깊어지면 stackoverflow에러가 발생함
		  * #조치했던 사항
		  * 1. StringBuffer sb = new StringBuffer(200000);
		  * ->초기 buffer크기 잡아줬으나 실패
		  */
	        int answer = 0;
	        arrangement = arrangement.replace("()", ".");
	        StringBuffer sb = new StringBuffer(arrangement);
	        long startTime = System.currentTimeMillis(); // 시작시간
	        answer = f(sb,answer);
	        System.out.println(answer);
	        System.out.println("완료 : " + (System.currentTimeMillis() - startTime) / 1000.000);
	        return answer;
	    }
	 public int f(StringBuffer sb, int answer) {
		 try {
			 if(sb.indexOf("(")==-1) return answer;
		        System.out.println(sb);
		        for (int i = 0; i < sb.length(); i++) {
		        	String sBrack = Character.toString(sb.charAt(i));
		        	if("(".equals(sBrack)) {
		        		for (int j = i+1; j < sb.length(); j++) {
		        			String eBrack = Character.toString(sb.charAt(j));
		        			if("(".equals(eBrack)) {
		        				break;
		        			}else if(")".equals(eBrack)) {
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
		        System.out.println(answer);
		        System.out.println(sb);
		        System.out.println("============");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	        return f(sb,answer);
	 }
	
	public static void main(String[] args) {
		Exam31_Programers_level2_5 e = new Exam31_Programers_level2_5();
		String arrangement = "()(((()())(())()))(())";
//		.(((..)(.).))(.)
		e.solution(arrangement);
	}
}
