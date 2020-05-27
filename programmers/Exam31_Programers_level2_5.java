package algorithm;

public class Exam31_Programers_level2_5 {
	
	 public int solution(String arrangement) {
			/* https://programmers.co.kr/learn/courses/30/lessons/42585
			 * 규칙성
			 * '('가 쌓인 갯수를 depth라 했을때.
			 * 1. 레이져를 쏘면 depth 갯수의 막대기가 생김
			 * 2. 레이져가 쏜갯수 만큼 현재 depth를 더해주면 됨
			 * 3. 레이져가 쏜 후 ')'를 만나면 쪼가리인 1이 남고 depth-1 해줌 
			 * ()(((()())(())()))(()) 
			 * .(((..)(.).))(.) 
			 * 3 3 1 3 1 2 1 1 1 1
			 */
	        int answer = 0;
	        int result = 0;
	        arrangement = arrangement.replace("()", ".");
	        StringBuffer sb = new StringBuffer(arrangement);
	        int depth = 0;
	        for (int i = 0; i < sb.length(); i++) {
	        	String sBrack = Character.toString(sb.charAt(i));
				if("(".equals(sBrack)) {
					depth++;
				}else if(".".equals(sBrack)) {
					result += depth;
				}else if(")".equals(sBrack)) {
					result++;
					depth--;
				}
			}
	        answer = result;
	        return answer;
	    }
	
	public static void main(String[] args) {
		Exam31_Programers_level2_5 e = new Exam31_Programers_level2_5();
		String arrangement = "()(((()())(())()))(())";
		e.solution(arrangement);
	}
}
