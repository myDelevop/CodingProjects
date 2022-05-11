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
		x &= x-1 # Drops the lowest set bit of x
	return result


def parity_two(x):
	x ^= x >> 32
	x ^= x >> 16
	x ^= x >> 8
	x ^= x >> 4
	x ^= x >> 2
	x ^= x >> 1
	return x & 0x1

print(count_bits(2))


print(parity_brute_force(36))
print(parity_one(36))
print(parity_two(36))