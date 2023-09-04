package BackJoon.Data_Structure;

import java.io.*;
import java.util.*;

//입력
//첫 줄: 포켓몬 수 N, 맞춰야하는 문제 수 M 주어짐 (1 <= N, M <= 100,000)
//둘째 줄부터 N 줄에 1번 ~ N번 포켓몬이 한 줄에 하나씩 입력됨 (이름은 모두 영어)
//첫글자만 대문자, 나머지는 소문자임. 일부는 마지막이 대문자 일 수 있음.
//길이는 2 ~ 20자. N줄 이후 M개의 줄에는 맞춰야하는 문제가 입력됨
//문제가 알파벳으로만 들어오면 포켓몬 번호, 숫자면 포켓몬 번호에 해당하는 문자 출력
//입력되는 수는 1이상, N이하. 문자는 반드시 도감에 있는 포켓몬 이름만 주어짐

//출력
//1번 줄부터 M개의 줄에 각 문제에 대한 답을 출력 (숫자: 포켓몬이름, 포켓몬이름: 도감 번호)

public class Pockmon{
    public static void Main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        System.out.println(N);
        System.out.println(M);
    }
}