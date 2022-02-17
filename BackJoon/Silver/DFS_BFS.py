#BFS에 사용하기 위해 데크 import
#DFS는 스택의 자료 구조(First-In-Last-Out, 후입선출, 박스안에서 꺼내는 구조) -> 주로 재귀 함수 사용
#BFS는 큐의 자료 구조(First-In-First-Out, 선입선출, 원통 구조) -> 최단 이동거리 등에 쓰임
from collections import deque

#DFS 함수
#그래프가 적힐 리스트(graph)와 방문한 곳을 처리할 리스트(visited)를 사용
def dfs(graph, v, visited):
    visited[v] = True #해당 노드를 방문 처리, 처음에는 시작 노드를 입력받은 V(=v)로 지정해 V번 노드를 방문 처리함
    print(v, end=' ') #방문한 노드 출력
    for i in graph[v]: #현재 확인하고 있는 노드(스택의 최상단 노드)와 연결된 다른 노드를 하나씩 방문
        if visited[i] == 0: #인접 노드 i 가 방문되지 않은 상태라면 => if not visited[i]와 같은 구문
            dfs(graph, i, visited) #방문하고 출력하게끔 i를 넣어준다. 

#BFS함수, 특정 조건에서 최단조건을 탐색하기 위해 효과적인 알고리즘이라 코테에 자주 보임
def bfs(graph, v, visited):
    queue = deque([v]) #시작 노드를 먼저 큐에 넣어줌
    visited[v] = True #해당 노드를 방문 처리, 처음에는 시작 노드를 입력받은 V(=v)로 지정해 V번 노드를 방문 처리함
    while queue: #큐에 노드를 넣고 빼면서 노드가 전부 방문될때까지 반복
        v = queue.popleft() #큐에서 popleft를 이용해 가장 먼저 들어온 노드를 v값에 넣어줌
        print(v, end=" ") #popleft로 꺼낸 노드를 출력
        for i in graph[v]: #아직 방문하지 않은 인접한 노드를 큐에 넣어줌
            if visited[i] == 0: #인접 노드 i가 방문되지 않았으면 => if not visited[i]와 같은 구문
                queue.append(i) #큐에 해당 노드를 추가해줌
                visited[i] = True #해당 노드를 방문한 것으로 처리

#정점 갯수 N, 간선 갯수 M, 탐색을 시작할 정점 번호 V
N, M, V = map(int, input().split())

#정점간 연결 정보를 저장해둘 리스트
link = [[] for _ in range(N+1)]

#각 노드가 방문된 정보를 표현하는 1차원 리스트 -> visited
#처음엔 하나도 방문하지 않았어야하니 False(0)으로 표현
#노드 시작이 1이므로 헷갈리지 않게 리스트의 0번 index가 아닌 1번 index부터
#사용하기 위해 일부러 N+1까지 만들어준다.
visited = [False]*(N+1)

#간선이 연결하는 두 정점의 번호를 입력받아 link 리스트의 index에 넣음
#간선 갯수만큼 반복함
#Ex) 1 3, 2 3을 입력하면 1은 [3], 2는 [3], 3은 [1, 2]가 된다.
#     [] 안의 값은 해당 정점이 간선으로 연결된 정점이다.
for _ in range(M):
    First, Second = map(int, input().split())
    link[First].append(Second)
    link[Second].append(First)

for s in range(1, N+1):
    link[s].sort()

#DFS, 그래프(link리스트), 시작할 정점 번호(V), 방문 정보를 저장할 리스트(visited) 넣고 함수 호출해 연산
dfs(link, V, visited)

#visited 리스트를 dfs에서 사용했으므로 bfs에서 사용하기 위해 다시 원래처럼 값을 바꿔줌
visited = [False]*(N+1)

print()
#BFS
bfs(link, V, visited)





