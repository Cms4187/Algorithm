package BackJoon.Data_Structure;

import java.io.*;
import java.util.*;

//1. 배열에 자연수 X를 넣는다
//2. 배열에서 가장 큰 값을 출력, 그 값을 배열에서 제거
//처음에는 비어있는 배열에서 시작

//입력
//첫째 줄: N(1~100,000) 주어짐.
//N개의 줄에 정수 X를 입력. 만약 X가 자연수면 배열에 X값 추가
//X=0이면 배열에서 가장 큰 값 출력 후 그 값을 배열에서 제거
//입력되는 자연수는 2^31보다 작다.

//출력
//입력에서 0이 주어진 횟수만큼 답 출력. 배열이 비어있는 경우에 가장 큰 값을 출력하라하면 0 출력하기.

public class MaxHeap {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //Collections: 객체의 모음, 그룹. reverseOrder로 역순(내림차순) 정렬해줌
        //maxHeap은 큰 값부터 출력해야해서 역순으로 정렬해줌
        //PriorityQueue: 우선순위 큐. 일반적인 큐(FIFO)의 구조이면서 데이터가 들어온 순서대로
        //               나가는 것이 아닌 우선순위를 먼저 결정 후 우선순위가 높은 데이터가 먼저 나가는 자료구조
        //               내부 요소는 힙으로 구성되어 이진트리 구조로 이루어짐
        //               힙으로 구성되어서 시간 복잡도는 O(NLogN)이다. 우선순위를 중요시해야하는 상황에 쓰인다.
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        
        if(1 <= N && N <= 100000){
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int Input_Num = Integer.parseInt(st.nextToken());
                //만약 0이 입력되면 힙에서 최댓값 출력하면서 최댓값 지우기
                //아니라면 힙에 값 추가
                if(Input_Num == 0){
                    if(max_heap.isEmpty()){
                        System.out.println(0);
                    }
                    else{
                        System.out.println(max_heap.poll());
                    }
                }
                max_heap.add(Input_Num);
            }
        }
    }
        //힙에 값이 있다면 계속 출력
        // while(!max_heap.isEmpty()){
        //     System.out.println(max_heap.poll());
        // }
}
