n = int(input())
sol = [0] * n
if n == 1:
    print(1%10007)
else:
    sol[0] = 1
    sol[1] = 2
    for i in range(2, n):
        sol[i] = sol[i-1] + sol[i-2]

    print(sol[n-1]%10007)
