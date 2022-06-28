#자료구조 - 스택

import sys

N = int(sys.stdin.readline())
MyStack = []

for _ in range(N):
    cmd = sys.stdin.readline()
    if "push" in cmd:
        value = cmd[5:]
        MyStack.append(int(value))

    elif "pop" in cmd:
        if len(MyStack) < 1:
            print(-1)
        else:
            pop_value = MyStack[-1]
            print(pop_value)
            MyStack.pop(-1)

    elif "size" in cmd:
        print(len(MyStack))

    elif "top" in cmd:
        if len(MyStack) < 1:
            print(-1)
        else:
            print(MyStack[-1])

    elif "empty" in cmd:
        if len(MyStack) < 1:
            print(1)
        else:
            print(0)