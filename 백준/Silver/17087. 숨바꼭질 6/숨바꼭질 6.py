import sys
input = sys.stdin.readline

def gcd(a, b):
    while b > 0:
        a, b = b, a%b
    return a

n, s = map(int, input().split())
ary = list(map(int, input().split()))

distance = []

for v in ary:
    distance.append(abs(s-v))

if len(distance) == 1:
    print(distance[0])
else:
    temp = distance[0]
    for i in range(1, len(distance)):
        temp = gcd(temp, distance[i])
    print(temp)
