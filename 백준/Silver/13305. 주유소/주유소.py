import sys
input = sys.stdin.readline

n = int(input())

edges = list(map(int, input().split()))
nodes = list(map(int, input().split()))

min_price=nodes[0]
answer=0

for i in range(n-1):
    if min_price>nodes[i]:
        min_price=nodes[i]
    answer += (edges[i]*min_price)

print(answer)