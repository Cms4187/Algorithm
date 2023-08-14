import java.util.*;
import java.io.*;

//각각 AAAA, BB로 이루어진 폴리오미노가 무한대로 있다.
//.과 X로만 이루어진 보드판을 폴리오미노로 모두 채워야 한다.
//단, .은 채우면 안된다. 만약 덮을 수 없다면 출력은 -1이다.

//풀이.
//XXXX를 AAAA로, XX를 BB로, X가 있으면 -1 출력하게 하기
public class Polyomino {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        String answer = "";

        //먼저 XXXX를 AAAA로 바꿔주고, 남은 XX들을 BB로 바꿔주면 됨
        str = str.replaceAll("XXXX", "AAAA");
        answer = str.replaceAll("XX", "BB");

        //교체가 끝났는데도 X가 있으면
        //X의 갯수가 홀수인 부분이 있으니 -1을 출력
        if(answer.contains("X")){
            System.out.println("-1");
        }
        else{
            System.out.println(answer);
        }
    }
}
