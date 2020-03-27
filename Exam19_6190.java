import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam19_6190 {

    static int N;
    static int score = 0;

    //시작값이 홀수면 숫자 * 3 + 1
    //짝수면 나누기 2
    //반복하여 N이 1이될때까지 score++
    //최종 score값 출력
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        while (N != 1) {
            ACNGame();
        }
        System.out.println(score);
    }
    public static void ACNGame(){
        if(checkOddEven(N)==1){
            N = N * 3 + 1;
        }else{
            N = N / 2;
        }
        score++;
    }
    public static int checkOddEven(int n){
        if(n%2==1){
            return 1;
        }else{
            return 0;
        }
    }
}

