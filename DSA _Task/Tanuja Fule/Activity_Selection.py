def select_activities(activities):
    activities.sort(key=lambda x: x[1])
    selected_activities = [activities[0]]
    last_selected = 0

    for i in range(1, len(activities)):
        if activities[i][0] >= activities[last_selected][1]:
            selected_activities.append(activities[i])
            last_selected = i

    return selected_activities

activities = [(1, 2), (3, 4), (6, 7), (5, 7), (8, 9), (5, 9)]
selected_activities = select_activities(activities)

print("Selected Activities:", selected_activities)
