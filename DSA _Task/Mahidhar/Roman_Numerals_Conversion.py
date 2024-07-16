def convert_roman(s):
    roman_values_set = {'I': 1, 'V': 5, 'X': 10, 'L': 50}
    total = 0
    
    for i in range(len(s)):
        if i > 0 and roman_values_set[s[i]] > roman_values_set[s[i - 1]]:
            total = total + roman_values_set[s[i]] - 2 * roman_values_set[s[i - 1]]
        else:
            total = total + roman_values_set[s[i]]
    
    return total

input_roman = input()
print(convert_roman(input_roman))
