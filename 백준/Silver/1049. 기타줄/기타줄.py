import sys
input = sys.stdin.readline

n, m = map(int, input().split())
bundle = []
each = []

for _ in range(m):
    a, b = map(int, input().split())
    bundle.append(a)
    each.append(b)

min_bundle = min(bundle)
min_each = min(each)

ans = 0
while n > 0:
    if n >= 6:
        min_single = min_each*6
        n -= 6
    else:
        min_single = min_each*n
        n -= n
    if min_single < min_bundle:
        ans += min_single
    else:
        ans += min_bundle

print(ans)