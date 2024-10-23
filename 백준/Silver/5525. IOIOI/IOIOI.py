import sys
input = sys.stdin.readline

n = int(input())  # Pn의 반복 횟수
m = int(input())  # 문자열의 길이
s = input().rstrip()  # 입력 문자열

cnt = 0  # Pn 패턴의 개수를 저장
pattern_count = 0  # 연속된 'IOI' 패턴의 개수
i = 0  # 탐색 인덱스

# 문자열 전체를 한 번 순회
while i < m - 1:
    if s[i:i + 3] == 'IOI':  # 'IOI' 패턴을 찾으면
        pattern_count += 1  # 패턴 길이를 증가
        if pattern_count >= n:
            cnt += 1  # Pn 패턴 발견
        i += 2  # 'IO'를 건너뛰고 다음 'I'에서 시작
    else:
        pattern_count = 0  # 패턴이 끊기면 초기화
        i += 1  # 다음 문자로 이동

print(cnt)
