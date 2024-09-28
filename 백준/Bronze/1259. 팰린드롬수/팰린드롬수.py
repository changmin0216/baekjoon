import sys
input = sys.stdin.readline

while True:
    n = list(map(str, input().rstrip()))
    if len(n)==1 and n[0]=='0':
        exit(0)
    if n==n[::-1]:
        print("yes")
    else:
        print("no")