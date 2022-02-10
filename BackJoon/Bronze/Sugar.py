#설탕 Nkg만큼을 들고갈 때, 반드시 최소한의 count로 들고갈 수 있는 방법

N = int(input())
count = 0

#N이 0보다 크면 계속 반복
while (0 <= N):
    #N이 5로 나누어지면 5로 나누고 몫을 count에 더해주고 출력 후끝냄
    if N % 5 == 0:
        count += N // 5
        print(count)
        break
    #만약 5로 나누어지지 않으면 N에서 3씩 계속 빼주면서 count에 1씩 더해줌
    else:
        N -= 3
        count += 1

#N이 0보다 작거나 같아지면 -1을 출력시킴
#Ex) 7이 입력되면 -2가 아닌 -1을 출력되게끔
else:
    print(-1)


