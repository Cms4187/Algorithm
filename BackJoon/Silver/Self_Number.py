N = int(input())
#몸무게, 키 정보를 저장할 리스트(2차원 리스트로 사용됨)
Info = []
#순위 정보를 저장할 리스트
Rank = []

#덩치는 (X, Y)로 표시된다. X=몸무게, Y=키
#만약 몸무게와 키가 둘 다 크면 덩치가 더 크다고 출력한다.

#먼저 Info에 2차원 리스트로 정보를 입력 받는다.
for _ in range(N):
    Weight, Height = map(int, input().split())
    Info.append((Weight, Height))


# for i in range(len(Info)):
#     Prank = 1
#     for j in range(len(Info)):
#         # if i[0] < j[0] and i[1] < j[1]
#             Prank += 1
#     print(Prank, end=" ")
    
