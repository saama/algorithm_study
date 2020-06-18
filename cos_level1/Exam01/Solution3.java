package algorithm;
class Solution3 {
    public int solution(String pos) {
    	/*
    	 * 8x8체스판에 현재 나이트(말)의 위치에서 이동 가능한 위치의 총 갯수
    	 * 체스판에서 0미만 7초과(배열)이면 이동 불가능 하므로
    	 * dx,dy배열(나이트의 이동가능한 좌표 배열)을 만들어 현재 나이트의 위치 for문을 돌려 범위밖인지 체크 
    	 */
    	int ans = 0;
    	
    	int []dx = {1,1,-1,-1,2,2,-2,-2};
    	int []dy = {2,-2,2,-2,1,-1,1,-1};
    	
    	for (int i = 0; i < 8; i++) {
    		int x =  pos.charAt(0)-'A';
        	int y =  pos.charAt(1)-'0'-1;
			x += dx[i];
			y += dy[i];
			if(x>=0 && x<8 && y>=0 && y<8) ans++;
		}
    	
    	return ans;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 함수입니다.
    public static void main(String[] args) {
    	Solution3 sol = new Solution3();
	    String ex0_pos = "A7";
	    int ex0_ret = sol.solution(ex0_pos);
    	
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.printf("첫 번째 예제의 답은 %d 입니다.\n", 3);
        System.out.printf("solution 함수의 반환 값은 %d 입니다.\n", ex0_ret);
    }
}
