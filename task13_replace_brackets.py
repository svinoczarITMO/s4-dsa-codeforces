from sys import stdin
from collections import deque
lst = deque(stdin.readline().strip())
opened = "([<{"
closed = ")]>}"
stack = []
change = 0
for i in lst:
    stack.append(i)
    if len(stack) >=2:
        if i in closed and stack[-2] in opened:
            if closed.index(i) != opened.index(stack[-2]):
                change +=1
            del stack[-2:]
        elif i in closed and stack[-2] in closed:
            change = "Impossible"
            break
if len(stack) != 0:
    change = "Impossible"
print(change)