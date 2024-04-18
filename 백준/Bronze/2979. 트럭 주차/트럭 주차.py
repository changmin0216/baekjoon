import sys
input = sys.stdin.readline

money = list(map(int, input().split()))
money.insert(0, 0)

time = []
max = 0
for i in range(3):
    st, end = list(map(int, input().split()))
    if max<end:
        max = end
    time.append([st, end])

t = [0]*max
for i in range(3):
    for j in range(time[i][0], time[i][1]):
        t[j]+=1
sum = 0
for i in range(max):
    sum+=(money[t[i]]*t[i])
print(sum)