package algorithmExam;

import java.util.Arrays;

public class Exam30_Programers_level3_4 {
	//https://programmers.co.kr/learn/courses/30/lessons/43162
	public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];
        Arrays.fill(visited, false);
        
        //인접행렬 0~2까지 반복
        for (int i = 0; i < computers.length; i++) {
        	if(visited[i]==false){//방문 안된곳은 dfs, 재귀함수 내에서 visited배열이 처리됨
        		dfs(i,visited,computers);
        		answer++;
        	}
		}
        
        return answer;
    }
	public void dfs(int i,boolean[] visited, int[][] computers){
		visited[i] = true; //방문했음을 의미
		for (int j = 0; j < computers.length; j++) {
			//i를 기준으로 연결된 인접행렬을 전부 체크하여 방문하지않은곳 방문
			if(computers[i][j]==1 && visited[j]==false){
				dfs(j,visited,computers);
			}
		}
	}
	public static void main(String[] args) {
		Programmers_1 p = new Programmers_1();
		int n=3;
//		int[][] computers = 
//			{
//				{1, 1, 0}, 
//				{1, 1, 0}, 
//				{0, 0, 1}
//			};
		int[][] computers =
			{
				{1, 1, 0}, 
				{1, 1, 1}, 
				{0, 1, 1}
			};
		System.out.println(p.solution(n, computers));
	}
}
