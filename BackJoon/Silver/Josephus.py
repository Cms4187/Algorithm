import sys

N, K = map(int, sys.stdin.readline().split())

Peo = [_ for _ in range(1, N+1)]
pop_Peo = []
del_k = 0

while Peo:
    #K-1 번째 인덱스를 제거할 사람으로 지정
    del_k += K-1
    if del_k >= len(Peo):
        del_k = del_k % len(Peo)

    pop_Peo.append(Peo[del_k])
    Peo.pop(del_k)

print("<", end="")

for i in range(len(pop_Peo)):
    if i == len(pop_Peo)-1:
        print(pop_Peo[i], end="")
        break
    print(pop_Peo[i], end=", ")

print(">", end="")

