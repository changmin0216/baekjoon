n=int(input())
l=[]
for i in range(n):
    a, b = map(int, input().split())
    l.append([a, b])
l.sort()
for i in l:
    print(i[0], i[1])