ary = []
for i in range(5):
    ary.append(int(input()))
ary.sort()
print(int(sum(ary)/5))
print(ary[2])