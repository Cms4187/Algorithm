C = int(input())

for i in range(C):
    Total = 0
    Avg = 0
    Over_Avg = 0
    Students = list(map(int, input().split()))
    #N은 학생의 수
    N = Students[0]
    #1번째인 학생 수 빼고 점수 부분 만큼만 반복
    for j in range(1, N+1):
        Total += Students[j]

    Avg = Total / N

    for k in range(1, N+1):
        if Students[k] > Avg:
            Over_Avg += 1
    
    print("평균: ",Avg, ", 평균이상: ",Over_Avg)
    
    print("{:.3f}%".format(Over_Avg/N*100))




