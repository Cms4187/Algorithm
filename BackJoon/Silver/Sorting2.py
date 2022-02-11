#문제에 입력값이 1~100만이므로 그냥 입력받으면 시간초과
#sys를 사용하기
import sys
N = int(input())
NL = []

for i in range(N):
    NL.append(int(sys.stdin.readline()))
    #NL.append(int(input()))

NL.sort()

for j in range(N):
    print(NL[j])