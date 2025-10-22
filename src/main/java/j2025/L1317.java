package j2025;

class Solution1317 {
    public int[] getNoZeroIntegers(int n) {
        int[] answer = new int[2];

        for (int i = 1; i < n; i ++) {
            if (zero_exists(i) || zero_exists(n-i)) {
                continue;
            };
            answer[0] = i;
            answer[1] = n-i;
            return answer;
        }
        return answer;
    }

    private boolean zero_exists(int x) {
        while (x >= 10) {
            if ( x % 10 == 0 ) {
                return true;
            };
            x = x / 10;
        }
        return false;
    }
}