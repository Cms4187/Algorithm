import java.io.*;
import java.util.*;

//N개의 로프가 존재
//k개의 로프를 사용해 w 무게의 물체를 들어올리면
//각각의 로프에 w/k만큼 중량이 걸림
//모든 로프를 사용할 필요는 없고, 임의로 몇 개를
//골라 사용해도 된다.

//입력: 첫째줄에 갯수 N
//N개의 줄에 각 로프가 버티는 최대 중량 입력
//최대 중량은 10000을 넘지 않는 자연수임

//출력: 첫째 줄에 답 출력

//Ex) N=5, 로프는 [12, 20, 30, 33, 35] 가 있다.
//큰 값부터 빼면서 최대 중량을 계산해야 한다.
//1. 35가 꺼내지면 최대 중량은 35
//2. 33이 꺼내지면 최대 중량은 33*2 = 66
//3. 30이 꺼내지면 최대 중량은 30*3 = 90
//4. 20이 꺼내지면 최대 중량은 20*4 = 80
//5. 12가 꺼내지면 최대 중량은 12*5 = 60

//따라서 30이 꺼내진 90이 최대 중량이 된다.


public class Rope {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] rope = new int[N];

        for(int i=0; i<N; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int myRope = Integer.parseInt(st2.nextToken());
            rope[i] = myRope;
        }

        Arrays.sort(rope);

        //로프의 무게는 w/k(개) 만큼 분산
        //j번째 루프의 최대 중량 * 로프 수가 전체의 최대 중량임
        //큰 것부터 빼면서 최대 중량을 계산하여 최대 중량을 구함
        int weight = 0;
        for(int j=0; j<N; j++){
            if(weight < rope[j] * (N-j)){
                weight = rope[j] * (N-j);
            }
        }


        System.out.println(weight);
    }
}