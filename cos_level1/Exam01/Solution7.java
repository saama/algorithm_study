package algorithm;
class Solution7{
    int solution(int[] prices){
    //prices가 주어졌을때 n일동안 한번씩만 사고팔때 최대수익을 내는 금액반환
        int INF = 1000000001;
        int tmp = INF;
        int answer = -INF;
        for(int price : prices){
            if(tmp != INF) {//tmp는 price의 가장 작을때 값이 들어감
                answer = Math.max(answer, price - tmp); //tmp - price에서 변경
            }
            tmp = Math.min(tmp, price);
        }
        return answer;
    }
    //price 1 INF 1000000001 tmp 1000000001 answer -1000000001 tmp 1
    //price 2 answer -1 tmp 1
    //price 3 answer -1 tmp 1
    //price 1 answer  0 tmp 1

    // The following is main method to output testcase. The main method is correct and you shall correct solution method.
    public static void main(String[] args) {
    	Solution7 sol = new Solution7();
        int[] prices1 = {1, 2, 3};
        int ret1 = sol.solution(prices1);
        
        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret1 + " .");
        
        int[] prices2 = {3, 1};
        int ret2 = sol.solution(prices2);
        
        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret2 + " .");
    }
}
