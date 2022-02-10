#빠른 A+B
import sys

#실행할 횟수
T = int(input())

for i in range(T):
    A, B = map(int, sys.stdin.readline().split())
    if (1 <= A <= 1000) and (1 <= B <= 1000):
        print(A+B)