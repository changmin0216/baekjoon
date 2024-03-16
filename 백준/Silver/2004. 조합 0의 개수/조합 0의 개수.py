import sys
input = sys.stdin.readline

n, m = map(int, input().split())  # 25, 12

def count_two(x):
    if x<2:
        return 0
    cnt=0
    while x > 0:
        x = x // 2
        cnt+=x
    return(cnt)

def count_five(x):
    if x<5:
        return 0
    cnt=0
    while x > 0:
        x = x // 5
        cnt+=x
    return(cnt)

two = count_two(n) - (count_two(m) + count_two(n-m))
five = count_five(n) - (count_five(m) + count_five(n-m))

print(min(two, five))

