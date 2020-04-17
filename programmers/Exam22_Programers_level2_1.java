package algorithmExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam22_Programers_level2_1 {
	static int m = 6;
	static int n = 4;
    static int[][] arr = 
    	{{1, 1, 1, 0},
    	 {1, 2, 2, 0}, 
    	 {1, 0, 0, 1}, 
    	 {0, 0, 0, 1}, 
    	 {0, 0, 0, 3}, 
    	 {0, 0, 0, 3}};
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int count;
    static int max=0;
    static int areaCnt=0;
    
   public static void main(String[] args) {
	  for (int i = 0; i < arr.length; i++) {
		for (int j = 0; j < arr[i].length; j++) {
			if(arr[i][j]!=0){
				areaCnt++; //밑에 dfs가돌고나면 훑었던곳은 0이되므로 다시 arr[i][j]!=0이 만나는곳은 새로운 영역이므로 count 
				count=0; //한 영역의 갯수를 세어줌
				showArr(arr);
				System.out.println("=========");
				dfs(i,j);
				if(count>max){
					max=count;
				}
			}
		}
	}
	  System.out.println(areaCnt+" "+max);
   }
   static void dfs(int x, int y) {
	   int currentNum = arr[x][y];
       arr[x][y] = 0;
       count++;

       for(int i=0; i<4; i++) {
       	// 현위치에서 좌,우,위,아래에 접근하기 위함 
           int nx = x + dx[i];
           int ny = y + dy[i];
           //0과 n사이 범위에 속할때만
           if(0 <= nx && nx < m && 0 <= ny && ny < n) {
               if(arr[nx][ny] == currentNum)
                   dfs(nx, ny);
           }
       }
   }
 //배열출력 int[][]
 	public static void showArr(int[][] param){
 		for(int i=0;i<param.length;i++){
 			for (int j = 0; j < param[i].length; j++) {
				System.out.print(param[i][j]+" ");
			}
 			System.out.println();
 		}
 	}
}

