from collections import Counter
def solution(points, routes):
    def routing(route):
        # 경로를 저장할 path, 시간을 기록할 time
        path = []
        time = 0

        for i in range(len(route) - 1):
            # 시작점 sx, sy, 도착점 ex, ey
            sx, sy = points[route[i] - 1]
            ex, ey = points[route[i + 1] - 1]

            while sx != ex:
                path.append((sx, sy, time))
                if sx > ex:
                    sx -= 1
                else:
                    sx += 1
                time += 1

            while sy != ey:
                path.append((sx, sy, time))
                if sy > ey:
                    sy -= 1
                else:
                    sy += 1
                time += 1

        path.append((sx, sy, time))
        return path

    robot_routes = []
    for route in routes:
        robot_routes.extend(routing(route))

    answer = 0
    counter = Counter(robot_routes)
    for v in counter.values():
        if v >= 2:
            answer += 1

    return answer