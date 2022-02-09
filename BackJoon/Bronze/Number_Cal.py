n = int(input())

#파이썬 3.6부터 사용 가능한 f-string 기능 사용

#숫자를 지정해서하면 소수 출력 후 지정 숫자 값까지 0으로 출력
print(f'{2**(-n):.250f}')

#지정하지않고 .값 으로 하면 해당 값 출력이 끝나는 지점까지만 출력
print(f'{2**(-n):.{n}f}')

result= "%.250f"% (2**(-n))
last=len(result) #result의 길이 저장
for i in range(last-1, 1, -1): #마지막부터 앞까지 오름차순으로 출력
    if result[i]!='0':
        last=i
        break
print(result[:last+1]) #맨 앞부터 마지막까지만 출력되게 슬라이싱