#!/bin/python

import math
import os
import random
import re
import sys



#
# Complete the 'connectedCities' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER g
#  3. INTEGER_ARRAY originCities
#  4. INTEGER_ARRAY destinationCities
#


#Find root of set
def findRoot(sets, i):
    if sets[i] == i:
        return i
    sets[i:i+1] = [findRoot(sets, sets[i])]
    return sets[i]


def connectedCities(n, g, originCities, destinationCities):

    sets = [i for i in range(n+1)]
    ans = [0]*(len(originCities))


    #Union Connected Cities
    for i in range(g+1, n+1):
        mul = i
        # Union i and i's multiples(mul) less than n.
        while mul <= n :
            root_mul = findRoot(sets, mul)
            root_i = findRoot(sets, i)
            if root_mul != root_i:
                sets[root_mul] = root_i
            mul += i

    #Compare origin's root and destination's root.
    for i in range(len(originCities)):
        ans[i] = 1 if (findRoot(sets, originCities[i]) == findRoot(sets, destinationCities[i])) else 0

    return ans



if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(raw_input().strip())

    g = int(raw_input().strip())

    originCities_count = int(raw_input().strip())

    originCities = []

    for _ in xrange(originCities_count):
        originCities_item = int(raw_input().strip())
        originCities.append(originCities_item)

    destinationCities_count = int(raw_input().strip())

    destinationCities = []

    for _ in xrange(destinationCities_count):
        destinationCities_item = int(raw_input().strip())
        destinationCities.append(destinationCities_item)

    result = connectedCities(n, g, originCities, destinationCities)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
