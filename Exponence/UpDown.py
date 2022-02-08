#상하좌우 움직이기

#L: 왼쪽, R: 오른쪽, U: 위, D: 아래
#각각 해당 방향으로 한 칸 이동, 시작 지점은 (1, 1), 최대 (N, N)까지 이동, 범위 벗어나는 움직임 무시 -> (0,1) 로 이동 등

#입력 조건: 첫째 줄에 공간 크기 N 주어짐 (N은 1~1000)
#              둘째 줄에 A가 이동할 계획서 내용 주어짐 (이동횟수는 1~100)
#출력 조건: 첫째 줄에 여행가 A가 최종적으로 도착할 지점의 좌표 (X, Y)를 공백으로 구분해 출력

#시작 좌표 1,1 저장
X, Y = 1, 1
#움직이는 위치를 대조할 문자를 넣은 리스트
Move = ["L", "R", "U", "D"]

#공간 크기 N 입력받기
N = int(input("공간 크기 입력: "))

#움직일 횟수 M 입력받기
M = input("움직일 문자 입력(R, L, U, D): ").split()

#M이 아직 전부 소모되지 않았을 때 계속함
#X, Y값이 0보다 작아지거나 N크기 벗어나면 넘김
for i in M:
    if i == "L":
        X -= 1
        if X <= 0:
            X += 1

    elif i == "R":
        X += 1
        if X > N:
            X -= 1

    elif i == "U":
        Y -= 1
        if Y <= 0:
            Y += 1

    elif i == "D":
        Y += 1
        if Y > N:
            Y -= 1

print("X: ", X, ", Y: ", Y)
    


#답안지

N = int(input())
X, Y = 1, 1
M = input().split()

#L, R, U, D에 따른 X, Y의 이동 값
Mx = [-1, 1, 0, 0]
My = [0, 0, -1, 1]
Move_Types = ['L', 'R', 'U', 'D']

for plan in M:
    #움직일 값 안에 있는 걸 입력했으면 시작
    for i in range(len(Move_Types)):
        if plan == Move_Types[i]:
            Nx = X + Mx[i]
            Ny = Y + My[i]
        
    if Nx < 1 or Ny < 1 or Nx > N or Ny > N:
        continue

    X, Y  = Nx, Ny

print(X, Y)
