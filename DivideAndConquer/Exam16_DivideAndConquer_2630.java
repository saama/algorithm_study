import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam16_DivideAndConquer_2630 {

    static int N;
    static int [][]paper;
    static int whiteCnt=0;
    static int blueCnt=0;

    public static void main(String[] args) throws Exception {
        /*입력받기*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        paper = new int[N][N];
        for (int i = 0; i < paper.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < paper[i].length; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        /*입력받기 끝*/

        CutPaper(0,0,N);
        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }

    public static void CutPaper(int h,int w,int length){
        System.out.println("=============");
        //체크한 전체숫자가 같으므로 재귀함수 돌필요없음
        if(isSamePaper(paper,h,w,length)) return ;

        //반으로 나누는 작업
        if(length!=1){
            int half = length/2;
            for (int i=0;i<2;i++){
                for (int j=0;j<2;j++){
                    CutPaper(h+i*half,w+j*half,half);
                }
            }
        }
    }

    //종이의 구성이 같은숫자로 이루어졌는지 체크
    public static boolean isSamePaper(int [][]paper,int h,int w, int length) {

        System.out.println("h "+h+" w "+w);
        int tempNum = paper[h][w];
        System.out.println("startHeight "+h+" startWidth "+w+" tempNum "+paper[h][w]);
        for(int a=h;a<h+length;a++){
            for(int b=w;b<w+length;b++){
                if(tempNum!=paper[a][b]){ //숫자가 다르므로 CutPaper재귀함수 더돌아야함
                    showArr(paper,h,w,length);
                    System.out.println("숫자 동일하지 않음");
                    return false;
                }
            }
        }
        //for문이 다돌아도 false가 아니면 접근한 배열의 값들이 모두같다는 의미
        //따라서 처음에 넣어준 tempNum에 따라 숫자 카운트
        if(tempNum==0) whiteCnt++;
        if(tempNum==1) blueCnt++;
        showArr(paper,h,w,length);
        System.out.println("숫자 동일함");
        System.out.println("============");
        return true;
    }

    public static void showArr(int [][] paper,int h,int w,int length) {
        int startHeight = h*length;
        int startWidth = w*length;
        System.out.println("============");
        for(int a=h;a<h+length;a++){
            for(int b=w;b<w+length;b++){
                System.out.print(paper[a][b]+" ");
            }
            System.out.println();
        }
        System.out.println("============");
    }
}

