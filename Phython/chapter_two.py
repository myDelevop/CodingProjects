import utilities


# This method take in input an array and reorder so that the even entries
# appears first and then the odd entries later
def even_odd(arr):
    even_index = 0
    odd_index = len(arr)-1
    while even_index < odd_index:
        if array[even_index] % array[odd_index] == 0:
            even_index = even_index + 1
        else:
            utilities.swap_elements(array, even_index, odd_index)
            odd_index = odd_index - 1
    return


cars = ["Ford", "Volvo", "BMW"]
print(utilities.array_to_string(cars))

array = [9, 4, 1, 8, -3, 5]
even_odd(array)
print(utilities.array_to_string(array))

array = [-2, 45, 0, 11, -9]
utilities.bubble_sort(array)
print(utilities.array_to_string(array))
