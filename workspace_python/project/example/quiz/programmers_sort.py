def solution(array, commands):
    answer = []
    for c in commands:
        temp = array[c[0]-1:c[1]]
        # temp.sort()
        for i in range(len(temp)):
            for j in range(i, len(temp)):
                if temp[i] > temp[j]:
                    temp[i], temp[j] = temp[j], temp[i]

        answer.append(temp[c[2]-1])


    return answer

print(solution([1, 5, 2, 6, 3, 7, 4], [[2, 5, 3], [4, 4, 1], [1, 7, 3]]))