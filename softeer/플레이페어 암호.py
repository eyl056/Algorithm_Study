import sys
input = sys.stdin.readline

message = input().strip()
key = input().strip()

graph = [[0 for _ in range(5)] for _ in range(5)]
used_k = {}

for k in key:
    if k not in used_k:
        graph[len(used_k) // 5][len(used_k) % 5] = k
        used_k[k] = len(used_k)

for i in range(26):
    c = chr(ord('A') + i)
    if c == 'J': continue
    if c not in used_k:
        graph[len(used_k) // 5][len(used_k) % 5] = c
        used_k[c] = len(used_k)

split_message = []
i = 0

while i < len(message):
    if i == len(message) - 1: # 마지막 글자일 때 X 붙이기
        split_message.append(f'{message[i]}X')
        break
    elif message[i] != message[i + 1]: # 두글자씩 나누기
        split_message.append(message[i:i+2])
        i += 2
    elif message[i] == message[i + 1]: # 같을 때 X 붙임
        if message[i] != 'X':
            split_message.append(f'{message[i]}X')
            i += 1
        else:
            split_message.append(f'{message[i]}Q')
            i += 1

answer = ""
for x1, x2 in split_message:
    x1_loc = used_k[x1]
    x2_loc = used_k[x2]
    if x1_loc // 5 == x2_loc // 5: # 같은 행에 존재할 때
        m1 = (x1_loc + 1) % 5 # 열을 한 칸 이동
        m2 = (x2_loc + 1) % 5 # 열을 한 칸 이동
        x1_m = graph[x1_loc // 5][m1]
        x2_m = graph[x2_loc // 5][m2]
    elif x1_loc % 5 == x2_loc % 5: # 같은 열에 존재할 때
        m1 = (x1_loc // 5 + 1) if (x1_loc // 5) < 4 else 0 # 행을 한 칸 이동
        m2 = (x2_loc // 5 + 1) if (x2_loc // 5) < 4 else 0 # 행을 한 칸 이동
        x1_m = graph[m1][x1_loc % 5] 
        x2_m = graph[m2][x2_loc % 5] 
    else:
        x1_m = graph[x1_loc // 5][x2_loc % 5] # 열이 교환된 위치
        x2_m = graph[x2_loc // 5][x1_loc % 5] # 열이 교환된 위치
    
    answer += str(x1_m + x2_m)

print(answer)
