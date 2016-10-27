import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
입력 예제
3
26 40 83
49 60 57
13 89 99
*/

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int inputCount = Integer.parseInt(br.readLine());
            int[][] minCost = new int[inputCount][3];

            String[] cost = br.readLine().split(" ");
            minCost[0][0] = Integer.parseInt(cost[0]);
            minCost[0][1] = Integer.parseInt(cost[1]);
            minCost[0][2] = Integer.parseInt(cost[2]);

            for (int i = 1; i < inputCount; i++) {
                cost = br.readLine().split(" ");
                main.setMinCost(minCost, i, cost);
            }
            int result = main.getMinCost(minCost[inputCount-1]);

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMinCost(int[][] minCost, int idx, String[] cost) {
        minCost[idx][0] = Integer.parseInt(cost[0]) + Math.min(minCost[idx-1][1], minCost[idx-1][2]);
        minCost[idx][1] = Integer.parseInt(cost[1]) + Math.min(minCost[idx-1][0], minCost[idx-1][2]);
        minCost[idx][2] = Integer.parseInt(cost[2]) + Math.min(minCost[idx-1][0], minCost[idx-1][1]);
    }

    public int getMinCost(int[] cost) {
        int red = cost[0];
        int green = cost[1];
        int blue = cost[2];
        return Math.min(Math.min(red, green), blue);
    }
}