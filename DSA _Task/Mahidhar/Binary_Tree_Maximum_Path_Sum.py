def create_node(val):
    return {'val': val, 'left': None, 'right': None}

def max_path_sum(root):
    def helper(node):
        if not node:
            return 0, float('-inf')
        
        left_sum, left_max = helper(node['left'])
        right_sum, right_max = helper(node['right'])
        
        current_sum = node['val'] + max(left_sum, 0) + max(right_sum, 0)
        max_path = node['val'] + max(max(left_sum, right_sum), 0)
        max_sum = max(left_max, right_max, current_sum)
        
        return max_path, max_sum
    
    path_sum, max_sum = helper(root) 
    return max_sum

def tree(values):
    if not values:
        return None
    root = create_node(values[0])
    queue = [root]
    i = 1
    while queue and i < len(values):
        node = queue.pop(0)
        if values[i] is not None:
            node['left'] = create_node(values[i])
            queue.append(node['left'])
        i = i+ 1
        if i < len(values) and values[i] is not None:
            node['right'] = create_node(values[i])
            queue.append(node['right'])
        i = i+1
    return root

input_values = input()
values = eval(input_values)

root = tree(values)
print(max_path_sum(root))
