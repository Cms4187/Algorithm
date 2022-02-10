#계산할 N개의 숫자 입력
N = int(input())
Sum = 0
#계산할 숫자 입력
#입력된 숫자는 342243 같이 입력되며, 각각 더해짐. Ex) 342243 => 3+4+2+2+4+3
Number_list = list(map(int, input()))
for i in range(N):
    Sum += Number_list[i]

print(Sum)