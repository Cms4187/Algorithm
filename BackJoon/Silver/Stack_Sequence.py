import sys

from collections import deque

que = deque([])
output = deque([])
num = 1
no = False

N = int(sys.stdin.readline().strip())

for _ in range(N):
    #입력할 때마다 push, pop해줘야 함

    seq = int(sys.stdin.readline().strip())

    #입력값과 같아질때까지 더해줌
    while num <= seq:
        que.append(num)
        output.append("+")
        #print("+")
        num += 1

    #deque안 제일 우측 숫자가 입력값이랑 동일하면 제거하고 pop기호 append
    if que[-1] == seq:
        que.pop()
        output.append("-")
        #print("-")
    else:
        no = True

if no == False:
    for i in output:
        print(i)
else:
    print("NO")