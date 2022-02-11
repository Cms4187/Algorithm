N = int(input())
#몸무게, 키 정보를 저장할 리스트(2차원 리스트로 사용됨)
Info = []

#덩치는 (X, Y)로 표시된다. X=몸무게, Y=키
#만약 몸무게와 키가 둘 다 크면 덩치가 더 크다고 출력한다.

#먼저 Info에 2차원 리스트로 정보를 입력 받는다.
for _ in range(N):
    Weight, Height = map(int, input().split())
    #복수 변수 입력시 괄호 두 번 씌워줘야 TypeError 방지
    Info.append((Weight, Height))


#2중 for문으로 i번째 인덱스를 j를 이용해 맨앞~맨뒤까지 비교해줌
#만약 맨앞~맨뒤 중 i번째 인덱스보다 위에 정의한 것처럼 덩치가 크다면 순위값 + 1을 해줌
#키나 몸무게 둘 중 하나라도 크지 않으면 순위값 + 1을 하지 않으므로 공동 순위가 나올 수 있음
for i in Info:
    PersonRank = 1 #처음 랭킹은 1로 시작
    for j in Info:
        #Info의 비교대상 i번째 인덱스의 [0]과 [1] 값이
        #각각 j번째(맨앞~맨뒤) 인덱스의 [0]과 [1] 값보다 작으면 순위값 + 1
        if i[0] < j[0] and i[1] < j[1]:
            PersonRank += 1
    #비교 끝나면 해당 인덱스의 랭킹 출력
    print(PersonRank, end=" ")