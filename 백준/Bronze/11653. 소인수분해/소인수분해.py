import sys
input = sys.stdin.readline

n = int(input())

i=2
result = []
for _ in range(n+1):
    if n%i==0:
        result.append(i)
        n = n//i
    else:
        i+=1

for v in result:
    print(v)