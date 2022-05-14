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
        s = s + a + ", "
    s = s.removesuffix(", -")
    return s

