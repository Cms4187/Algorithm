import java.io.*;
import java.util.*;

//문제 풀면 파랑, 못풀면 빨강으로 칠함
//칠할 때 아래 과정을 거침
//1. 연속된 임의의 문제 선택
//2. 선택된 문제들을 전부 원하는 같은 색으로 칠함

//EX. 8개를 칠할 때 파/파/빨/파/빨/파/파/빨 로 칠하려면
//1~7번 파랑, 3번 빨강, 5번 빨강, 8번 빨강으로 칠하면
//총 4번 작업하여 최소 횟수로 칠함.
//메일 50만문제까지 쉬도, 가장 효율적으로 칠하기

//풀이.
//문제 수 입력받고 잘라서 배열에 넣고,
//배열에서 B와 R의 갯수를 따로 계산하여
//더 적은 쪽 갯수 + 1만큼 칠하면 됨.
//--> 많은 쪽으로 한 번 칠하고 적은 쪽으로 하나씩
//    칠해야하기 때문에.

public class Blog2 {        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int countB = 0;
        int countR = 0;
        char[] words = new char[n];

        if(1 <= n && n <= 500000){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            String problem = st2.nextToken();
            words = problem.toCharArray();

		    for(int i=0; i<words.length; i++) {
			    char c = words[i];
                //맨 앞 색 구별해 맞는 값에 더해주기
			    if(i==0) {
			    	if(c=='B') countB++;
			    	else countR++;
			    }
			    else {
                    //만약 이전 색과 지금 색이 같다면 건너뛰기
                    //-> 이미 색칠되어있어 또 색칠할 필요가 없음
			    	if(words[i-1]==c)
                        continue;
                    //이전 색과 지금 색이 같지 않다면
                    //해당 값에 +1
			    	else {
			    		if(c=='B')
                            countB++;
			    		else
                            countR++;
			    	}
			    }
		    }
        }       
        if(countB <= countR){
                System.out.println(countB+1);
            }
            else{
                System.out.println(countR+1);
            }
    }   
}
