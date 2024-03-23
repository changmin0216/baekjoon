import sys
input = sys.stdin.readline

n, m = map(int, input().split())
maps = []
for _ in range(n):
    maps.append(list(map(int, input().split())))

result = 0
for i in range(n):
    for j in range(m):

        if j+3<m: # 파랑이
            temp = maps[i][j] + maps[i][j+1] + maps[i][j+2] + maps[i][j+3]
            result = max(result, temp)


        if i+3<n: #파랑이
            temp = maps[i][j] + maps[i+1][j] + maps[i+2][j] + maps[i+3][j]
            result = max(result, temp)

        if j+1<m and i+1<n: # 2x2
            temp = maps[i][j] + maps[i+1][j] + maps[i][j+1] + maps[i+1][j+1]
            result = max(result, temp)


        if i+2<n and j+1<m: #주황색, 초록색
            temp1_1 = maps[i][j] + maps[i+1][j] + maps[i+2][j] + maps[i+2][j+1]
            temp1_2 = maps[i+2][j] + maps[i][j+1] + maps[i+1][j+1] + maps[i+2][j+1]

            temp1_3 = maps[i][j] + maps[i+1][j] + maps[i+2][j] + maps[i][j+1]
            temp1_4 = maps[i][j] + maps[i][j+1] + maps[i+1][j+1] + maps[i+2][j+1]

            temp2_1 = maps[i][j] + maps[i+1][j] + maps[i+1][j+1] + maps[i+2][j+1]
            temp2_2 = maps[i][j+1] + maps[i+1][j] + maps[i+1][j+1] + maps[i+2][j]

            temp_3 = maps[i][j] + maps[i + 1][j] + maps[i + 2][j] + maps[i + 1][j + 1]
            temp_4 = maps[i + 1][j] + maps[i][j + 1] + maps[i + 1][j + 1] + maps[i + 2][j + 1]

            result = max(result, temp1_1, temp1_2, temp1_3, temp1_4, temp2_1, temp2_2, temp_3, temp_4)

        if i+1<n and j+2<m:
            temp1_5 = maps[i][j] + maps[i][j+1] + maps[i][j+2] + maps[i+1][j]
            temp1_6 = maps[i][j] + maps[i][j+1] + maps[i][j+2] + maps[i+1][j+2]

            temp1_7 = maps[i][j] + maps[i+1][j] + maps[i+1][j+1] + maps[i+1][j+2]
            temp1_8 = maps[i][j+2] + maps[i+1][j] + maps[i+1][j+1] + maps[i+1][j+2]

            temp2_3 = maps[i][j] + maps[i][j+1] + maps[i+1][j+1] + maps[i+1][j+2]
            temp2_4 = maps[i+1][j] + maps[i][j+1] + maps[i+1][j+1] + maps[i][j+2]

            temp_1 = maps[i][j] + maps[i][j + 1] + maps[i][j + 2] + maps[i + 1][j + 1]
            temp_2 = maps[i][j + 1] + maps[i + 1][j] + maps[i+1][j + 1] + maps[i + 1][j + 2]

            result = max(result, temp1_5, temp1_6, temp1_7, temp1_8, temp2_3, temp2_4, temp_1, temp_2)


        # if i+1<n and j+2<m:
        #     temp_1 = maps[i][j] + maps[i][j+1] + maps[i][j+2] + maps[i+1][j+1]
        #     temp_2 = maps[i][j+1] + maps[i+1][j] + maps[i][j+1] + maps[i+1][j+2]
        #
        #     result = max(result, temp_1, temp_2)

        # if i+2<n and j+1<m:
        #     temp_3 = maps[i][j] + maps[i+1][j] + maps[i+2][j] + maps[i+1][j+1]
        #     temp_4 = maps[i+1][j] + maps[i][j+1] + maps[i+1][j+1] + maps[i+2][j+1]
        #
        #     result = max(result, temp_3, temp_4)

print(result)