import sys
from collections import deque

N = int(sys.stdin.readline().strip())

card = deque()

for i in range(1, N+1):
    card.append(i)

#카드 길이가 1보다 작거나 같으면 불가. 1보다 클때만 while문 돌게 설정
while (len(card) > 1):
    card.popleft()
    card.append(card.popleft())

print(card[0])
