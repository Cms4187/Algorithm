#미로의 최단경로를 찾는 문제이므로 DFS가 아닌 BFS로 풀어야 좋음
from collections import deque

#미로의 행, 렬 크기를 입력받음
N, M = map(int, input().split())

#빈 미로를 만들어줌
Maze = []

#미로에서 움직이는 좌표 값 변동에 사용할 리스트
#move_x, move_y가 동시에 사용됨
#Ex) move_x[0], move_y[0] => 왼쪽이동 같이 사용됨
move_x = [-1, 1, 0, 0]
move_y = [0, 0, -1, 1]

#Maze 리스트에 미로 값를 입력받음
for _ in range(N):
    Maze.append(list(map(int, input())))

#BFS 함수 구현
def bfs(X, Y):
    #큐 구현을 위해 deque라이브러리를 사용해 큐 변수를 만들어줌
    queue = deque()
    #시작 지점이 0, 0이므로 0, 0을 큐 제일 앞 인덱스에 넣어줌
    queue.append((0, 0))

    #큐 안에 데이터가 있다면 반복
    while queue:
        #큐의 가장 왼쪽 값(현재 좌표값)을 빼서 X, Y값에 각각 넣어줌
        X, Y = queue.popleft()
        #print(X, Y)
        #현재있는 위치에서 네 가지 방향(상, 하, 좌, 우)로 좌표를 확인
        for m in range(4):
            #move_x, move_y 값이 들어있는 값 순서대로 좌, 우, 상, 하임
            next_x, next_y = X+move_x[m], Y+move_y[m]
            #print(next_x, next_y)

            #※ 범위를 벗어나거나 벽일 때는 이동을 취소하게 하는 if문 필요

            #만약 움직였을 때 X, Y값 중 하나라도 네 가지 방향중 하나로 이동했을 때 범위를 벗어날 시 이동 취소
            if next_x < 0 or next_y < 0 or next_x >= N or next_y >= M:
                continue
            #만약 이동하려는 곳이 0일 경우 벽이므로 이동 취소
            if Maze[next_x][next_y] == 0:
                continue
            #만약 벽이 아닌 1(길)이면 이동하고 큐 안에 현재 좌표값을 넣어줌
            if Maze[next_x][next_y] == 1:
                Maze[next_x][next_y] = Maze[X][Y] + 1
                queue.append((next_x, next_y))
    
    #마지막 값에서 카운트된 값을 return 해줌
    return Maze[N-1][M-1]

print(bfs(0, 0))