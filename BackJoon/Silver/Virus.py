#실버3. 바이러스
#https://www.acmicpc.net/problem/2606 설명은 링크 참고
#DFS로 풀었음, 다시 공부해보기

com_num = int(input()) #컴퓨터 수
com_linenumber = int(input()) #연결되는 컴퓨터 라인 수
virus_count = 0

#컴퓨터 수만큼 연결 쌍이 입력되지 않은 link 리스트 빈칸 만듬
#변수가 사용되지 않으므로 i나 j등이 아닌 _로 넣음
link = [[] for _ in range(com_num+1)]

#라인 수만큼 반복해 link 리스트안에 넣음
for _ in range(com_linenumber):
    First, Second = map(int, input().split())
    link[First].append(Second)
    link[Second].append(First)

#연결 쌍 정보를 넣을 컴퓨터 수만큼, 0으로 초기화 한 빈 칸이 있는 리스트 만들기
connect = [0]*(com_num+1)

def algorithm(visit):
    global virus_count
    connect[visit] = 1
    #
    for i in link[visit]:
        if connect[i] == 0:
            algorithm(i)
            virus_count += 1
    
#예제에서 1번 컴퓨터에서 시작이므로 1을 넣어줌
algorithm(1)
print(link)
print(virus_count)