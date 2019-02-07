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

def connectedCities(n, g, originCities, destinationCities):
    # Write your code here

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
