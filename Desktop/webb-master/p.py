import time
import random


def Select(S, i, column_size=5):
    n = len(S)
    if n <= 140:
        return sorted(S)[i-1]

    groups = [sorted(S[column_size*i:column_size*i+column_size])
              for i in range(n // column_size)]
    if (n % column_size != 0):
        groups.append(sorted(S[n//column_size*column_size:]))
    medians = sorted([g[len(g)//2] for g in groups])
    x = Select(medians, len(medians) // 2, column_size)

    B = [y for y in S if y < x]
    k = len(B) + 1
    C = [y for y in S if y > x]
    if k == i:
        return x
    elif k > i:
        return Select(B, i)
    else:
        return Select(C, i-k)


if __name__ == "__main__":
    size = 10000
    for k in range(3):
        S = random.sample(range(1,10000000), size)
        d = list()
        for i in range(3,11):
            start = time.time()
            Select(S, size // 2, i)
            end = time.time()
            d.append([i, end-start])
        d.sort(key=lambda x: x[1])
        print("select S of size: ", size)
        for element in d:
            print(element)
        size *= 10
        print()
