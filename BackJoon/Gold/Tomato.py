#하나의 줄에 M개씩 토마토가 들어감
#1은 익은 토마토, 0은 익지 않은 토마토, -1은 빈 칸
#토마토가 하나 이상 있는 경우만 입력으로 주어진다.
#토마토가 모두 1이 될 때까지 필요한 최소 일수 출력

from collections import deque
import sys
input = sys.stdin.readline

#상자의 크기 M: 가로(행), N: 세로(열)
#2 <= M, N <= 1000
M, N = map(int, input().split())

#빈 박스를 만들고, 박스 안에 토마토 존재 데이터를 받아줌
Box = []
for _ in range(N):
    Box.append(list(map(int, input().split())))

#큐 생성
queue = deque()

#익은 토마토는 매일 상, 하, 좌, 우로만 안 익은 토마로를 익게 해줌
#순서대로 좌, 우, 상, 하
mx = [-1, 1, 0, 0]
my = [0, 0, -1, 1]

#날짜를 기록할 변수
day = 0

#입력받은 값을 전부 본 다음 입력된 값이 1(익은 토마토)이면
#큐 안에 넣어주어 토마토의 위치 좌표를 추가해줌
for i in range(N):
    for j in range(M):
        if Box[i][j] == 1:
            queue.append((i, j))

def bfs():
    while queue:
        x, y = queue.popleft()

        for i in range(4):
            #상, 하, 좌, 우 하나씩 순서대로 탐색
            nx = x + mx[i]
            ny = y + my[i]
            
            #상자 밖으로 가지면 무시
            if nx < 0 or ny < 0 or nx >= N or ny >= M:
                continue
    
            #상하좌우를 봤을 때 이동할 곳이 0 이면 (안 익은 토마토이면)
            #익혀주고 1을 더해 날짜 수를 늘려줌, 가장 큰 값이 최종 날짜 (최소일수)
            if Box[nx][ny] == 0:
                Box[nx][ny] = Box[x][y] + 1
                queue.append((nx, ny))

#bfs 실행
bfs()

#1인 값(익은 토마토) 를 찾아서 시작시킴
for i in Box:
    for j in i:
        #2중 for문으로 첫줄부터 마지막 줄까지 전부 찾음
        if j == 0:
            #모두 익지 않았으면 -1 출력 후 종료
            print(-1)
            #break은 반복문만 중단시켜서 exit(0)으로 아얘 끝내주어야함
            exit(0)
    #다 익었다면 가장 큰 값을 day에 넣어줌 (최종 일수가 됨)
    day = max(day, max(i))

print(day-1)