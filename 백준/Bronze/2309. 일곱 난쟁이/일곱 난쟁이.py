import sys
input = sys.stdin.readline

ary = []

for _ in range(9):
    ary.append(int(input()))

total = sum(ary)
result=[]
for i in range(9):
    for j in range(1, 9):
        if total - ary[i] - ary[j] == 100:
            for k in range(9):
                if k==i or k==j:
                    continue
                else:
                    result.append(ary[k])
            for v in sorted(result):
                print(v)
            exit()
