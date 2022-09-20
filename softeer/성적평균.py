import sys

N, K = map(int, sys.stdin.readline().split())
score = list(map(int, sys.stdin.readline().split()))

for i in range(K):
    a, b = map(int, sys.stdin.readline().split())
    avg = sum(score[a - 1:b]) / (b - a + 1)
    print('%.2f'%avg)
