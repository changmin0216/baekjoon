import sys
input = sys.stdin.readline

n = int(input())

if n==1:
    print(int(input())**2)
    exit(0)

ary = list(map(int, input().split()))
ary.sort()
print(ary[0]*ary[-1])
