import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
입력 예제
8 5
1 2
3 6
4 5
5 7
4 7
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        int edge = sc.nextInt();
        ArrayList<Integer>[] graphList = new ArrayList[vertex+1];
        for(int i=1; i<=vertex; i++) {
            graphList[i] = new ArrayList<>();
        }
        for(int i=0; i<edge; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graphList[u].add(v);
            graphList[v].add(u);
        }
        for(int i=1; i<=vertex; i++) {
            Collections.sort(graphList[i]);
        }
        boolean[] check = new boolean[vertex+1];
        int componentCount = 0;
        for(int i=1; i<=vertex; i++) {
            if(!check[i]) {
                dfs(graphList, check, i);
                componentCount++;
            }
        }
        System.out.println(componentCount);
    }

    public static void dfs(ArrayList<Integer>[] graphList, boolean[] check, int idx) {
        if(check[idx]) {
            return;
        }
        check[idx] = true;
        for(int v : graphList[idx]) {
            if(!check[v]) {
                dfs(graphList, check, v);
            }
        }
    }
}
