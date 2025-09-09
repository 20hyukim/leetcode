package september2025;

class Solution2327 {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007; // modulo 값
        int[] dp = new int[n + 1]; // dp[i] = i일에 새로 비밀을 알게 된 사람 수
        dp[1] = 1; // Day 1, 첫 사람

        for (int day = 2; day <= n; day++) {

            // day에 해당하는 새로 비밀을 알게 된 사람 수 계산
            for (int prev = day - forget + 1; prev <= day - delay; prev++) {
                // 범위 : 현재 day - 잊기 전 + 1 ~ 현재 day - delay (딜레이 동안 말 못하니까 -> 새로 비밀을 알게 된 사람 수에 포함이 안됨.)
                if (prev >= 1) {
                    dp[day] = (dp[day] + dp[prev]) % MOD;
                }
            }
        }

        // 이제 비밀을 알고 있는 사람만 세자 (아직 forget 안한 사람들)
        // dp가 새로 알게된 사람 수를 가지고 있으니까, n 기준 -forget +1 부터 ~ n까지 더함.
        int total = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            if (i >= 1) {
                total = (total + dp[i]) % MOD;
            }
        }

        return total;
    }
}