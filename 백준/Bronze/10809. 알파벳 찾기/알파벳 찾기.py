import sys
input = sys.stdin.readline

S = list(input().rstrip())

result = [-1] * 26
temp = []
for i in range(len(S)):
    if ord(S[i]) - ord('a') not in temp:
        temp.append(ord(S[i]) - ord('a'))
        result[ord(S[i]) - ord('a')] = i
print(*result)
