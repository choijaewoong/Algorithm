public class Main {

    public static void main(String[] args) {

        int[] changes = {15, 70, 149, 192, 243, 245, 294, 297, 369,390, 1094, 1466, 3160};
        int money = 2706;
        System.out.println(minCase(money,changes));
        System.out.println(countCases(money, changes));

    }

    public static int countCases(int num, int[] changes) {
        int numOfChange = changes.length;
        int[][] count = new int[changes.length+1][num+1];
        for(int i=1; i<num+1; i++) {
            count[0][i] = 0;
        }
        for(int i=0; i<numOfChange; i++) {
            count[i][0] = 1;
        }

        for(int i=1; i<=numOfChange; i++) {
            for(int j=1; j<=num; j++) {
                if(j-changes[i-1] < 0) {
                    count[i][j] = count[i-1][j];
                } else {
                    count[i][j] = count[i-1][j] + count[i][j-changes[i-1]];
                }
            }
        }
        return count[numOfChange][num];
    }

    public static int minCase(int num, int[] changes) {
        int[] min = new int[num+1];

        min[0] = 0;
        for(int i=1; i<=num; i++) {
            min[i] = 0;
            for(int j=0; j<changes.length; j++) {
                int idx = i-changes[j];
                if(idx < 0) {
                   break;
                } else {
                    if(min[i] == 0 || min[i] > (min[idx]+1)) {
                        min[i] = min[idx] + 1;
                    }
                }
            }
        }
        return min[num];
    }
}
