import sys
import bisect

N = int(sys.stdin.readline())
stone = list(map(int, sys.stdin.readline().split()))

A = [stone[0]] # 앞에서부터 밟는 돌의 높이
A_c = [1] * N # 돌을 밟을 수 있는 개수

for i in range(N):
    if stone[i] > A[-1]: # 높이가 더 높아진다면
        A.append(stone[i])
    else:
        # 이분탐색으로 현재 높이보다 더 작은 높이 중 가장 큰 높이의 index(앞으로)(왜냐면 대체하는 값인거니까)
        index = bisect.bisect_left(A, stone[i])
        # bisect_left(a, x) : 정렬된 a에 x를 삽입할 위치 리턴
        A[index] = stone[i]

    # 더 높아지면 추가되고, 더 낮아지면 대체
    A_c[i] = len(A)

print(max(A_c))
