package algorithm;

class Solution6{
    //A,B가 계단 0에서 가위바위보를 하고 10판뒤에 A의 위치
    public int func(int record){
        if(record == 0) return 1;
        else if(record == 1) return 2;
        return 0;
    }

    public int solution(int[] recordA, int[] recordB){
        int cnt = 0;
        for(int i = 0; i < recordA.length; i++){
            if(recordA[i] == recordB[i])
                continue;
            else if(recordA[i] == func(recordB[i])) {
                cnt = cnt + 3;
            }
            else
            	if(cnt!=0) cnt = cnt - 1; //cnt = cnt - 1;에서 cnt가 0일경우 조건추가
        }
        return cnt;
    }

    // The following is main method to output testcase. The main method is correct and you shall correct solution method.
    public static void main(String[] args) {
    	Solution6 sol = new Solution6();
        int[] recordA = {2,0,0,0,0,0,1,1,0,0};
        int[] recordB = {0,0,0,0,2,2,0,2,2,2};
        int ret = sol.solution(recordA, recordB);

        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret + " .");
    }
}
