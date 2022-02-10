Case = int(input())
Plus = 0
Total = 0

while True:
    OX_input = str(input())
    OX_list = list(OX_input)
    for i in range(len(OX_list)):
        #OX_list의 i번째 index 값이 O면 줄 점수에 +1, 아니면 0점으로 초기화
        if OX_list[i] == "O":
            Plus += 1
        elif OX_list[i] == "X":
            Plus = 0
        Total += Plus
    print(Total)
    #출력해주고, 연속값 보너스와 합계 0으로 초기화
    Plus = 0
    Total = 0
    Case -= 1
    if Case == 0:
        break
    
