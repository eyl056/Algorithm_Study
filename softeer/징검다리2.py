import sys
import bisect

N = int(sys.stdin.readline())
stone = list(map(int, sys.stdin.readline().split()))

# 밟을 수 있는 돌의 높이 DP 배열
B = [stone[0]] # 원본 중 가장 작은 값(앞에서부터)
C = [stone[-1]] # 원본 중 가장 작은 값(뒤에서부터)
B_c = [1] * N # 앞에서부터 밟은 돌의 개수
C_c = [1] * N # 뒤에서부터 밟은 돌의 개수

# 앞에서부터
for i in range(N):
    # 높이가 더 올라갔으면
    if stone[i] > B[-1]:
        B.append(stone[i])
    # 높이가 더 낮아졌으면
    else:
        # 이분탐색으로 현재 높이보다 더 작은, 가장 큰 높이의 index
        # bisect_left(a, x) : 정렬된 a에 x를 삽입할 위치 리턴
        # bisect_left(a, x) : 그 위치의 오른쪽 위치 리턴
        index = bisect.bisect_left(B, stone[i])
        B[index] = stone[i]

    B_c[i] = len(B)

# 뒤쪽부터인데 편하게 reverse
stone.reverse()

for i in range(N):
    # 높이가 더 올라갔으면
    if stone[i] > C[-1]:
        C.append(stone[i])
    # 높이가 더 낮아졌으면
    else:
        # 이분탐색으로 현재 높이보다 더 낮은, 그 중에서 가장 큰 높이의 index
        index = bisect.bisect_left(C, stone[i])
        C[index] = stone[i]
    
    C_c[N - i - 1] = len(C)

sum = 0
for i in range(N):
    # 양 방향에서 돌을 건널 때, 그 합의 최대인 것
    sum = max(sum, B_c[i] + C_c[i])

# 가장 높은 위치의 돌을 밟았을 때 겹치기 때문에 -1
print(sum - 1)
