# Everyone has to create folder for each dsa question inside this DSA TASK folder
def get_combinations(digits):
    if not digits:
        return []
    
    # Mapping of digits to corresponding letters
    digit_to_letters = {
        '2': 'abc',
        '3': 'def',
        '4': 'ghi',
        '5': 'jkl',
        '6': 'mno',
        '7': 'pqrs',
        '8': 'tuv',
        '9': 'wxyz'
    }
    
    # A function to backtrack and generate combinations
    def backtrack(index, path):
        if index == len(digits):
            combinations.append("".join(path))
            return
        
        current_digit = digits[index]
        for letter in digit_to_letters.get(current_digit, ""):
            path.append(letter)  # Add the letter to the current path
            backtrack(index + 1, path)  # Move to the next digit
            path.pop()  # Backtrack
    
    combinations = []
    backtrack(0, [])
    return combinations

# Example usage
phone_number = "23"
print(get_combinations(phone_number))
