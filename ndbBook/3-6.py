import sys
input = sys.stdin.readline

# n, k를 공백으로 구분하여 입력받
n, k = map(int, input().split())
result = 0 # 수행 횟수

while True:
    # (n == k로 나누어떨어지는 수)가 될 때까지 1씩 빼기
    target = (n // k) * k
    result += (n - target)
    n = target
    # n이 k보다 작을 때(더 이상 나눌 수 없을 떄) 반복문 탈출
    if n < k:
        break
    # k로 나누기
    result += 1
    n //= k

# 마지막으로 남은 수에 대하여 1씩 빼기
result += (n - 1)

print(result) # 수행 횟수 출력
