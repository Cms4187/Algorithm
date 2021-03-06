#왕실의 나이트, 20분, 1초, 128MB

#8X8의 평면 체스판이 주어진다.
#나이트가 체스판 안에 있으며, 나이트는 L자 형태로만 이동, 밖으로 나갈 수 없다.

#특정 위치에서 아래 2가지 경우로 이동할 수 있다.
#1. 수평(열)으로 두 칸 이동 후 수직으로 한 칸 이동
#2. 수직(행)으로 두 칸 이동 후 수평으로 한 칸 이동

#행 위치는 1~8, 열 위치는 a~h로 표현한다.

#Ex) 나이트가 a1에 있으면 1번 경우에는 c2, 2번 경우에는 b3으로 이동한다.

#입력 조건: 첫째 줄에 8X8 좌표 평면 상에서 현재 나이트가 위치한 곳의 좌표를 나타내는 두 문자로 구성된 문자열 입력
#              입력 문자는 a1처럼 열과 행으로 이루어진다.

#출력 조건: 첫째 줄에 나이트가 이동할 수 있는 경우의 수 출력

#입력예시: a1               => 출력 예시: 2

#코드 작성

#움직일 수 있는 8가지의 변수를 담은 리스트
Moving = [(2, 1), (2, -1), (1, -2), (1, 2), (-1, 2), (-1, -2), (-2, 1), (-2, -1)]
#움직일 수 있는 곳이 몇 개인지 세주는 변수값
Move_Count = 0

#초기 위치값 입력 받음
Knight = input()

#열 값 a~h, ord를 사용해 아스키코드 값으로 받아줌
column = int(ord(Knight[0])) - ord('a') + 1
#행 값 1~8
row = int(Knight[1])

print("행: ",row,"열: ",column,"열값: ",Knight[0])

for Move in Moving:
    Next_row = row + Move[0]
    Next_column = column + Move[1]
    #움직이는 곳의 값이 행 1~8, 열 a~h 범위 둘 다 성립해야 Move_Count에 + 1을 해준다 
    if Next_row <= 8 and Next_row >= 1 and Next_column <= 8 and Next_column >= 1:
        Move_Count += 1

print(Move_Count)
