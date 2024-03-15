import sys
input = sys.stdin.readline

s = list(input().rstrip())

for i in range(len(s)):
    if s[i].isalpha():
        if s[i].islower(): #소문자면
            if ord(s[i]) + 13 > ord('z'):
                s[i] = chr(ord(s[i])+13-ord('z') + ord('a') - 1)
            else:
                s[i] = chr(ord(s[i])+13)
        else:
            if ord(s[i]) + 13 > ord('Z'):
                s[i] = chr(ord(s[i])+13-ord('Z') + ord('A') - 1)

            else:
                s[i] = chr(ord(s[i])+13)

print(''.join(s))
