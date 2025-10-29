package j2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 14697번 : 방 배정하기
public class B14697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inps = br.readLine().split(" ");

        int total = Integer.parseInt(inps[3]);
        int a = Integer.parseInt(inps[0]);
        int b = Integer.parseInt(inps[1]);
        int c = Integer.parseInt(inps[2]);

        int a_max = total / a;
        int b_max = total / b;
        int c_max = total / c;

        for (int a_i = 0 ; a_i <= a_max ; a_i++) {
            for (int b_i = 0 ; b_i <= b_max ; b_i++) {
                for (int c_i = 0 ; c_i <= c_max ; c_i++) {
                    if ((a*a_i) + (b*b_i) + (c*c_i) == total) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
        br.close();

    }
}
