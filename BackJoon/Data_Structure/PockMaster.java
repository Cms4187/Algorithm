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

//아래코드는 시간초과임
// public class PockMaster {

//     public static boolean tryInt(String value){
//         try{
//             Integer.parseInt(value);
//             return true;
//         }catch(NumberFormatException ex){
//             return false;
//         }
//     }
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());
//         ArrayList<String> PockList = new ArrayList<>(N);
        
//         if(1 <= N && N <= 100000 && 1 <= M && M <= 100000){
//             for(int i=0; i<N; i++){
//                 PockList.add((br.readLine()));
//             }
//           // System.out.println("도감 입력 완료");
//             for(int j=0; j<M; j++){
//                 String Pockmon = br.readLine();
//                 //입력받고 tryInt(Int 값인지, 문자열 값인지 확인) 함수를 실행 후
//                 //포켓몬 이름이면 도감 번호를, 숫자면 해당 번호의 포켓몬을 출력
//                 //번호일 때 해당 번호의 포켓몬 이름 출력
//                 if(tryInt(Pockmon) == true){
//                     System.out.println(PockList.get(Integer.parseInt(Pockmon)-1));
//                 } //포켓몬 이름일 때 도감 번호 출력
//                 else{
//                     System.out.println(PockList.indexOf(Pockmon)+1);
//                 }
//             }
//         }
//     }
// }

//출력시 StringBuilder를 사용하는 것이 좀 더 시간이 빠름
//코드에선 바로 println으로 출력하도록 함.
//바로출력(1500ms) < StringBulder(800ms)
public class PockMaster {
    //입력된 값이 번호인지 포켓몬이름인지 확인
    public static boolean tryInt(String value){
        try{
            Integer.parseInt(value);
            return true;
        }catch(NumberFormatException ex){
            return false;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //ArrayList 사용시 시간초과. 문자열 탐색은 HashMap이 효율적임
        HashMap<String, Integer> PockList = new HashMap<String, Integer>();
        String[] nameArr = new String[N+1];
        // StringBuilder sb = new StringBuilder();

        if(1 <= N && N <= 100000 && 1 <= M && M <= 100000){
            //포켓몬 입력(N번)
            //찾을 때 계산이 편하도록 1번부터 넣어줌
            for(int i=1; i<N+1; i++) {
                String Pockmon = br.readLine();
                PockList.put(Pockmon, i);
                nameArr[i] = Pockmon;
            }
            
            //검색(M번)
            //while(M --> 0)에서 M --> 0은
            //M--; M>0; 이 두 가지를 합쳐놓은 것
            //즉, M이 0이 될때까지 -1 해줌
            while(M --> 0) {
                String findPockmon = br.readLine();
                if(tryInt(findPockmon)) { //숫자를 입력받으면 해당 번호의 포켓몬 이름 출력
                    int index = Integer.parseInt(findPockmon);
                    System.out.println(nameArr[index]);
                    // sb.append(nameArr[index]);
                }
                else {	//포켓몬 이름을 입력받으면 해당 포켓몬 번호 출력
                    // sb.append(PockList.get(findPockmon));
                    System.out.println(PockList.get(findPockmon));
                }
                // sb.append("\n");
            }
            
            // System.out.println(sb.toString());
        }
    }
}