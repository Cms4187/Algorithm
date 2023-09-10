package BackJoon.Data_Structure;
import java.util.*;
import java.io.*;

//절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다
//1. 배열에 정수 x(x!=0)를 넣는다
//2. 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다
//   절댓값이 가장 작은 값이 여러개면, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
//배열은 처음에 비어있는 상태로 시작한다

//입력
//N이 주어진다(1~100000). N개의 줄에 x가 주어지고 x != 0이면 배열에 x를 넣고
//x는 0이면 배열에서 절댓값이 가장 작은 값을 출력하고 값을 배열에서 제거한다
//입력되는 정수는 -2^31보다 크고, 2^31보다 작다

//출력
//입력에서 0이 주어진 횟수만큼 답을 출력. 배열이 비어있는데 출력하라하면 0을 출력한다

//PriorityQueue를 사용해 최솟값 우선순위 큐를 만들고
//조건에 맞도록 큐의 정렬 조건을 오버라이딩하여 재정의해줘야 한다
//조건: 절댓값이 작은 순으로 출력. 단 동일한 절댓값 존재시 음수의 값부터 출력
//-> Collections의 compare 메소드를 오버라이딩 해준다

public class AbsoluteHeap {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());

        //최댓값 우선순위 큐는 아래 주석처럼 생성
        //=> reverseOrder로 기본값이 최솟값부터 정렬되는 PriorityQueue를 뒤집어줌
        //PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        //최솟값 우선순위 큐 개념은 https://crazykim2.tistory.com/575 참고
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
        //최솟값 우선순위 큐의 compare() 메소드를 조건에 맞도록 재정의해준다.
            @Override
            public int compare(Integer Num1, Integer Num2){
                //절대값을 비교해 앞이 더 크면 자리를 바꾼다
                if(Math.abs(Num1) > Math.abs(Num2)){
                    return Math.abs(Num1) - Math.abs(Num2);
                }
                //절대값이 같으면 음수를 앞으로 보내준다
                else if(Math.abs(Num1) == Math.abs(Num2)){
                    return Num1 - Num2;
                }
                else
                    return -1;
            }
        });
        if(1 <= N && N <= 100000){
            for(int i=0; i<N; i++){
                int x = Integer.parseInt(br.readLine());
                if(x != 0){
                    minHeap.offer(x);
                }
                //x == 0일때
                else{
                    //만약 배열이 비어있다면 0 출력
                    if(minHeap.isEmpty()){
                        System.out.println(0);
                    }
                    //배열에 값이 있다면 큐 안의 값을 비교해 절댓값이 작은 순으로 정렬
                    else{
                        System.out.println(minHeap.poll());
                    }
                }
            }
        }
    }
}
