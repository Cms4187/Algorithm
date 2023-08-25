package BackJoon.Data_Structure;

import java.io.*;
import java.util.*;

//1~N번까지 사람이 원으로 앉음. K가 주어지고
//순서대로 K번째 사람을 제거. 한 사람이 제거되면 남은 사람들로 이루어진
//원을 따라 모두 제거될 때까지 반복. -> (N, K)-요세푸스 순열이라고 함
//EX. (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

//입력: N K가 주어짐 (1<=k<=n<=5000)
//출력: 예제와 같이 출력

class Josephus {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        //Queue형식인 LinkedList로 선언
        //LinkedList는 모든 데이터가 데이터 부분과 주소 부분을 별도로 가짐
        //단, ArrayList보다 검색에 있어서는 느림
        Queue<Integer> jo = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<Integer>(N);

        if(1 <= K && K <= N && N <= 5000){
            for(int i=0; i<N; i++){
                jo.add(i+1);
            }
            // System.out.println(jo);
            //아직 큐에 남은게 있다면 계속 반복
            while(jo.size() > 0){
                //K의 배수가 아닌 것은 뒤로 빼서 뒤로 보내줌
                //-> 해당 for문은 K만큼만 돌면서 K번째가 되면 for문을 종료하고
                //   값을 뽑아내 결과 배열에 넣어줌
                //만약 K의 배수 번째라면, 해당 값을 제거함
                //poll(): 첫번째 값 반환 || offer(값): 값을 큐 맨 뒤에 추가
                for(int j=0; j<K-1; j++){
                    // System.out.println("수정 전 jo: " + jo);
                    int val = jo.poll();
                    jo.offer(val);
                    // System.out.println("val: " + val + ", jo: " + jo);
                }
                //jo에서 뽑은 값을 결과 배열에 추가
                result.add(jo.poll());
            }
        }

        //출력 부분
        System.out.print("<");
        for(int m=0; m<result.size(); m++){
            //마지막이면 해당값만, 아니면 해당값 + ", " 도 같이 출력
            if(m==result.size()-1){
                System.out.print(result.get(m));
            }
            else{
                System.out.print(result.get(m) + ", ");
            }
        }
        System.out.print(">");
    }
}