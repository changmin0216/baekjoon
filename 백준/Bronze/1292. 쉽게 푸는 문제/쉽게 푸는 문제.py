a,b=map(int,input().split())
data=[0]
sum_=0

for i in range(1,b+1):
  for j in range(i):
    data.append(i)

for i in range(a, b+1):
    sum_+=data[i]
print(sum_)