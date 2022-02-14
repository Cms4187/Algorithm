#sys로 입력받아 빠르게 입력받음
import sys
input = sys.stdin.readline

N = int(input().rstrip())
Info = []
for i in range(N):
    #리스트에 띄어쓰기를 기준으로 나눠 입력받음
    Info.append(list(input().split()))
    #앞의 값은 나이값 = int값 이므로, 값을 넣어준 다음에 int값으로 변경해줌
    Info[i][0] = int(Info[i][0])

#[0]의 값을 비교해서 정렬해줌
Info.sort(key=lambda x:x[0])
for i in Info:
    print(i[0],i[1])






