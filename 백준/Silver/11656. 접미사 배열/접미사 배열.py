import sys
input = sys.stdin.readline

s = list(input().rstrip())
answers = []
for i in range(len(s)):
    answers.append(s[i:])

answers.sort()
for answer in answers:
    print(''.join(answer))
