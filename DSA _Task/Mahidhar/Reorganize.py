def reorganize_string(s):
    freqs = {}
    for char in s:
        if char in freqs:
            freqs[char] += 1
        else:
            freqs[char] = 1
    
    freq_list = []
    for char, freq in freqs.items():
        freq_list.append((freq, char))
    
    for i in range(len(freq_list)):
        for j in range(i + 1, len(freq_list)):
            if freq_list[i][0] < freq_list[j][0]:
                freq_list[i], freq_list[j] = freq_list[j], freq_list[i]
    
    result = [''] * len(s)
    index = 0
    
    for freq, char in freq_list:
        for _ in range(freq):
            if index >= len(s):
                index = 1
            result[index] = char
            index = index + 2
    
    new_string = ''.join(result)
    
    for i in range(1, len(new_string)):
        if new_string[i] == new_string[i - 1]:
            return ""
    
    return new_string

s = input()
output = reorganize_string(s)
print(output if output else "Not possible to rearrange")
