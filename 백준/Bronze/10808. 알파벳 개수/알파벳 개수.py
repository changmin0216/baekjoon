import sys
input = sys.stdin.readline

S = list(input().rstrip())
result = [0]*26

for v in S:
    result[ord(v)-ord('a')]+=1
print(*result)