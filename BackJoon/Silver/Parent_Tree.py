import sys
input = sys.stdin.readline
#제출 시 런타임 에러가 발생한다.
#이는 재귀 깊이(반복 횟수)가 부족해서 생기는 문제이며, 재귀 깊이를 늘려주었다.
sys.setrecursionlimit(10**9)

N = int(input())

#노드의 갯수+1개만큼의 빈 인덱스를 가진 리스트(트리) 생성
#편의상 0번째부터가 아닌 1번째부터 사용할 것이므로 N+1개 생성
Line = [[] for _ in range(N+1)]

#부모 노드를 저장시킬 리스트
Parent = [0 for _ in range(N+1)]

#N-1개의 줄에 트리 상에서 두 정점이 연결되는 정보를 입력 받기
for _ in range(N-1):
    A, B = map(int, input().split())
    Line[A].append(B)
    Line[B].append(A)

#첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번째 노드부터 순서대로 출력
def dfs(graph, start, visit):
    for i in graph[start]: #현재 노드와 인접한 노드를 전부 방문
        if visit[i] == 0: #인접 노드 i가 방문되지 않은 상태라면
            visit[i] = start #방문되지 않은 i 노드를 시작 지점으로 놓고 dfs 재귀 실행
            dfs(graph, i, visit)

#시작 지점에 대한 제한은 없으므로 1번 노드를 시작 노드로 잡고 시작시킴
#사용할 그래프에 정점간 연결 정보가 들어있는 Line 리스트와
#각 노드의 부모 노드값을 저장시킬 리스트를 가져옴
dfs(Line, 1,  Parent)

#2번째 노드부터 출력시키라 했으므로 2를 넣어줌
for i in range(2, N+1):
    print(Parent[i])