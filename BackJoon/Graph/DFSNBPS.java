import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DFSNBPS {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String val = br.readLine();

        StringTokenizer st = new StringTokenizer(val);

        //N: 정점 갯수 M: 간선 갯수 V: 시작 정점
        int point = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        

        //index번호 안 헷갈리게 갯수 +1 만큼 해주어 더 크게 만들어줌
        int[][] arr = new int[point+1][line+1];
        boolean[] visitNode = new boolean[line+1];

        for(int i=0; i<line; i++){
            String Point_Line = br.readLine();
            StringTokenizer st2 = new StringTokenizer(Point_Line);

            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            //배열 내에서 상호 체크(인접행렬)하여 연결된 것은 1로 표시함
            arr[a][b] = arr[b][a] = 1;

        }
        // System.out.println(Arrays.deepToString(arr));

        DFS(start, line, arr, visitNode);
        System.out.println();
        //BFS를 위해 방문 노드 체크 초기화
        Arrays.fill(visitNode, false);
        // BFS();

    }

    static void DFS(int start, int line, int[][] arr, boolean[] visitNode){
        //방문한 노드 체크 및 출력 후 다음껄로 이동
        visitNode[start] = true;
        System.out.print(start + " ");

        for(int i=1; i<=line; i++){
            //만약 배열[노드][연결노드]가 1인데 체크 X면 i노드로 이동, 재귀
            if(arr[start][i] == 1 && visitNode[i] == false){
                DFS(i, line, arr, visitNode);
            }
        }
    }

    static void BFS(int start, int line, int[][] arr, boolean[] visitNode){

    }
}
