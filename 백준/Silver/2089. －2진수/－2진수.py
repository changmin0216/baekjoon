import sys
input = sys.stdin.readline

n = int(input())
if n==0:
    print(0)
result = ''
while n:
    if n%2:
        result += '1'
        n = n//-2 +1
    else:
        result += '0'
        n = n//-2

print(''.join(reversed(result)))