# 경로 압축 기법(path compression) 시간 복잡도 개선
# find 함수를 재귀적으로 호출한 뒤에 부모 테이블값 갱신
# find 함수를 호출한 뒤에 해당 노드의 루트 노드가 바로 부모 노드가 됨
def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]
