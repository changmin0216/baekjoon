import sys
input = sys.stdin.readline

n, m = map(int, input().split())
true_list = set(input().split()[1:])

party = []

for _ in range(m):
    party.append(set(input().split()[1:]))

for _ in range(m):
    for p in party:
        if p & true_list:
            true_list = true_list.union(p)

cnt = 0
for p in party:
    if p & true_list:
        continue
    cnt += 1

print(cnt)