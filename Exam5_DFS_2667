package algoritmExam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Exam5_DFS_2667 {
	static int stoi(String s) { return Integer.parseInt(s);}
	 
    /**
     * n 정사각형 2차원배열의 길이
     * arr n크기로 만들어진 2차원 배열
     * dx, dy 4방향 검사를 위한 배열
     */
    static int n;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int count;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        n = stoi(br.readLine());
        arr = new int[n][n];
        
        for(int i=0; i<n; i++) {
            String s = br.readLine();
 
            for(int j=0; j<n; j++)
                arr[i][j] = s.charAt(j) - '0';
        }
 
        /**
         * total은 총 단지수
         * count는 각 단지의 개수
         * 오름차순으로 출력하기 위해 PriorityQueue에 저장함
         */
        int total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
 
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
            	//1은 건물이 있음을 의미
                if(arr[i][j] == 1) {
                    count = 0;
                    total++;
                    
                    dfs(i, j);
 
                    pq.add(count);
                }
            }
        }
 
        bw.write("total "+total + "\n");
 
        while(!pq.isEmpty())
            bw.write(pq.poll() + "\n");
 
        bw.flush();
    }
 
    // visited 대신 단지를 0으로 바꿔가면서 체크
    static void dfs(int x, int y) {
        arr[x][y] = 0;
        count++;
 
        for(int i=0; i<4; i++) {
        	// 현위치에서 좌,우,위,아래에 접근하기 위함 
            int nx = x + dx[i];
            int ny = y + dy[i];
 
            //0과 n사이 범위에 속할때만
            if(0 <= nx && nx < n && 0 <= ny && ny < n) {
            	
                if(arr[nx][ny] == 1)
                    dfs(nx, ny);
            }
        }
    }
}

