N = int(input())
Str_N = list(str(N))
Str_N.sort(reverse=True)
#.join 사용시 리스트를 문자열로 붙여줌
print("".join(Str_N))