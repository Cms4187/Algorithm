package BackJoon.Data_Structure;

import java.io.*;
import java.util.*;

//괄호 문자열(PS)는 '('와 ')'만으로 구성된 문자열이다. 그 중 괄호 모양이 올바르게 구성된 문자열은 VPS(Valid PS)
//라고 부른다. 한 쌍의 괄호 "( )" 문자열은 기본 VPS이다. 만약 x가 VPS면 하나의 괄호에 넣은 새로운 문자열 "(x)"도
//VPS가 된다. 두 VPS x와 y를 접합시킨 새로운 문자열 xy도 VPS가 된다.
//Ex) "(())()"와 "((()))"는 VPS이나, "(()(", "(())()))", "(()"는 VPS가 아니다.

//입력: 표준 입력. T개의 테스트 데이터가 주어짐.
//      첫 줄엔 데이터 수 T 입력, 각 테스트 데이터의 첫 줄은 괄호 문자열이 한 줄에 주어짐
//      하나의 괄호 문자열의 길이는 2이상 50이하

//출력: 표준 출력. 만약 입력 괄호 문자열이 올바른 괄호 문자열(VPS)면 "YES",
//      아니면 "NO"를 한 줄에 하나씩 차례로 출력
public class Bracket {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++){
            //stack도 줄마다 사용해야하므로 for문 안에 선언
            java.util.Stack<Character> stack = new java.util.Stack<>();
            String vps = br.readLine();

            for(int j=0; j<vps.length(); j++){
                //열리는게 들어오면 push
                if(vps.charAt(j) == '('){
                    stack.push(vps.charAt(j));
                }
                //닫히는 게 들어오면
                else{
                    //비어있을 때 닫히는게 들어오면 스택에 넣고 끝내기
                    //값이 있어 밑에 if문에서 NO 출력
                    if(stack.empty()){
                        stack.push(vps.charAt(j));
                        break;
                    }
                    //비어있지 않다면 세트 완성 -> 열리는거 하나 지워주기
                    else{
                        stack.pop();
                    }
                }
            }
            //한 줄 검사가 끝나고, 괄호의 갯수가 0이면 YES(전부 짝이 맞으므로), 아니면 NO 출력
            if(stack.empty()){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}