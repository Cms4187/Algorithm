from collections import deque

def bfs(X, Y):
    #bfs를 실행하는 단지 내 집 수를 저장할 house 변수
    #X, Y값이 들어간다는 것은 아래 이중 for문(60줄)을 통해
    #해당 좌표 값이 집임을 확인했으므로 1을 카운팅해주고 1부터 시작함
    house = 1
    #queue변수를 deque 라이브러리로 구현
    queue = deque()
    #queue안에 시작 좌표(X, Y)를 넣어주고 시작시킴
    queue.append((X, Y))
    #탐색한 좌표의 값 1을 0으로 바꾸어 중복 탐색하지 않도록 함
    Map[X][Y] = 0

    #queue안에 자료가 있으면 계속 반복
    while queue:
        #X, Y값에 queue의 가장 왼쪽 인덱스 값을 빼서 넣어줌
        X, Y = queue.popleft()
        #상하좌우로 움직이면서 좌표 확인
        for i in range(4):
            nx = X+mx[i]
            ny = Y+my[i]

            #범위를 벗어나면 움직임 취소
            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                continue
            #집이 없는 곳(0)이면 움직임 취소
            if Map[nx][ny] == 0:
                continue
            #집이 있는 곳(1)이면 집 수 카운트
            if Map[nx][ny] == 1:
                #해당 좌표의 값을 0으로 해 중복 탐색 하지 않도록 바꿔줌
                Map[nx][ny] = 0
                #queue 변수에 해당 X, Y(nx, ny)값을 넣고 while queue로 돌아가 다시 탐색
                queue.append((nx, ny))
                #집이므로 집 수 + 1
                house += 1
    #단지 내 집 수를 카운팅해 InHouse 리스트에 넣어줌
    InHouse.append(house)



#맵 크기를 받는 N변수 (N*N 크기의 맵)
N = int(input())

#단지 수를 저장할 변수
danzi = 0

#맵을 만들 빈 리스트를 만들고, 아래 for문을 통해 리스트 안에 자료를 넣어줌
Map = []
#각 단지별 집 수를 카운팅한 값을 저장할 리스트를 만들어줌
InHouse = []

#X, Y 각각의 좌표값 변동에 사용할 리스트를 만들어줌
mx = [-1, 1, 0, 0]
my = [0, 0, -1, 1]

#맵 값을 2차원 리스트 값으로 넣어줌
for _ in range(N):
    Map.append(list(map(int, input())))

#맵을 첫 행(i)부터 열(j) 하나하나 확인하면서 집이 있다면 해당 집 좌표에서
#bfs함수를 실행하고, bfs가 끝났으면 단지 내 집이 더 없으므로 단지 수 + 1
for i in range(N):
    for j in range(N):
        if Map[i][j] == 1:
            bfs(i, j)
            danzi += 1

#모든 단지내 집 수를 오름차순으로 출력해야 하므로 정렬시킴
InHouse.sort()

#단지 수 출력
print(danzi)
#단지별 집 수를 저장한 리스트에서 순서대로 출력
for k in InHouse:
    print(k)
