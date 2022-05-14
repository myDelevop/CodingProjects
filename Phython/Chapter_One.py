import random

from Rectangle import Rectangle

"""
This method, counts the number of bits to one in the binary 
representation of a decimal number. 
"""


def count_bits(x):
    num_bits = 0
    while x:
        num_bits += x & 1
        x >>= 1
    return num_bits;


"""
Count parity bit of a word. 1 if ones are odd 0 otherwise (brute force solution) 
"""


def parity_brute_force(x):
    result = 0
    while x:
        result ^= x & 1
        x >>= 1
    return result


"""
Count parity bit of a word. 1 if ones are odd 0 otherwise (more efficient solution) 
"""


def parity_one(x):
    result = 0
    while x:
        result ^= 1
        x &= x - 1  # Drops the lowest set bit of x
    return result


def parity_two(x):
    x ^= x >> 32
    x ^= x >> 16
    x ^= x >> 8
    x ^= x >> 4
    x ^= x >> 2
    x ^= x >> 1
    return x & 0x1


def uniform_random(lower_bound, upper_bound):
    number_of_outcomes = upper_bound - lower_bound + 1
    result = 0
    first_run = True

    while first_run or result >= (number_of_outcomes + 1):
        first_run = False
        result = 0

        i = 0
        while (1 << i) < number_of_outcomes:
            result = (result << 1) | zero_one_random()
            i = i + 1

    return result + lower_bound;


def zero_one_random():
    return random.randint(0, 1)


# MAIN SECTION:


print(count_bits(2))
print(parity_brute_force(36))
print(parity_one(36))
print(parity_two(36))
print(uniform_random(2, 5))


A = Rectangle(2, 1, 2, 2)
B = Rectangle(3, 2, 3, 2)
C = Rectangle(5, 0, 1, 3)

print(Rectangle.intersect_rectangle(A, B))
print(Rectangle.intersect_rectangle(B, C))
print(Rectangle.intersect_rectangle(A, C))
