import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam18_DivideAndConquer_1992 {

    static int N;
    static int arr[][];
    static int cnt;
    static String resultStr = "";

    public static void main(String[] args) throws Exception{
        /*입력받기 - 입력시 띄어쓰기 없을때 charAt 사용*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        /*입력받기 끝*/
//        showArr();

        makeQuadTree(0,0,N);
        System.out.println(resultStr);
    }

    public static void makeQuadTree(int a,int b,int length){
        if(isSame(a,b,length)) {
            return;
        }else{
            //같이 않으므로 괄호하나 붙혀주고 아래 로직 실행됨
            resultStr += "(";
        }
        int div = length/2;
        for (int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                makeQuadTree(a+div*i,b+div*j,div);
            }
        }
        //해당 재귀함수의 마지막
        resultStr += ")";
    }

    //전달받은 변수에 해당하는 배열의 영억에 값들이 같은지 체크함
    //영역의 숫자들이 같다면 그 영역에 있는 숫자를 결과문자열에 붙혀줌
    public static boolean isSame(int a,int b,int length){
        int temp = arr[a][b];
        for(int i=a; i<a+length; i++){
            for(int j=b;j<b+length; j++){
//                System.out.print(arr[i][j]+" ");
                if(temp!=arr[i][j]) return false;
            }
        }
        resultStr += temp;
        return true;
    }

    public static void showArr(int a,int b,int length){
        for (int i=a;i<a+length;i++){
            for(int j=b;j<b+length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}

