package kakao;

public class Exam6 {
	
//	aabbaccc
//	2a2ba3c -> 7
//	ababcdcdababcdcd
//	2ababcdcd -> 9
//	abcabcabcabcdededededede
//	2abcabc2dedede -> 14
	
	//pressNum 압축갯수
	//checkSame
	
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length()/2; i++) {
			String f = s.substring(0,i);
			int cnt = 1;
			String checkStr;
			String compressedStr="";
			for (int j = i; j < s.length(); j+=i) {
				if(j+i>s.length()){ //c++과 다르게 java substring은 마지막인덱스를 초과하면 error
					checkStr = s.substring(j,s.length());
				}else{
					checkStr = s.substring(j,(j+i));
				}
				if(f.equals(checkStr)){
					cnt++;
				}else{
					if(cnt!=1){
						compressedStr += Integer.toString(cnt)+f; 
					}else{
						compressedStr += f;
					}
					cnt = 1;
					f = checkStr;
				}
				//같은 반복문에서 j를기준으로 반복하였지만 j+i라는 변수(다음동작시)에 조건을주어 break처리를해줬음
				//나머지 문자열 추가
				if(j+i>=s.length()){
					if(cnt!=1){
						compressedStr += Integer.toString(cnt)+f;
					}else{
						compressedStr += s.substring(j);
					}
					break;
				}
			}
			answer = Math.min(answer, compressedStr.length());
		}
        return answer;
    }
	
	public static void main(String[] args) {
		Exam6 e = new Exam6();
		String c1 = "aabbaccc";
		String c2 = "ababcdcdababcdcd";
		String c3 = "abcabcdede";
		String c4 = "abcabcabcabcdededededede";
		String c5 = "xababcdcdababcdcd";
		System.out.println(e.solution(c1));
		System.out.println(e.solution(c2));
		System.out.println(e.solution(c3));
		System.out.println(e.solution(c4));
		System.out.println(e.solution(c5));
	}
}
