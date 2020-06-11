package algorithm;

public class Exam_34_fail {
	
	//fail -> n가 증가함에 따라 재귀함수의 깊이가 기하급수적으로 늘어남
	public static int cnt = 0;
	
	public int solution(int n) {
        f(1,n);
        f(2,n);
        System.out.println(cnt);
        return cnt%1000000007;
    }
	public void f(int curWidth,int n) {
		if(curWidth>n) {
			return ;
		}else if(curWidth==n) {
			cnt++;
			return ;
		}
		f(curWidth+1,n);
		f(curWidth+2,n);
	}
	
	public static void main(String[] args) {
		Exam_34_fail e = new Exam_34_fail();
		int n = 5;
		long startTime = System.currentTimeMillis(); // 시작시간
		e.solution(n);
		System.out.println("완료 : " + (System.currentTimeMillis() - startTime) / 1000.0);
	}
}
