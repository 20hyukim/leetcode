package september2025;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution1773 {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length; // 사람 수 (languages 배열의 길이)

        // 각 사람마다 알고 있는 언어들을 Set으로 변환해서 저장
        // langMap.get(i) = i번 사람이 알고 있는 언어 집합
        List<Set<Integer>> langMap = new ArrayList<>();
        for (int[] langs : languages) {
            Set<Integer> set = new HashSet<>();
            for (int lang : langs) {
                set.add(lang); // 중복 제거를 위해 Set 사용
            }
            langMap.add(set);
        }

        // 공통 언어가 없는 친구 쌍에서 소통이 안 되는 사람들만 추출
        // 어떤 언어를 가르쳐야 할 사람들의 후보군
        Set<Integer> toTeach = new HashSet<>();

        for (int[] f : friendships) {
            int a = f[0] - 1; // 문제는 1-based index지만 Java는 0-based이므로 보정
            int b = f[1] - 1;

            Set<Integer> setA = langMap.get(a);
            Set<Integer> setB = langMap.get(b);

            // 두 사람이 공통 언어를 하나라도 가지고 있는지 확인
            boolean canTalk = false;
            for (int l : setA) {
                if (setB.contains(l)) {
                    canTalk = true; // 공통 언어 발견
                    break;
                }
            }

            // 공통 언어가 없다면, 이 둘 중 적어도 한 명은 언어를 배워야 하므로 대상에 추가
            if (!canTalk) {
                toTeach.add(a);
                toTeach.add(b);
            }
        }

        // 1번부터 n번까지의 언어 중 하나를 선택했을 때,
        // 그 언어를 가르쳐야 할 최소 인원 수를 계산
        int min = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int cnt = 0;

            // 공통 언어 없는 친구쌍에 속한 사람들 중
            // 현재 언어(lang)를 모르는 사람 수를 세기
            for (int person : toTeach) {
                if (!langMap.get(person).contains(lang)) {
                    cnt++; // 이 사람은 lang을 배워야 함
                }
            }

            // 언어 lang을 선택했을 때 최소로 가르칠 수 있는 인원인지 체크
            min = Math.min(min, cnt);
        }

        // 최소 인원 수 반환
        return min;
    }
}