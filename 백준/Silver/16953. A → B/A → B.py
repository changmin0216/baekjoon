import sys
input = sys.stdin.readline

a, b = map(int, input().split())

def recur(temp, cnt):
    if temp == b:
        print(cnt+1)
        exit()
    if temp > b:
        return
    recur(temp*2, cnt+1)
    recur(temp*10+1, cnt+1)
    return

recur(a, 0)
print(-1)