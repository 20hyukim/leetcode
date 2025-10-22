package j2025;

import java.util.Arrays;
import java.util.Comparator;

class Solution3027 {
    public int numberOfPairs(int[][] points) {
        int len = points.length;
        int cnt = 0;

        Comparator<int[]> arrComp = new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                if (p1[0] == p2[0]) {
                    return p1[1] - p2[1];
                }
                return p2[0] - p1[0];
            }
        };

        Arrays.sort(points, arrComp);

        OUTER: for (int i = 0 ; i < len-1 ; i++) {
            int minY = Integer.MAX_VALUE;
            for (int j = i + 1 ; j < len; j ++) {
                if (points[j][1] < points[i][1]) {
                    continue;
                }
                else if (points[j][1] == points[i][1]) {
                    cnt++;
                    continue OUTER;
                }

                if (points[j][1] < minY) {
                    cnt++;
                    minY = points[j][1];
                }
            }

        }

        return cnt;
    }
}