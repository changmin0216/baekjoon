import sys
input = sys.stdin.readline

n, m = map(int, input().split())

brand = []
for _ in range(m):
    brand.append(list(map(int, input().split())))

bundle = sorted(brand, key=lambda x: x[0])
each = sorted(brand, key=lambda x: x[1])

if bundle[0][0] <= each[0][1]*6:
    answer = bundle[0][0] * (n//6) + each[0][1] * (n%6)

    if bundle[0][0] < each[0][1] * (n%6):
        answer = bundle[0][0] * (n//6 + 1)
else:
    answer = each[0][1] * n
print(answer)