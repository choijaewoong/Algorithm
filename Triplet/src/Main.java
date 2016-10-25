import java.util.Arrays;
import java.util.Scanner;

/*
입력 예제
10
-3 4 7 -1 6 5 -5 -8 2 -2
*/

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] numArr = new int[size];
        for(int i=0; i<size; i++) {
            numArr[i] = sc.nextInt();
        }
        printTriplet(numArr);
    }

    public static void printTriplet(int[] numArr) {
        Arrays.sort(numArr);
        int sum;
        for(int i=0; i<numArr.length-2; i++) {
            int start = i+1;
            int end = numArr.length-1;
            while(start < end) {
                sum = numArr[i] + numArr[start] + numArr[end];
                if(sum > 0) {
                    end--;
                } else if(sum < 0) {
                    start++;
                } else { // sum == 0
                    System.out.printf("[%d, %d, %d]\n", numArr[i], numArr[start], numArr[end]);
                    break;
                }
            }
        }
    }
}
