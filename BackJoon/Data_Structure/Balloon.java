package BackJoon.Data_Structure;

import java.io.*;
import java.util.*;

//N개의 풍선이 원형으로 놓임. i번 풍선의 오른쪽엔 i+1번 풍선,
//왼쪽엔 i-1번 풍선이 있음. 단, 1번의 왼쪽에는 N번, N번의 오른쪽에는 1번
//풍선이 있다. 각 풍선 안에는 종이 1개(범위: -N <= 숫자 <= N)
//터트리는 규칙: 처음엔 1번 터트리고, 풍선 안에 있는 종이를 꺼내
//그 종이에 적힌 값만큼 이동해 풍선을 터트림. 양수면 오른쪽,
//음수면 왼쪽으로 이동. 이동시 이미 터진 풍선은 빼고 이동함.

//Ex. 5개의 풍선에 3, 2, 1, -3, -1이 적혀 있다면
//1번, 4번, 5번, 3번, 2번 순으로 터지게 된다.
//1번 -> 1+3=4번 -> 4-3=1이지만 1번이 터져 5번으로
//-> 5-1=4지만 4번이 터져 3번으로 -> 3+1=4번이지만,
//다 터지고 없어서 2번이 터짐

public class Balloon{
    static class MyBal{
        int Idx = 0;
        int Num = 0;
        MyBal(int index, int Number){
            Idx = index;
            Num = Number;
        }
    }

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //풍선 Deque, 풍선 갯수 N, 풍선별 종이의 값 입력해 풍선 큐에 넣기
        Deque<MyBal> balloons = new ArrayDeque<>();
        StringBuilder result = new StringBuilder(); //값 저장
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        //(Index, Value) 형식으로 넣어줌
        for(int i = 1; i < N+1; i++){
            balloons.add(new MyBal(i, Integer.parseInt(st.nextToken())));
        }

        while(balloons.size() > 1){
            //Deque의 제일 앞 값을 빼서 temp(balloon.Num)에 넣고
            //balloons Deque에서 값을 지움
			MyBal temp = balloons.pollFirst();
            // System.out.println("temp.Idx: " + temp.Idx +  ", temp.Num: " + temp.Num + ", balloons: " + balloons.size());
			int Num = temp.Num;
            //결과 인덱스값을 result에 넣어줌
			result.append(temp.Idx).append(" ");

            //temp 값이 양수일 때, 값이 0이 될 때까지
            //계속 앞의 값을 빼서 뒤로 옮겨준다.
            //이미 pollFirst()를 한 번 진행해서 양수일 때는
            //한번 덜 옮겨주어야 한다.
            if(Num > 0 ){
                Num = Num - 1;
                while(Num-- > 0){
                    balloons.addLast(balloons.pollFirst());
                }
            }
            //temp값이 음수일 때, 값이 0이 될 때까지
            //계속 뒤 값을 빼서 앞으로 옮겨준다.
            else{
                while(Num++ < 0){
                    balloons.addFirst(balloons.pollLast());
                }
            }
        }

        result.append(balloons.poll().Idx);
        System.out.println(result);

    }
}