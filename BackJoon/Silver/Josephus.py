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

#17줄 append할 때 str형으로 append하고, join함수써서 출력시 1줄로 출력 가능
print("<",', '.join(pop_Peo),">", sep="")