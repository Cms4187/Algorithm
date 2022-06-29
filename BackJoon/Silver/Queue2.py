import sys
from collections import deque

N = int(sys.stdin.readline())
que = deque([])

for _ in range(N):
    cmd = sys.stdin.readline().strip()

    if "push" in cmd:
        push_val = cmd[5:]
        que.append(push_val)
        print(que)

    elif "pop" in cmd:
        if not que:
            print(-1)
        else:
            pop_val = que[0]
            que.popleft()
            print(pop_val)

    elif "size" in cmd:
        print(len(que))

    elif "empty" in cmd:
        if not que:
            print(1)
        else:
            print(0)

    elif "front" in cmd:
        if not que:
            print(-1)
        else:
            print(que[0])

    elif "back" in cmd:
        if not que:
            print(-1)
        else:
            print(que[-1])