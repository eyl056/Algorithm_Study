import sys
input = sys.stdin.readline

# 4 9 25 81
# 2 3 5  9

# 0 1 2  3

N = int(input())

print(pow((pow(2, N) + 1), 2))
