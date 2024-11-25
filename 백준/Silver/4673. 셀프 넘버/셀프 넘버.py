import sys
input = sys.stdin.readline

check = [False] * 10001

for i in range(10001):

    if i<10:
        check[i*2] = True
    else:
        tmp = i
        for x in str(i):
            tmp+=int(x)

        if tmp<=10000:
            check[tmp] = True

for i in range(10001):
    if not check[i]:
        print(i)