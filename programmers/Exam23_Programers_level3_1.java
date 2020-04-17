package algorithmExam;

public class Exam23_Programers_level3_1 {
	
	public static boolean flag = false;
	
	public static void main(String[] args) {
		System.out.println(solution("abcdcba"));
	}
	
	public static int solution(String s){
		
        int answer = 1;
        int len = s.length();
        while(len>=2){

        	//로직//
        	int i=0;
        	while(i+len<=s.length()){ //abcd의 len이 3이면 abc , bcd뽑아냄
        		String tempStr = s.substring(i, len+i);
        		f(tempStr,0,tempStr.length()-1);
        		i++;
        	}
        	//로직//
        	
        	//팰린드롬조건에 맞으면 현재의 길이반환
        	if(flag) return len;
        	
        	//팰린드롬조건에 맞지않으면 -1
        	len -= 1;
        }
        return answer;
    }
	public static void f(String str,int start,int end){
		if(start==end || start-end==1){ //문자열이 홀수일때와 짝수일때
			flag = true;
			return; //끝까지갔으면 팰린드롬맞음
		}
		if(str.charAt(start)==str.charAt(end)){
			f(str,start+1,end-1); //문자열이 같으면 재귀함수 들어감
		}
	}
}

