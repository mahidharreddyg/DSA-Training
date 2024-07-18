function countCombinations(coins, sum) {
    let dp = new Array(sum + 1).fill(0);

    dp[0] = 1;

    for (let i = 0; i < coins.length; i++) {
        let coin = coins[i];
        for (let j = coin; j <= sum; j++) {
            dp[j] += dp[j - coin];
        }
    }

    return dp[sum];
}

let coins = [1, 2, 3];
let sum = 4;
console.log(countCombinations(coins, sum));
