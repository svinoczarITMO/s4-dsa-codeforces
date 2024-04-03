num_tests = int(input())
for _ in range(num_tests):
    input()
    num_segments, num_weights = map(int, input().split())
    weights = []
    for i in range(num_weights):
        position, weight = map(int, input().split())
        weights.append((weight, position, i+1))
    weights.sort()
    selected_weights = []
    total_cost = 0
    for i in range(2*num_segments):
        weight, position, index = weights[i]
        selected_weights.append((position, index))
        total_cost += weight
    print(total_cost)
    selected_weights.sort()
    for i in range(num_segments):
        left_index, right_index = selected_weights[i][1], selected_weights[2*num_segments-i-1][1]
        print(f"{left_index} {right_index}")
    print()
