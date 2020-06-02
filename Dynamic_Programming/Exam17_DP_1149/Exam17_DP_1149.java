import java.util.Scanner;

public class Exam17_DP_1149 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        int[][] rgb = new int[N+1][3];
        int[][] distance = new int[N+1][3];
        // 보기 쉽도록 1부터 하려고.
        for(int i=1; i<N+1; i++) {
            String[] tmp = (scan.nextLine()).split(" ");
            // RGB 세팅
            rgb[i][0] = Integer.parseInt(tmp[0]);
            rgb[i][1] = Integer.parseInt(tmp[1]);
            rgb[i][2] = Integer.parseInt(tmp[2]);
        }
        for(int i=1; i<N+1; i++) {
            //i가 증가함에 따라 누적되는 distance의 의미는 i번째 집에 R,G,B중 색깔이 칠해졌을때까지의 최솟값임
            //i번째일때 색깔을 칠하며 rgb에있는 비용을 더하면서 distance는 누적됨
            distance[i][0] = Math.min(distance[i-1][1], distance[i-1][2]) + rgb[i][0];
            distance[i][1] = Math.min(distance[i-1][0], distance[i-1][2]) + rgb[i][1];
            distance[i][2] = Math.min(distance[i-1][0], distance[i-1][1]) + rgb[i][2];
        }
        // 세 개 중에 제일 최소값
        System.out.println(Math.min(Math.min(distance[N][0], distance[N][1]),distance[N][2]));
    }
}
