#피라미드
n = int(input())

for i in range(1, n+1):
    print(" "*(n-1) + "*"*(i*2-1))
    n -= 1


#마름모 (피라미드+역피라미드)
n = int(input())
m = n

for i in range(1, n):
    print(" "*(n-1)+ "*"*(i*2-1))
    n -= 1

for j in range(0, m):
    print(" "*j, end='')
    print("*"*(m*2-1))
    m -= 1