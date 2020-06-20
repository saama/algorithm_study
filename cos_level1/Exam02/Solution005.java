// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Solution005 {
    public int solution(int[] arr) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;
        int cnt = 1;

        int start = arr[0];
        for (int i=1;i<arr.length;i++){
            if(start<arr[i]) cnt ++;
            else if(start>=arr[i]){
                //현재 i번째값이 더 크면 현재까지 answer,cnt중에 큰걸 넣고
                //start를 초기화
                answer=Math.max(answer,cnt);
                start = arr[i];
                continue;
            }
        }

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution005 sol = new Solution005();
        int[] arr = {3, 1, 2, 4, 5, 1, 2, 2, 3, 4};
        int ret = sol.solution(arr);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
