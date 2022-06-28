#자료구조 - 괄호

import sys

T = int(sys.stdin.readline())

for _ in range(T):
    count = 0
    vps = sys.stdin.readline().strip()
    st = list(vps)
    
    for i in st:
        if i == "(":
            count += 1
        elif i == ")":
            count -= 1
        #만약 ")" 값으로 인해 count가 0보다 작아지면 NO 출력하고 끝냄
        if count < 0:
            print("NO")
            break

    if count == 0:
        print("YES")
    elif count > 0:
        print("NO")
