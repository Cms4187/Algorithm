import sys
input = sys.stdin.readline()

N = int(input().rstrip())
Info = []
print(N)
for i in range(N):
    Age, Name = map(str, input().split())
    Info.append((Age, Name))
    #앞의 값은 나이값 = int값 이므로, 값을 넣어준 다음에 int값으로 변경해줌
    Info[i][0] = int(Info[i][0])

Info.sort(key=lambda x:x[0])
for i in Info:
    print(i[0],i[1])






