def score():
    scores = list(map(int, input().split()))
    len_score = len(scores)

    _dict = {}
    for i in range(m):
        data = list(map(str, input().split()))
        # num: 수험번호, arr: 채점결과
        num, arr = data[0], data[1:]

        _dict[num] = _dict.setdefault(num, 0)
        for j in range(len_score):
            # 정답(O)이면, 점수 더 해주기
            if arr[j] == 'O':
                _dict[num] += scores[j]

    # min_student: 수험 번호는 최대 100_000
    min_student = 100001
    # max_val: 가장 높은 점수
    max_val = max(_dict.values())
    for k, v in _dict.items():
        if v == max_val:
            min_student = min(min_student, int(k))

    print(min_student, max_val)


n, m = map(int, input().split())
score()