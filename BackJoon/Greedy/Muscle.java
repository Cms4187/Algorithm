import java.io.*;
import java.util.*;

//운동기구는 한 번에 최대 2개만 선택 가능
//Ex) 운동기구 10개면 PT 5번 받으면 전부 사용 가능
//Ex2) 9개면 마지막에는 1개만 사용 가능
//운동기구마다 근손실 정도가 다름. PT한 번 받을때
//근손실이 M을 넘지 않게 해야 함. 이때, M의 최솟값 구하기
//운동 기구를 두 개 사용해서 PT 받을 때의 근손실 정도는
//두 운동기구의 근손실 정도의 합이다.

//입력값
//첫째 줄: 운동기구 갯수 N
//둘째 줄: 각 운동기구의 근손실 정도를 나타내는 정수

//출력값
//M의 최솟값 출력

//Ex) N:5, 근손실 정도는 1, 2, 3, 4, 5 일 때,
//첫째날 1, 4 / 둘째날 2, 3 / 셋째날 5 선택시 M=5며, 최소임.

public class Muscle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //운동기구 갯수 입력
        int N = Integer.parseInt(st.nextToken());
        int[] lossMuscle = new int[N];
        int max = 0;
    
        //운동 근손실 정도를 배열에 입력
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int muscle = Integer.parseInt(st2.nextToken());
            lossMuscle[i] = muscle;
        }

        //근손실 배열 정렬(Greedy)
        Arrays.sort(lossMuscle);

        //갯수가 짝, 홀일 때 나눠서 하기

        //홀수일 때
        if(N % 2 == 1){
            //마지막 값(제일 큰 값)을 max로 설정 후 시작
            max = lossMuscle[N-1];
            //마지막 값 제외하고 for문 돌리기
            for(int i=0; i<(N-1)/2; i++){
                max = Math.max(max, lossMuscle[i]+lossMuscle[N-2-i]);
            }
        }
        //짝수일 때
        else{
            for(int i=0; i<N/2; i++){
                max = Math.max(max, lossMuscle[i]+lossMuscle[N-1-i]);
            }
        }

        // System.out.println(Arrays.toString(lossMuscle));
        System.out.println(max);
    }
}
