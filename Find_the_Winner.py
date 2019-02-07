#!/bin/python

import math
import os
import random
import re
import sys



#
# Complete the 'winner' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. INTEGER_ARRAY andrea
#  2. INTEGER_ARRAY maria
#  3. STRING s
#

def winner(andrea, maria, s):

    andrea_score = 0
    maria_score = 0


    if s == "Even" :
        for i in range(0, len(andrea), 2):
            maria_score += (maria[i]-andrea[i])
            andrea_score += (andrea[i]-maria[i])
    else:
        for i in range(1, len(andrea), 2):
            maria_score += (maria[i]-andrea[i])
            andrea_score += (andrea[i]-maria[i])


    if andrea_score - maria_score == 0 :
        return "Tie"
    else:
        if andrea_score - maria_score > 0:
            return "Andrea"
        else:
            return "Maria"



if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    andrea_count = int(raw_input().strip())

    andrea = []

    for _ in xrange(andrea_count):
        andrea_item = int(raw_input().strip())
        andrea.append(andrea_item)

    maria_count = int(raw_input().strip())

    maria = []

    for _ in xrange(maria_count):
        maria_item = int(raw_input().strip())
        maria.append(maria_item)

    s = raw_input()

    result = winner(andrea, maria, s)

    fptr.write(result + '\n')

    fptr.close()
