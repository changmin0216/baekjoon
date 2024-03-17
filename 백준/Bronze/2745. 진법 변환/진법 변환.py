import sys
input = sys.stdin.readline

n, b = map(str, input().split())

result = []
b = int(b)
cnt=1
for i in range(len(n)-1, -1, -1):
    if ord('0') <= ord(n[i]) <= ord('9'): ##0~9
        result.append(int(n[i])*cnt)
    else:
        result.append((ord(n[i]) - 55) * cnt)
    cnt*=b

print(sum(result))