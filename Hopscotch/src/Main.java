public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[][] test = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
        System.out.println(main.hopscotch(test, 3));
    }

    public int hopscotch(int[][] board, int size) {
        int[][] score = new int[size][4];
        for(int i=0; i<4; i++) {
            score[0][i] = board[0][i];
        }
        for(int i=1; i<size; i++) {
            setMaxScore(score, i, board);
        }
        return getMaxScore(score[size-1]);
    }

    public void setMaxScore(int[][] score, int i, int[][] board) {
        score[i][0] = board[i][0] + getMaxScore(score[i-1][1], score[i-1][2], score[i-1][3]);
        score[i][1] = board[i][1] + getMaxScore(score[i-1][0], score[i-1][2], score[i-1][3]);
        score[i][2] = board[i][2] + getMaxScore(score[i-1][0], score[i-1][1], score[i-1][3]);
        score[i][3] = board[i][3] + getMaxScore(score[i-1][0], score[i-1][1], score[i-1][2]);
    }
    public int getMaxScore(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
    public int getMaxScore(int[] score) {
        return Math.max(Math.max(Math.max(score[0], score[1]), score[2]), score[3]);
    }
}
