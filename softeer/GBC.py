import sys
input = sys.stdin.readline

N, M = map(int, input().split())
N_real = [list(map(int, input().split())) for _ in range(N)]
M_gwangwoo = [list(map(int, input().split())) for _ in range(M)]

max_diff = []

while True:
    if len(N_real) == 0 or len(M_gwangwoo) == 0:
        break

    diff_length = M_gwangwoo[0][0] - N_real[0][0] # 구간 길이 차이

    if diff_length > 0:
        max_diff.append(M_gwangwoo[0][1] - N_real[0][1])
        N_real.pop(0)
        M_gwangwoo[0][0] = diff_length
    elif diff_length < 0:
        max_diff.append(M_gwangwoo[0][1] - N_real[0][1])
        M_gwangwoo.pop(0)
        N_real[0][0] = -diff_length
    else:
        max_diff.append(M_gwangwoo[0][1] - N_real[0][1])
        N_real.pop(0)
        M_gwangwoo.pop(0)

if max(max_diff) >= 0:
    print(max(max_diff))
else:
    # 가장 큰 값이 음수 -> 제한 속도를 넘어간 값이 없음
    print(0)
