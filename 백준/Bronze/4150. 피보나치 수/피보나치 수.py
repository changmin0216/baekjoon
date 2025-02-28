n = int(input())

dataa = [0, 1, 1]
for i in range(3, n + 1):
  dataa.append(dataa[i-1] + dataa[i-2])

print(dataa[n])