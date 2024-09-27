n, r, c = map(int, input().split())

def find_z_order(n, r, c):
    result = 0
    size = 2 ** n
    while size > 1:
        size //= 2
        if r < size and c < size:  # 1사분면
            pass
        elif r < size and c >= size:  # 2사분면
            result += size * size
            c -= size
        elif r >= size and c < size:  # 3사분면
            result += 2 * size * size
            r -= size
        else:  # 4사분면
            result += 3 * size * size
            r -= size
            c -= size
    print(result)

find_z_order(n, r, c)
