N = int(input())

M = list(map(int, input().split()))

count = 0

#2부터 M[i]인 수까지 M[i]를 나눠보고, 범위내 모든 수로 나눈 나머지가
#0으로 떨어지지 않으면 소수로 판별하고 카운트 + 1


for i in M:
    #1은 소수가 아니므로 그냥 넘긴다
    if i == 1:
        continue
    #i가 1이 아닌 수라면, 2부터 i값-1까지 돌리는 for문 시작
    for j in range(2, i):
        #만약 i가 j(2부터 i-1인 수까지)로 나눈 나머지가 0이 나오면
        #소수가 아니므로 다음 인덱스로 넘어감
        if i % j == 0:
            break
    #1도 아니고, 위 방식으로 나눈 나머지가 0이 아닌 수라면 소수이므로 카운트 + 1
    else:
        count += 1
print(count)