def find_max_profit(start, end, profit):
    n = len(start)
    jobs = []
    for i in range(n):
        jobs.append((start[i], end[i], profit[i]))
    
    for i in range(n):
        for j in range(i + 1, n):
            if jobs[i][1] > jobs[j][1]:
                jobs[i], jobs[j] = jobs[j], jobs[i]
    
    dp = [0] * n

    def find_lnc(jobs, index):
        for i in range(index - 1, -1, -1):
            if jobs[i][1] <= jobs[index][0]:
                return i
        return -1

    dp[0] = jobs[0][2]

    for i in range(1, n):
        with_profit = jobs[i][2]
        lnc = find_lnc(jobs, i)
        if lnc != -1:
            with_profit += dp[lnc]
        
        without_profit = dp[i - 1]
        dp[i] = max(with_profit, without_profit)

    return dp[-1]

def parse_input_array(input_string):
    input_string = input_string.strip("[]")
    input_list = []
    num = ''
    for char in input_string:
        if char.isdigit() or char == '-':
            num += char
        elif char == ',' and num:
            input_list.append(int(num))
            num = ''
    if num:
        input_list.append(int(num))
    return input_list

start = parse_input_array(input())
end = parse_input_array(input())
profit = parse_input_array(input())

max_profit = find_max_profit(start, end, profit)
print(f"{max_profit}")