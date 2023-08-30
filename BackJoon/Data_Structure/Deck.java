package BackJoon.Data_Structure;

import java.io.*;
import java.util.*;

// push_front X: 정수 X를 덱의 앞에 넣는다.
// push_back X: 정수 X를 덱의 뒤에 넣는다.
// pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다.
//            만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
// pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다.
//           만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
// size: 덱에 들어있는 정수의 개수를 출력한다.
// empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
// front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
// back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.

public class Deck {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> deq = new ArrayDeque<Integer>();

        int N = Integer.parseInt(br.readLine());
        if(1 <= N && N <= 100000){
            for(int i=0; i<N; i++){
                //명령을 받을 때 "명령 값" 형태면 해당 값을 검사해 명령 실행, 아니면 그냥 명령 실행
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                if(st.hasMoreTokens()){
                    int value = Integer.parseInt(st.nextToken());
                    if(cmd.contains("push_front")){
                        deq.addFirst(value);
                    }
                    else if(cmd.contains("push_back")){
                        deq.addLast(value);
                    }
                    else{
                        continue;
                    }
                }
                else{
                    if(cmd.contains("pop_front")){
                        if(deq.size() < 1){
                            System.out.println("-1");
                        }
                        else{
                            System.out.println(deq.pollFirst());
                        }
                    }
                    else if(cmd.contains("pop_back")){
                        if(deq.size() < 1){
                            System.out.println("-1");
                        }
                        else{
                            System.out.println(deq.pollLast());
                        }
                    }
                    else if(cmd.contains("size")){
                        System.out.println(deq.size());
                    }
                    else if(cmd.contains("empty")){
                        if(deq.size() < 1){
                            System.out.println("1");
                        }
                        else{
                            System.out.println("0");
                        }
                    }
                    else if(cmd.contains("front")){
                        if(deq.size() < 1){
                            System.out.println("-1");
                        }
                        else{
                            System.out.println(deq.peekFirst());
                        }
                    }
                    else if(cmd.contains("back")){
                        if(deq.size() < 1){
                            System.out.println("-1");
                        }
                        else{
                            System.out.println(deq.peekLast());
                        }
                    }
                    else{
                        continue;
                    }
                }
            }
        }
    }
}
