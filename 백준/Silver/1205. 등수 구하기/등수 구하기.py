import sys
input = sys.stdin.readline

n, score, p = map(int, input().split())

if n == 0:
  print(1)
else:
  score_list = list(map(int, input().split()))

  if n == p and score_list[-1] >= score: ##현재 점수 리스트가 꽉 찼고, 제일 큰 값이 내가 새로 넣는 값보다 크거나 같으면
    print(-1)
  else:
    for i in range(n):
      if score_list[i] <= score:
        result = i+1
        break
    else:
        result = n+1
    print(result)
