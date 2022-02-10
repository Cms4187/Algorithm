N = int(input())

Total = 0
Scores = list(map(int, input().split()))
M = max(Scores)

#입력한 성적 갯수만큼만 Scores에 입력한 점수를 넣어줌
#Scores에 10개를 넣어도 N=3이면 앞 3개만 넣어줌
for i in range(N):
    Scores[i] = Scores[i]/M*100

for i in range(N):
    Total += Scores[i]

Average = Total / N

print(Average)
