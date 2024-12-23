from sys import stdin

input = stdin.readline

def cantor(n):
    if n == 1:
        return "-"

    cantor_unit = cantor(n // 3)
    cantor_res = cantor_unit + " " * (n // 3) + cantor_unit

    return cantor_res


while True:
    try:
        N = int(input())
        print(cantor(3**N))
    except:
        break