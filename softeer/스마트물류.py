import sys
input = sys.stdin.readline

N, K = map(int, input().split())
PH = list(input().strip())
count = 0

for i in range(N):
    if PH[i] == "P":
        for j in range(-K + i, K + i + 1):
            # 리스트 범위 처리
            if j < 0 or j > N - 1:
                continue

            elif PH[j] == "H":
                PH[j] = None
                count += 1
                break

print(count)
