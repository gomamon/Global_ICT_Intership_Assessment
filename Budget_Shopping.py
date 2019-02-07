#!/bin/python

import math
import os
import random
import re
import sys



#
# Complete the 'budgetShopping' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER_ARRAY bundleQuantities
#  3. INTEGER_ARRAY bundleCosts
#

def budgetShopping(n, bundleQuantities, bundleCosts):

    m = len(bundleQuantities)
    max_q = [0]*(n+1)

    for i in range(n+1):
        for j in range(m):
            if i == 0:
                max_q[i] = 0
            elif i < bundleCosts[j]:
                max_q[i] = max(max_q[i-1], max_q[i])
            else:
                max_q[i] = max(max_q[i-1], bundleQuantities[j]+max_q[i-bundleCosts[j]], max_q[i])

    return max_q[n]


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(raw_input().strip())

    bundleQuantities_count = int(raw_input().strip())

    bundleQuantities = []

    for _ in xrange(bundleQuantities_count):
        bundleQuantities_item = int(raw_input().strip())
        bundleQuantities.append(bundleQuantities_item)

    bundleCosts_count = int(raw_input().strip())

    bundleCosts = []

    for _ in xrange(bundleCosts_count):
        bundleCosts_item = int(raw_input().strip())
        bundleCosts.append(bundleCosts_item)

    result = budgetShopping(n, bundleQuantities, bundleCosts)

    fptr.write(str(result) + '\n')

    fptr.close()
