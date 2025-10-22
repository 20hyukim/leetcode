package j2025;

import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // 최대 힙: pass ratio 증가량이 큰 순서로 정렬
        PriorityQueue<ClassInfo> maxHeap = new PriorityQueue<>((a, b) ->
                Double.compare(b.gain(), a.gain())
        );

        // 초기 클래스들을 힙에 넣음
        for (int[] c : classes) {
            maxHeap.add(new ClassInfo(c[0], c[1]));
        }

        // 여분 학생 배정
        for (int i = 0; i < extraStudents; i++) {
            ClassInfo best = maxHeap.poll();  // 가장 효과 큰 클래스
            best.addStudent();                // 여분 학생 추가
            maxHeap.add(best);                // 다시 힙에 넣기
        }

        // 최종 평균 계산
        double total = 0.0;
        while (!maxHeap.isEmpty()) {
            ClassInfo c = maxHeap.poll();
            total += c.ratio();
        }

        return total / classes.length;
    }

    // 클래스 정보 저장용 객체
    static class ClassInfo {
        int pass;
        int total;

        ClassInfo(int pass, int total) {
            this.pass = pass;
            this.total = total;
        }

        // pass ratio
        double ratio() {
            return (double) pass / total;
        }

        // 학생 1명 추가했을 때의 향상량
        double gain() {
            return (double)(pass + 1) / (total + 1) - ratio();
        }

        // 여분 학생 1명 추가
        void addStudent() {
            pass++;
            total++;
        }
    }

}
