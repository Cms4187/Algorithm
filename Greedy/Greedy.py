#동전 거스름돈 - Greedy
n = 1260
count = 0
coin_types = [500, 100, 50, 10]

for coin in coin_types:
    count += n // coin # //로 몫구함
    n %= coin

print(count)

#큰 화폐부터 차례로 확인하여
#count += n // coin 에서 // 연산자로 몫을 구하고 (몫 = 동전 갯수)
#총 잔액 n에서 coin(동전 값)을 뺌
#출력값은 총 동전 갯수 500원 2개, 100원 2개, 50원 1개, 10원 1개로 6 출력

#시간 복잡도는 동전의 종류가 A일 때, O(A) 시간만큼 소요
#금액에 무관하게 금액이 큰 동전부터 나눈다.

