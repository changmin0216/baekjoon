n, k = map(int, input().split())
check = [1] * (n+1)
cnt = 0
for i in range(2, n+1):
    if check[i] == 1:
        for j in range(i, n+1, i):
            if check[j] == 1:
                check[j] = 0
                cnt += 1
                if(cnt==k):
                    print(j)