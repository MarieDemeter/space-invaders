package campus.valence.demineur;

import java.util.HashSet;
import java.util.Set;

public class Demineur {
    private Case[][] board;

    public static Demineur create(int bombCount, int boardSize) {
        Set<Case.BombCase> bombes = new HashSet<>();
        while (bombes.size() < bombCount) {
            int x = (int) (Math.random() * boardSize);
            int y = (int) (Math.random() * boardSize);
            bombes.add(new Case.BombCase(x, y));
        }
        Case[][] board = new Case[boardSize][boardSize];
        for (Case bombe : bombes) {
            board[bombe.getX()][bombe.getY()] = bombe;
        }
        for (int i =0; i < board.length; i++) {
            for (int j =0; j<board.length;j++) {
                if (!(board[i][j] instanceof Case.BombCase)) {
                    board[i][j] = new Case.ClearCase(i,j);
                }
            }
        }
        return new Demineur(board);
    }

    protected Demineur(Case[][] board) {
        this.board = board;
    }
    String boardAsString() {
        String textToPrint = "";
        for (Case[] row : this.board) {
            textToPrint += "|";
            for (Case oneCase : row) {
                if (oneCase instanceof Case.BombCase) {
                    textToPrint += "X";
                } else {
                    int nbOfBombs = countBombsAround(oneCase.getX(), oneCase.getY());
                    textToPrint += nbOfBombs;
                }
            }
            textToPrint += "|\n";
        }
        return textToPrint;
    }

    public Case[][] getBoard() {
        return board;
    }

    public int countBombsAround(int x, int y) {
        int nbOfBombs = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && j >= 0 && i<this.board.length && j<this.board.length) {
                    if (this.board[j][i] instanceof Case.BombCase) {
                        nbOfBombs++;
                    }
                }
            }
        }
        return nbOfBombs;
//        if (this.board[x - 1][y + 1] instanceof Case.BombCase) {
//            nbOfBombs++;
//        }
//        if (this.board[x - 1][y] instanceof Case.BombCase) {
//            nbOfBombs++;
//        }
//        if (this.board[x - 1][y - 1] instanceof Case.BombCase) {
//            nbOfBombs++;
//        }
//        if (this.board[x][y + 1] instanceof Case.BombCase) {
//            nbOfBombs++;
//        }
//        if (this.board[x][y] instanceof Case.BombCase) {
//            nbOfBombs++;
//        }
//        if (this.board[x][y - 1] instanceof Case.BombCase) {
//            nbOfBombs++;
//        }
//        if (this.board[x + 1][y + 1] instanceof Case.BombCase) {
//            nbOfBombs++;
//        }
//        if (this.board[x + 1][y] instanceof Case.BombCase) {
//            nbOfBombs++;
//        }
//        if (this.board[x + 1][y - 1] instanceof Case.BombCase) {
//            nbOfBombs++;
//        }
    }
}
