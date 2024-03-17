import sys
input = sys.stdin.readline

n, b = map(int, input().split())

result = []
while n!=0:
    remain = n%b
    if remain > 9:
        result.append(chr(remain + 55))
    else:
        result.append(str(remain))
    n = n // b
print(''.join(reversed(result)))