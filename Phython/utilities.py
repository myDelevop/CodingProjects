def swap_elements(array, i, j):
    if len(array) <= 1:
        print("No operation performed in the array because the length is <= 1")
        return

    if i < 0 or j < 0:
        print("No operation performed in the array because at least one index is negative")
        return

    if i >= len(array) or j >= len(array):
        print("No operation performed in the array because at least one index exceed the length of the array")
        return

    temp = array[i]
    array[i] = array[j]
    array[j] = temp

    return


def array_to_string(array):
    s = "Array: "
    for a in array:
        s = s + str(a) + ", "
    s = s.removesuffix(", -")
    return s


def bubble_sort(array):
    for i in range(0, len(array)):
        for j in range (0, len(array)-i-1):
            if array[j]>array[j+1]:
                swap_elements(array, j, j+1)
    return
