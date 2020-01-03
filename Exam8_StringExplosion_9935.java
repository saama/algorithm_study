package algoritmExam;

import java.util.Scanner;

public class Exam8_StringExplosion_9935 {
    static String str;
    static int index = 0, bumbLen;
    static char[] resStr = new char[1000001], bomb = new char[1000001];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        str = in.next();
        String bumbStr  = in.next();
        for(int i=0; i<bumbStr.length(); i++) {
            bomb[i] = bumbStr.charAt(i);
        }
        bumbLen = bumbStr.length();
        
        for(int i = 0; i < str.length(); i++) {
            resStr[index++] = str.charAt(i);
            
            //폭탄의 마지막 문자와 일치하면
            if (resStr[index - 1] == bomb[bumbLen - 1]){
               //현재 index - 폭탄길이가 -이면 무시
            	if(index-bumbLen<0) continue;
               
            	boolean isNotSameStr = false;
            	//폭탄길이만큼 for문돌려 폭탄과 일치하는지 체크
                for(int j = 0; j < bumbLen; j++) {
                    if (resStr[index - 1 - j] != bomb[bumbLen - 1 - j]){
                    	isNotSameStr = true;
                        break;
                    }
                }
                //같으면 현재index에 폭탄길이만큼 빼주어 다음 for문에서 resStr에 현재 가르키고있는 str[i]가 덮어씌어짐
                if(!isNotSameStr) index -= bumbLen;
            }
        }

        //남아있는 문자가없는경우는 다폭팔해서 index가 0이된경우
        if(index==0) System.out.println("FRULA");
        else{
            for(int i=0; i<index; i++)
                System.out.print(resStr[i]);
        }
        in.close();
    }
}

