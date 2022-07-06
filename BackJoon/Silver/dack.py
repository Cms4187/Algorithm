import sys
from collections import deque

N = int(sys.stdin.readline().strip())

deq = deque([])

for _ in range(N):
    cmd = sys.stdin.readline().strip()

    if "push_back" in cmd:
        ps_val = cmd[10:]
        deq.append(ps_val)

    elif "push_front" in cmd:
        ps_val = cmd[11:]
        deq.appendleft(ps_val)

    elif "pop_front" in cmd:
        ps_val = cmd[10:]
        if not deq:
            print(-1)
        else:
            print(deq.popleft())
    
    elif "pop_back" in cmd:
        ps_val = cmd[9:]
        if not deq:
            print(-1)
        else:
            print(deq.pop())

    elif "size" in cmd:
        print(len(deq))
    
    elif "empty" in cmd:
        if not deq:
            print(1)
        else:
            print(0)

    elif "front" in cmd:
        if not deq:
            print(-1)
        else:
            print(deq[0])

    elif "back" in cmd:
        if not deq:
            print(-1)
        else:
            print(deq[-1])