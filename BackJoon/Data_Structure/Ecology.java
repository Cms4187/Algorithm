package BackJoon.Data_Structure;

import java.io.*;
import java.util.*;

//입력
//프로그램은 여러 줄로 구성, 한 줄에 하나의 나무 종 이름이 주어진다.
//종 이름은 30자 이하, 입력은 최대 10,000종, 최대 1,000,000 그루의 나무가 주어진다.

//출력
//주어진 각 종의 이름을 사전순으로 출력,
//그 종이 차지하는 비율을 백분율로 소수점 넷 째자리까지 반올림해 함께 출력

//1~N개를 입력받고, 입력된 갯수만큼 비율을 따져야 함
//Ex. 29줄에 종이 입력되고, Red Oak가 2번 입력되었다면 "Red Oak 6.8966" 처럼 출력되어야 한다.

public class Ecology {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //나무를 종 별로 저장할 HashMap 생성, 종의 총 갯수를 저장할 변수(allTree) 생성
        int allTree = 0;
        //HaspMap은 <키, 값> 쌍으로 구성됨 여기선 <종이름, 번호> 로 구성
        //문자열 검색시 HashMap이 빠르기에 ArrayList대신 HashMap 사용
        HashMap<String, Integer> treeList = new HashMap<String, Integer>();

        //입력된 나무 종을 사전순으로 출력하기 위한 배열
        ArrayList<String> treeArr = new ArrayList<String>();

        //나무 종 이름이 입력되지 않으면 종료
        while(true){
            String treeName = br.readLine();
            if(treeName == null || treeName.length() < 1){
                break;
            }
            allTree++;
            //getOrDefault(Object key, V DefaultValue)
            //=> 찾는 키가 존재하면 찾는 키의 값을 반환, 없으면 기본 값을 반환하는 메서드
            //입력되면 이미 입력된 종이라면 새로 추가하지 않고 해당 Key값의 Value + 1을 해줌
            treeList.put(treeName, treeList.getOrDefault(treeName, 0) + 1);
        }

        //해시맵 값을 ArrayList에 넣어주기 || 해시맵 출력시 아래처럼 for문 작성해야 함
        for(Map.Entry<String, Integer> myTree : treeList.entrySet()){
            String arrTree = myTree.getKey();
            treeArr.add(arrTree);
        }
        //사전 순 출력을 위해 정렬
        Collections.sort(treeArr);

        for (String tree : treeArr) {
            ////종 이름(키값)에 해당하는 Value를 찾아 곱해줌
            //비율 = ((종갯수/전체갯수) * 100)
            int count = treeList.get(tree);
            //연산시 double 자료형으로 연산시켜야 제대로 동작
            double ratio = ((double)count / (double)allTree) * 100;
            //"나무명 비율" 로 출력되게 StringBuilder에 넣기
            sb.append(tree + " " + String.format("%.4f", ratio) + "\n");
        }
        System.out.print(sb);
    }
}
