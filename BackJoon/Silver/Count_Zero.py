T = int(input())

for t in range(T):
    N, M = map(int, input().split())
    count = 0
    #N~M범위 만큼 for문 실행
    for i in range(N, M+1):
        #문자열로 바꿔주고, 문자로 바꾼 i번째 수 안에 0이 몇개 들어있는지
        #count함수로 세주고 카운트하는 값에 넣어줌
        A = str(i)
        count += A.count("0")

    print(count)
    

