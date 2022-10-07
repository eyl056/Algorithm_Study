import sys
input = sys.stdin.readline
from collections import deque

answer = []
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

N = int(input())
graph = [input().strip() for _ in range(N)]
visited = [[False] * N for _ in range(N)]

def bfs(x, y):
    count = 1
    q = deque()
    q.append((x, y))
    visited[x][y] = True

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if -1 < nx < N and -1 < ny < N:
                if not visited[nx][ny] and graph[nx][ny] == '1':
                    q.append((nx, ny))
                    visited[nx][ny] = True
                    count += 1
    answer.append(count)

# 지도에서 확인
for i in range(N):
    for j in range(N):
        if not visited[i][j] and graph[i][j] == '1':
            bfs(i, j)

print(len(answer))
print('\n'.join(map(str,sorted(answer))))
