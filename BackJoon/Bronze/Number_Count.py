#세 개의 자연수 A, B, C가 주어지고, A*B*C를 계산한 결과에
#0~9까지 각 숫자가 몇 번 쓰였는지 구하는 프로그램

A = int(input())
B = int(input())
C = int(input())

#셋다 100이상 1000이하 자연수

#첫째줄부터 쭉 0~9가 몇 번 쓰였는지 출력

Sum = A * B * C

#합계를 리스트에 자릿수마다 각각 넣어줌
Str_Sum = list(str(Sum))

#0~9 숫자 당 몇 개 나왔는지 값을 넣어줄 리스트
Number_Result = []

#0~9까지 count함수를 사용해 Str_sum이라는 list안에 s번째 수가 몇 개 있는지 세주고
#append로 카운팅한 값을 리스트에 넣어줌
for s in range(10):
    St = Str_Sum.count(str(s))
    Number_Result.append(St)

#해당 리스트에 적힌 값 출력
for n in range(10):
    print(Number_Result[n])














