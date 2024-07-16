function findMaxCrossingSubarray(arr, left, mid, right) {
    let leftSum = -Infinity;
    let sum = 0;
    let maxLeft = mid;

    for (let i = mid; i >= left; i--) {
        sum += arr[i];
        if (sum > leftSum) {
            leftSum = sum;
            maxLeft = i;
        }
    }

    let rightSum = -Infinity;
    sum = 0;
    let maxRight = mid + 1;

    for (let j = mid + 1; j <= right; j++) {
        sum += arr[j];
        if (sum > rightSum) {
            rightSum = sum;
            maxRight = j;
        }
    }

    return {
        maxLeft: maxLeft,
        maxRight: maxRight,
        sum: leftSum + rightSum
    };
}

function findMaximumSubarray(arr, left, right) {
    if (left === right) {
        return {
            maxLeft: left,
            maxRight: right,
            sum: arr[left]
        };
    } else {
        let mid = Math.floor((left + right) / 2);
        let leftSubarray = findMaximumSubarray(arr, left, mid);
        let rightSubarray = findMaximumSubarray(arr, mid + 1, right);
        let crossingSubarray = findMaxCrossingSubarray(arr, left, mid, right);

        if (leftSubarray.sum >= rightSubarray.sum && leftSubarray.sum >= crossingSubarray.sum) {
            return leftSubarray;
        } else if (rightSubarray.sum >= leftSubarray.sum && rightSubarray.sum >= crossingSubarray.sum) {
            return rightSubarray;
        } else {
            return crossingSubarray;
        }
    }
}

function maxSubArray(arr) {
    let result = findMaximumSubarray(arr, 0, arr.length - 1);
    let subArray = arr.slice(result.maxLeft, result.maxRight + 1);
    return {
        length: subArray.length,
        maxSum: result.sum,
        subArray: subArray
    };
}


let input = [ -2, 3, 4, -1, -2, 1, 5, -3 ];
let output = maxSubArray(input);

console.log(`Length of the subarray: ${output.length}`);
console.log(`Maximum sum: ${output.maxSum}`);
console.log(output.subArray);
