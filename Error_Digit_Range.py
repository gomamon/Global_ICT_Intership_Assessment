#!/bin/python

import math
import os
import random
import re
import sys



#
# Complete the 'findRange' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts INTEGER num as parameter.
#

def findRange(num):

    n = str(num)

    #get maximum value

    max_num = n
    target_max = 9
    for target_max in n:
        if target_max != '9':
            break
    max_num = max_num.replace(target_max, '9')


    #get minimum value
    min_num = n
    target_min = 0

    if n[0] == '1' and len(n) > 1:
        flag = False
        for target_min in n:
            if target_min != '0' and target_min != '1':
                flag = True
                break
        if flag:
            min_num = min_num.replace(target_min, '0')

    else:
        target_min = n[0]
        min_num = min_num.replace(target_min, '1')



    return int(max_num)-int(min_num)




if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    num = int(raw_input().strip())

    result = findRange(num)

    fptr.write(str(result) + '\n')

    fptr.close()
