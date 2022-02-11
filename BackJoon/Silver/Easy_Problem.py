A, B = map(int, input().split())
total = []

#숫자가 1 2 2 3 3 3 4 4 4 4 처럼 해당 숫자 C가 C번씩 나열되는 수열이 있고,
#구간 A, B가 입력되면 구간 A ~ B 사이의 합을 구하는 문제

#B까지만 반복
for i in range(B+1):
    for j in range(i):
        #total에 들어간 변수의 갯수와 마지막 구간의 값이 같으면 넣지 않고 끝내기
        if len(total) == B:
            break
        total.append(i)
    
print(sum(total[A-1:B]))
    
