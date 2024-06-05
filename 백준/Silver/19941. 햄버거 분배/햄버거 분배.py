import sys
input = sys.stdin.readline

n, k = map(int, input().split())

table = list(input().rstrip())

result = 0
for i in range(n):
    if table[i] == 'P':
        for idx in range(max(0, i-k), min(n, i+k+1)):
            if table[idx] == 'H':
                table[idx] = 'X'
                result+=1
                break
print(result)