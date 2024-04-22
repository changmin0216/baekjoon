import sys
input = sys.stdin.readline

n = int(input())
index = set([])

for i in range(n):
    if(i!=0):
        a = temp
    temp = input().rstrip()
    if(i!=0):
        for i in range(len(a)):
            if a[i] != temp[i]:
                index.add(i)
# answer = list(index).sort()

for i in range(len(temp)):
    if i in index:
        print('?', end='')
    else:
        print(temp[i], end='')