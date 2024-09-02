package tread.codingtest;

public class jv160585 {
    public static void main(String[] args) {
        String[] board = {"OXX", "OOX", "OXO"};
        int answer = 1;
        int countX = 0;
        int countO = 0;
        int clearX = 0;
        int clearO = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'X') {
                    countX++;
                    if (j == 1 && (board[i].charAt(0) == 'X' && board[i].charAt(2) == 'X')) {
                        clearX++;
                    }
                    if (i == 1 && (board[0].charAt(j) == 'X' && board[2].charAt(j) == 'X')) {
                        clearX++;
                    }
                    if (j == 1 && i == 1) {
                        if (board[0].charAt(2) == 'X' && board[2].charAt(0) == 'X') {
                            clearX++;
                        }
                        if (board[0].charAt(0) == 'X' && board[2].charAt(2) == 'X') {
                            clearX++;
                        }
                    }
                }
                if (board[i].charAt(j) == 'O') {
                    countO++;
                    if (j == 1 && (board[i].charAt(0) == 'O' && board[i].charAt(2) == 'O')) {
                        clearO++;
                    }
                    if (i == 1 && (board[0].charAt(j) == 'O' && board[2].charAt(j) == 'O')) {
                        clearO++;
                    }
                    if (j == 1 && i == 1) {
                        if (board[0].charAt(2) == 'O' && board[2].charAt(0) == 'O') {
                            clearO++;
                        }
                        if (board[0].charAt(0) == 'O' && board[2].charAt(2) == 'O') {
                            clearO++;
                        }
                    }
                }
            }

        }
        if (countX > countO) {
            answer = 0;
        }
        if (countO > countX + 1) {
            answer = 0;
        }
        if (clearO > 0 && countO == countX) {
            answer = 0;
        }
        if (clearX > 0 && countX+1 == countO) {
            answer = 0;
        }

        System.out.println(answer);
    }
}
