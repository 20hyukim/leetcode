package j2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// !밀비 급일
public class B11365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        while (!str.equals("END")) {
            String[] parseStr = str.split("");

            for(int i = str.length()-1; i > -1; i--) {
                System.out.printf("%s", parseStr[i]);
            }
            System.out.println();

            str = br.readLine();
        }

        br.close();
    }


}
