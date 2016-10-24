import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
예제 입력
3 16
 */

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] strings = br.readLine().split(" ");
            int m = Integer.parseInt(strings[0]);
            int n = Integer.parseInt(strings[1]);

            String str = main.sieveOfEratosthenes(m, n);
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String sieveOfEratosthenes(int m, int n) {
        boolean prime[] = new boolean[n+1];
        for(int i=2; i<=n; i++){
            prime[i] = true;
        }
        for(int i=2; i<Math.sqrt(n); i++) {
            if(prime[i]) {
                for(int j=i*2; j<=n; j+=i) {
                    prime[j] = false;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=m; i<=n; i++) {
            if(prime[i]){
                stringBuilder.append(i + "\n");
            }
        }
        return stringBuilder.toString();
    }
}

