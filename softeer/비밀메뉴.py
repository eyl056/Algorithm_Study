import sys
input = sys.stdin.readline

M, N, K = map(int, input().split())
secret = "".join(list(input().strip().split()))
user = "".join(list(input().strip().split()))

if secret in user:
    print("secret")
else:
    print("normal")
