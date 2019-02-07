#!/bin/python

import math
import os
import random
import re
import sys



#
# Complete the 'createBST' function below.
#
# The function accepts INTEGER_ARRAY keys as parameter.
#



def createBST(keys):
    counter = 0
    bst = []
    idx = -1

    for key in keys:
        current = 0
        idx += 1

        if len(bst) != 0:

            while True:
                counter += 1
                if key < bst[current][0]:
                    if bst[current][1] == -1:
                        bst.append([key,-1,-1])
                        bst[current][1] = len(bst)-1
                        break
                    else:
                        current = bst[current][1]
                else:
                    if bst[current][2] == -1:
                        bst.append([key,-1,-1])
                        bst[current][2] = len(bst)-1
                        break
                    else:
                        current = bst[current][2]
        else:
            bst.append([key, -1, -1])

        print(counter)



if __name__ == '__main__':
    keys_count = int(raw_input().strip())

    keys = []

    for _ in xrange(keys_count):
        keys_item = int(raw_input().strip())
        keys.append(keys_item)


    createBST(keys)
