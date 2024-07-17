def min_value(arr):
    minVal = arr[0]
    for val in arr:
        if val < minVal:
            minVal = val
    return minVal

input_array = eval(input())
print(min_value(input_array))
