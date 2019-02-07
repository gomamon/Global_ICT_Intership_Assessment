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
        root = 0
        idx += 1

        if len(bst) != 0:
            # insert(root, key)
            while True:
                counter += 1
                if key < bst[root][0]:
                    if bst[root][1] == -1:
                        bst.append([key,-1,-1])
                        bst[root][1] = len(bst)-1
                        break
                    else:
                        root = bst[root][1]
                else:
                    if bst[root][2] == -1:
                        bst.append([key,-1,-1])
                        bst[root][2] = len(bst)-1
                        break
                    else:
                        root = bst[root][2]
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
