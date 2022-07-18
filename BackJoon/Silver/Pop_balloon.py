#풍선 터트리기

import sys
from collections import deque

N = int(sys.stdin.readline().strip())

#enumerate를 사용해 인덱스 값과 인덱스를 한 번에 deque에 저장시킴
num = deque(enumerate(map(int, sys.stdin.readline().split()), 1))
#print(num)

result = []
pop_bal = 0

while num:
    #pop_idx: 터트릴 풍선의 번호, pop_num: 터트린 풍선에서 이동할 숫자
    pop_idx, pop_num = num.popleft()
    result.append(pop_idx)
    

    #만약 다음 터트릴 풍선 찾으러 움직일 숫자가 양수면 우로 회전
    if pop_num > 0:
        #pop_num만큼 우측으로 인덱스 이동
        num.rotate(-(pop_num - 1))
    #만약 다음 터트릴 풍선을 찾으러 움직일 숫자가 음수면 좌로 회전
    elif pop_num < 0:
        #pop_num만큼 좌측으로 인덱스 이동
        num.rotate(-pop_num)

for i in range(len(result)):
    print(result[i], end=" ")



