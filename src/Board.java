public class Board {
    int l, w, m;
    int cMines;
    Tile[][] board = new Tile[l][w];
    int x, y;

    public Board() { //default is no bombs filled
        l = 16;
        w = 16;
        m = 40;
        cMines = 0;
    }

    public Board(int length, int width, int numMines) { //custom game, beginner (9,9,10), expert (16,30,99)
        l = length;
        w = width;
        m = numMines;
        cMines = 0;
    }

    public void fill() {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                if (cMines < 40) {
                    int rand = (int)(Math.random()*10);
                    if (rand == 9) {
                        board[i][j] = new Tile(9);
                        cMines++;
                    }
                    else board[i][j] = new Tile(0);
                } else {
                    board[i][j] = new Tile(0);
                }
            }
        }
    }

    public void computeNo() {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                int count = 0;
                if (board[i][j].getType() == 0) {
                    if (i == 0 || i == l-1 || j == 0 || j == w - 1) {
                        // test for corner cases
                        if (i == 0 && j == 0) { // top left
                            if (board[i][j+1].getType() == 9) count++;
                            if (board[i+1][j+1].getType() == 9) count++;
                            if (board[i+1][j].getType() == 9) count++;
                        } else if (i == 0 && j == w-1) { // top right
                            if (board[i][j-1].getType() == 9) count++;
                            if (board[i+1][j-1].getType() == 9) count++;
                            if (board[i+1][j].getType() == 9) count++;
                        } else if (i == l-1 && j == 0) { // bottom left
                            if (board[i][j+1].getType() == 9) count++;
                            if (board[i-1][j+1].getType() == 9) count++;
                            if (board[i-1][j].getType() == 9) count++;
                        } else if (i == l-1 && j == w-1) { // bottom right
                            if (board[i][j-1].getType() == 9) count++;
                            if (board[i-1][j-1].getType() == 9) count++;
                            if (board[i-1][j].getType() == 9) count++;
                        } else {
                            if (i == 0) {
                                for (int I = i-1; I <= i+1; I++) {
                                    if (board[I][j].getType() == 9) count++;
                                    if (board[I][j+1].getType() == 9) count++;
                                }
                            } else if (i == l-1) {
                                for (int I = i-1; I <= i+1; I++) {
                                    if (board[I][j].getType() == 9) count++;
                                    if (board[I][j-1].getType() == 9) count++;
                                }
                            } else if (j == 0) {
                                for (int J = j-1; J <= j+1; J++) {
                                    if (board[i][J].getType() == 9) count++;
                                    if (board[i+1][J].getType() == 9) count++;
                                }
                            } else {
                                for (int J = j-1; J <= j+1; J++) {
                                    if (board[i-1][J].getType() == 9) count++;
                                    if (board[i][J].getType() == 9) count++;
                                }
                            }
                        }
                    } else {
                        // test 3x3 square around a given "0" tile
                        for (int I = i-1; I <= i+1; I++) {
                            for (int J = j-1; J <= j+1; J++) {
                                if (board[I][J].getType() == 9) count++;
                            }
                        }
                    }
                    board[i][j] = new Tile(count);
                }
            }
        }
    }

}
