#입력받을 갯수, 갯수 만큼 입력받을 값을 넣는 빈 리스트 생성
N = int(input())
Num_list = []

#N개의 정수를 하나씩 입력받아 리스트안에 추가
for i in range(N):
    Num_list.append(int(input()))

#sort 함수를 사용해 오름차순 정렬
#sort(reverse=True) 하면 내림차순으로 정렬됨
Num_list.sort()

#출력
for i in range(N):
    print(Num_list[i])


