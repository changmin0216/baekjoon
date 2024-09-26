import sys
input = sys.stdin.readline

cal = input().rstrip().split('-')

_minus = []
for i in cal:
    sum=0
    t = i.split('+')

    for j in t:
        sum+=int(j)
    _minus.append(sum)

result = _minus[0]
for i in range(1, len(_minus)):
    result-=_minus[i]

print(result)