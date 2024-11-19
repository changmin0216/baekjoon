import sys
input = sys.stdin.readline

xa, ya, xb, yb, xc, yc = map(int, input().split())

if (xa-xb)*(ya-yc) == (ya - yb)*(xa - xc):
    print(-1.0)
    exit(0)

ab = ((xa-xb)**2 + (ya-yb)**2)**0.5
ac = ((xa-xc)**2 + (ya-yc)**2)**0.5
bc = ((xb-xc)**2 + (yb-yc)**2)**0.5

l = [2*(ab+ac), 2*(ab+bc), 2*(ac+bc)]

print(max(l)-min(l))