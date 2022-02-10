#1. Max값을 별도로 저장하고, index값도 별도의 값에 저장해 출력
Num_list = []

for i in range(9):
    Num = int(input())
    if Num < 100:
        Num_list.append(Num)

print(Num_list)
Max = Num_list[0]
Max_index = 0

for i in range(len(Num_list)):
    if Max < Num_list[i]:
        Max = Num_list[i]
        Max_index = Num_list.index(Max)+1

print(Max)
print(Max_index)

#max함수를 사용해 최댓값을 구하고, index함수를 이용해 최댓값의 index값을 출력
N = []
count = 0
while True:
    A = int(input())
    count += 1
    N.append(A)
    if count == 9:
        break

print(max(N))
print(N.index(max(N))+1)