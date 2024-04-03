first, last = input().strip().split()
index = 1
while index != len(first) and first[index] < last[0]:
    index += 1
    
print (first[0: index] + last[0])