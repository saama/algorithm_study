// You may use import as below.
//import java.util.*;

import java.util.Arrays;

class Solution1 {
    /*
    *소용돌이 문제
    *소스를 보고 흘러가는 느낌은..
    *dy,dx의 0번째 인덱스부터 쭉~~ 가다가 어? 범위밖이내? 또는 0이 아니내?
    *하면 dy,dx의 다음인덱스로 넘어가서 계속 반복
    *pane에 dy,dx대로 움직이면 시계방향 소용돌이모양이됨
    */
    int[][] pane;
    int dy[] = {0, 1, 0, -1};
    int dx[] = {1, 0, -1, 0};
    boolean inRange(int i, int j, int n){
        return 0 <= i && i < n && 0 <= j && j < n;
    }

    public int solution(int n){
        pane = new int[n][n];
        int ci = 0;
        int cj = 0;
        int num = 1;
        while(inRange(ci, cj, n) && pane[ci][cj] == 0){
            for(int k = 0; k < 4; k++){
                if(!inRange(ci, cj, n) || pane[ci][cj] != 0) break;
                while(true){
                    System.out.println(ci+" "+cj);
                    pane[ci][cj] = num++;
                    int ni = ci + dy[k];
                    int nj = cj + dx[k];
                    if(!inRange(ni, nj, n) || pane[ni][nj] != 0){
                        ci += dy[(k + 1) % 4];
                        cj += dx[(k + 1) % 4];
                        System.out.println("break! "+ci+" "+cj);
                        break;
                    }
                    ci = ni;
                    cj = nj;
                }
            }
        }
        for (int []arr : pane){
            System.out.println(Arrays.toString(arr));
            /*
            * [1, 2, 3]
            * [8, 9, 4]
            * [7, 6, 5]
            * */
        }
        int ans = 0;
        for(int i = 0; i < n; i++) ans += pane[i][i];
        return ans;
    }

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        int num = 3;
        int ret = sol.solution(num);
        System.out.println(ret);
    }
}
