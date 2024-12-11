import sys
input = sys.stdin.readline

n = int(input())

size = [0]*9

for i in str(n):
    if i!='6' and i!='9':
        size[int(i)]+=1
    else:
        size[6]+=1

if size[6]%2==0: ## 짝수면
    size[6] = size[6]//2
else: ## 홀수면
    size[6] = size[6]//2 +1

print(max(size))