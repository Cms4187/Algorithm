#1. 반복문을 사용했기 때문에 올라야할 V가 크면 문제에 제시된 0.15초 (150ms)를 시간초과함.

#A: 올라갈 거리, B: 미끄러질 거리, V: 올라야 할 높이
A, B, V = map(int, input().split())
Pr = 0
Day = 0

while True:
    if V <= Pr:
        break
    #A만큼 오르고 V에 도달하지 못했다면 B만큼 빼주고 날짜 + 1해줌
    Pr += A
    if Pr < V:
        Pr -= B
    Day += 1

print(Day)

#2. 반복문을 사용하지 않고 날짜를 계산하는 코드
#math의 ceil을 사용해 Day값을 올림 처리해줌
import math
#식: (A-B)를 Day-1번 반복하고 A만큼 이동해야 V에 도달함
#1) (A-B)*Day + A = V
#2) V - A = (A-B)*Day
#3) (V-A) / (A-B) = Day

A, B, V = map(int, input().split())
#Day-1 번 반복해야 하므로 식에 + 1을 해줘야 Day번 반복한게 된다.
Day = (V - A) / (A - B) + 1
print(math.ceil(Day))

