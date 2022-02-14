N = int(input())
Info = []

for _ in range(N):
    Age, Name = map(str, input().split())
    Info.append(Age, Name)

print(Info)

