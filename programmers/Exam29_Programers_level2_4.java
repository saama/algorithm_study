class Solution {
	//문제의 이해
	//입력 [1, 2, 3, 2, 3]	
	//출력 [4, 3, 1, 1, 0]
	//각 배열의 인덱스 시점부터 종료시까지 주식가격이 떨어졌는지만 판단하면 됨
        public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < answer.length; i++) {
			for (int j = i+1; j < answer.length; j++) {
				if(prices[i]>prices[j]){
					//j-i는 해당 시간에서 떨어지는시점까지의 경과시간
					answer[i] = j-i;
					break;
				}
				answer[i]=j-i;
			}
		}
        return answer;
    }
}
