import sys
input = sys.stdin.readline
import heapq

N = int(input())
time = []
for _ in range(N):
    startTime, endTime = map(int, input().split())
    heapq.heappush(time, (endTime, startTime))

count = 0
endT = 0
while time:
    endTime, startTime = heapq.heappop(time)
    if startTime >= endT:
        count += 1
        endT = endTime

print(count)
