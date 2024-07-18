def common_elements(arrays):
    if not arrays:
        return []

    # Start with the set of the first array
    common_set = set(arrays[0])

    # Intersect with sets of the subsequent arrays
    for array in arrays[1:]:
        common_set.intersection_update(array)

    return list(common_set)

# Example usage
arrays = [
    [1, 2, 3, 4],
    [2, 3, 5],
    [3, 4, 2]
]

result = common_elements(arrays)
print(f"Common elements: {result}")
