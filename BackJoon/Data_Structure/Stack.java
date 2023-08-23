package BackJoon.Data_Structure;

import java.io.*;
import java.util.*;

// 명령은 총 다섯 가지이다.

// push X: 정수 X를 스택에 넣는 연산
// pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력.
//      만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
// size: 스택에 들어있는 정수의 개수를 출력
// empty: 스택이 비어있으면 1, 아니면 0을 출력
// top: 스택의 가장 위에 있는 정수를 출력. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력

//입력: N(1~10000), N줄에 명령어 하나씩 주어짐.
//출력: 명령이 주어질 때마다 한 줄에 하나씩 출력 (pop, size, empty, top)
public class Stack{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int N = Integer.parseInt(st.nextToken());

        if(1 <= N && N <= 10000){
            for(int i=0; i<N; i++){
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                String cmd = st2.nextToken();
                //만약 반환 token이 하나 더 있다면 push, 아니면 다른 명령 실행
                if(st2.hasMoreTokens()){
                    int cmd2 = Integer.parseInt(st2.nextToken());
                    stack.push(cmd2);
                }
                else{
                    if(cmd.contains("pop")){
                        if(stack.empty()){
                            System.out.println("-1");
                        }
                        else{
                            System.out.println(stack.pop());
                        }
                    }
                    else if(cmd.contains("size")){
                        System.out.println(stack.size());
                    }
                    else if(cmd.contains("empty")){
                        //empty: 데이터가 하나라도 있으면 false 반환
                        if(stack.empty() == false){
                            System.out.println("0");
                        }
                        else{
                            System.out.println("1");
                        }
                    }
                    else if(cmd.contains("top")){
                        if(stack.empty()){
                            System.out.println("-1");
                        }
                        else{
                            //peek: 최상단 데이터 출력
                            System.out.println(stack.peek());
                        }
                    }
                    else{
                        System.out.println("-1");
                    }
                }
            }
        }
    }
}
