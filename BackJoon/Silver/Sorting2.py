#문제에 입력값이 1~100만이므로 그냥 입력받으면 시간초과
#sys를 사용하기
#input은 하나씩 입력할 때마다 데이터를 버퍼에 보관하고
#stdin.readline()은 한번에 읽어와 버퍼에 저장하기 때문에
#입력이 많을수록 후자가 더 빠르다.
import sys
N = int(input())
NL = []

for i in range(N):
    NL.append(int(sys.stdin.readline()))
    #NL.append(int(input()))

NL.sort()

for j in range(N):
    print(NL[j])