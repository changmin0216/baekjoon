import sys
input = sys.stdin.readline

N = input().rstrip()

len_ = len(N)

left = 0
right = 0

for i in range(len_):
    if i<len_//2:
        left+=int(N[i])
    else:
        right+=int(N[i])

if left == right:
    print('LUCKY')
else:
    print('READY')