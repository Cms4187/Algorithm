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
