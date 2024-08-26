arr = list(map(int, str(input())))
arr.sort(reverse=True)
for i in arr:
    print(i,end='')