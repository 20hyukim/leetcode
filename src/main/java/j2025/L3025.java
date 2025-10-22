package j2025;

class Solution3025 {
    int[][] points;
    int len;

    public int numberOfPairs(int[][] points) {
        this.len = points.length;
        this.points = points;

        int cnt = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) continue;

                // i is A, j is B
                if ((points[i][0] <= points[j][0]) && (points[i][1] >= points[j][1])) {
                    cnt += pointInARectangle(i, j);
                }
            }
        }

        return cnt;
    }

    private int pointInARectangle(int i, int j) {
        int left = Math.min(points[i][0], points[j][0]);
        int right = Math.max(points[i][0], points[j][0]);
        int bottom = Math.min(points[i][1], points[j][1]);
        int top = Math.max(points[i][1], points[j][1]);

        for (int k = 0; k < len; k++) {
            if (k == i || k == j) continue;

            int x = points[k][0], y = points[k][1];
            if (x >= left && x <= right && y >= bottom && y <= top) {
                return 0;
            }
        }

        return 1;
    }
}