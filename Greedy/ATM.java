import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//ATM앞에 N명이 줄서있고, 번호는 1~N이다.
//i번 사람이 인출하는데 걸리는 시간은 Pi분이다.
//Ex) 5명이고 P1=3, P2=1, P3=4, P4=3, P5=2이면
//[1,2,3,4,5] 순으로 줄을 서면 1번은 3분, 2번은 4분, 3번은 8분,
//4번은 11분, 5번은 3+1+4+3+2=13분이 걸린다.
//이 경우 인출에 걸린 총 시간은 39분이 된다.

//사람 수 n과 인출에 걸리는 시간 Pi가 주어졌을 때,
//각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 구해라.

public class ATM {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        //사람 수 입력받기, 시간값을 넣을 배열 생성
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] time = new int[N];

        int min = 0;

        //시간값을 입력받아 공백으로 구분지어 배열에 넣기
        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++){
            int myTime = Integer.parseInt(st2.nextToken());
            time[i] = myTime;
        }
        
        //1~5번까지 넣어 값구함
        // for(int j=0; j<=N; j++){
        //     for(int k=0; k<j; k++){
        //         System.out.println(time[k]);
        //         min += time[k];
        //     }
        // }
        
        //1. sort 함수 사용
        // Arrays.sort(time);

        //2. 직접 버블 정렬만들어서 정렬
        int temp = 0;
        for(int j=0; j<time.length-1; j++){
            for(int k=0; k<time.length-j-1; k++){
                if(time[k] > time[k+1]){
                    temp = time[k];
                    time[k] = time[k+1];
                    time[k+1] = temp;
                }
            }
        }

        for(int j=0; j<=N; j++){
            for(int k=0; k<j; k++){
                min += time[k];
            }
        }
        System.out.println(min);

        // System.out.println(Arrays.toString(time));
    }
    
}