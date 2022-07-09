import sys

N = int(sys.stdin.readline().strip()) #N: 피연산자 개수를 저장할 변수값

pf = input() #후위표기식
num_list = [] #피연산자 대응값 넣는 리스트
que = [] #pf에서 문자만 넣는 리스트

for i in range(N):
    num = int(sys.stdin.readline().strip()) #num: 피연산자에 대응하는 값 입력
    num_list.append(num)

for j in pf:
    if 'A' <= j <= 'Z': #문자면 que 리스트에 넣기 <- 대응하는 피연산자 값으로 넣기
        #ord 함수로 문자를 정수로 변환해 받기  ==>  j='A'면 num_list[0] 값이 que에 들어감
        que.append(num_list[ord(j) - ord('A')]) 
        #print(que)

    else: #문자가 아닌 연산자면 que 뒤에서부터 값을 2개 pop하여 연산 수행
        #pop은 가장 우측 인덱스부터 빼므로 빼는 순서를 피연산자2부터 빼도록 설정
        #(피연산자1 피연산자2 연산자) <- 3개가 동시에 빠져서 연산 수행
        oper2 = que.pop()
        oper1 = que.pop()
        if j == '+':
            result = oper1 + oper2
        elif j == '-':
            result = oper1 - oper2
        elif j =='*':
            result = oper1 * oper2
        elif j == '/':
            result = oper1 / oper2
        que.append(result)
        #print(result)
        
print("{:.2f}".format(que[0]))
