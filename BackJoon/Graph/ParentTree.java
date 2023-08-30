package BackJoon.Graph;

import java.util.*;
import java.io.*;

//필요한 리스트: 트리를 저장할 리스트, 부모 노드 정보를 저장해둘 리스트, 방문 여부 체크 리스트
public class ParentTree{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());

        //노드 갯수가 최대 100000이므로 인접행렬대신 인접리스트로 생성
        ArrayList<Integer>[] arr = new ArrayList[node+1];
        //부모 노드를 저장할 리스트
        int[] par = new int[node+1];
        //방문 여부 체크 리스트
        boolean[] check = new boolean[node+1];
        
        //ArrayList는 초기화 안하면 null값 들어가있어서 초기화 해주어야 함.
        for(int i=0;i<=node;i++){
            arr[i] = new ArrayList<Integer>();
        }

        //node-1까지, 트리 상에서 연결된 두 정점을 입력
        for(int i=1; i<node; i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        System.out.println(Arrays.deepToString(arr));

        tree(1, arr, par, check);
        //출력은 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력
        for(int j=2; j<=node; j++){
            System.out.println(par[j]);
        }
    }
    static void tree(int start, ArrayList<Integer>[] arr, int[] par, boolean[] check){
        check[start] = true;
        //향상된 for문으로, ArrayList의 start index내 값을 전부 돌림
        for(int i: arr[start]){
            if(check[i] == false){
                par[i] = start;
                tree(i, arr, par, check);
            }
        }
    }
}
