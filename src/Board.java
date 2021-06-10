import java.awt.*;

public class Board {

    private int l, w, m; //length, width,
    private Tile[][] board; //storing the tiles in a 2d array
    private boolean filled; //checks if the board is filled yet or just has empty tiles

    
    public Board() { //default is intermediate
        l = 16;
        w = 16;
        m = 35;
        board = new Tile[l][w];
        fillTemp();
        filled = false; //not filled until the proper fill() method is called, not fillTemp()
    }

    public Board(int length, int width, int numMines) { //custom game, beginner (9,9,10), expert (16,30,99)
        l = length;
        w = width;
        m = numMines;
        fillTemp();
    }

    //temporarily filling the board with empty tiles
    public void fillTemp() {
        int x = 15, y = 16;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (j == 15) {
                    board[i][j] = new Tile(0, this, i, 0);
                } else {
                    if (i == j) {
                        x = 15;
                        y--;
                    } else {
                        x--;
                    }
                    board[i][j] = new Tile(0, this, x, y);
                }
            }
        }
    }

    //implement filling algorithm
    public void fill(int clickX, int clickY) {
        //fill in mines
        for (int i = 0; i < m; i++) {
            int x = (int) (Math.random() * 16);
            int y = (int) (Math.random() * 16);
            if (getTile(x, y).getType() == 0 && !(Math.abs(x - clickX) <= 1 && Math.abs(y - clickY) <= 1)) {
                getTile(x, y).changeType(9);
            } else {
                i--;
            }
        }

        //fill in method that fills out all the remaining tiles (they are empty by default)
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getType() != 9) {
                    //calculates tile numbers based on number of surrounding mines
                    int count = 0;
                    if (board[i][j].x > 0) {
                        if (getTile(board[i][j].x - 1, board[i][j].y).getType() == 9) {
                            count++;
                        }
                        if (board[i][j].y > 0 && getTile(board[i][j].x - 1, board[i][j].y - 1).getType() == 9) {
                            count++;
                        }
                        if (board[i][j].y < 15 && getTile(board[i][j].x - 1, board[i][j].y + 1).getType() == 9) {
                            count++;
                        }
                    }
                    if (board[i][j].y > 0 && getTile(board[i][j].x, board[i][j].y - 1).getType() == 9) {
                        count++;
                    }
                    if (board[i][j].y < 15 && getTile(board[i][j].x, board[i][j].y + 1).getType() == 9) {
                        count++;
                    }
                    if (board[i][j].x < 15) {
                        if (getTile(board[i][j].x + 1, board[i][j].y).getType() == 9) {
                            count++;
                        }
                        if (board[i][j].y > 0 && getTile(board[i][j].x + 1, board[i][j].y - 1).getType() == 9) {
                            count++;
                        }
                        if (board[i][j].y < 15 && getTile(board[i][j].x + 1, board[i][j].y + 1).getType() == 9) {
                            count++;
                        }
                    }
                    board[i][j].changeType(count);
                }
            }
        }

        filled = true; // do not remove
    }

    public void floodFill(int x, int y) {
        getTile(x, y).reveal();
        if (getTile(x - 1, y) != null && !getTile(x - 1, y).isRevealed()) {
            if (getTile(x - 1, y).getType() == 0) {
                floodFill(x - 1, y);
            } else {
                getTile(x - 1, y).reveal();
            }
        }
        if (getTile(x + 1, y) != null && !getTile(x + 1, y).isRevealed()) {
            if (getTile(x + 1, y).getType() == 0) {
                floodFill(x + 1, y);
            } else {
                getTile(x + 1, y).reveal();
            }
        }
        if (getTile(x, y - 1) != null && !getTile(x, y - 1).isRevealed()) {
            if (getTile(x, y - 1).getType() == 0) {
                floodFill(x, y - 1);
            } else {
                getTile(x, y - 1).reveal();
            }
        }
        if (getTile(x, y + 1) != null && !getTile(x, y + 1).isRevealed()) {
            if (getTile(x, y + 1).getType() == 0) {
                floodFill(x, y + 1);
            } else {
                getTile(x, y + 1).reveal();
            }
        }
        if (getTile(x - 1, y - 1) != null && !getTile(x - 1, y - 1).isRevealed()) {
            if (getTile(x - 1, y - 1).getType() == 0) {
                floodFill(x - 1, y - 1);
            } else {
                getTile(x - 1, y - 1).reveal();
            }
        }
        if (getTile(x - 1, y + 1) != null && !getTile(x - 1, y + 1).isRevealed()) {
            if (getTile(x - 1, y + 1).getType() == 0) {
                floodFill(x - 1, y + 1);
            } else {
                getTile(x - 1, y + 1).reveal();
            }
        }
        if (getTile(x + 1, y - 1) != null && !getTile(x + 1, y - 1).isRevealed()) {
            if (getTile(x + 1, y - 1).getType() == 0) {
                floodFill(x + 1, y - 1);
            } else {
                getTile(x + 1, y - 1).reveal();
            }
        }
        if (getTile(x + 1, y + 1) != null && !getTile(x + 1, y + 1).isRevealed()) {
            if (getTile(x + 1, y + 1).getType() == 0) {
                floodFill(x + 1, y + 1);
            } else {
                getTile(x + 1, y + 1).reveal();
            }
        }
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public Tile[][] getBoard() {
        return board;
    }

    public Tile getTile(int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].x == x && board[i][j].y == y) {
                    return board[i][j];
                }
            }
        }
        return null;
    }

    public boolean isFilled() {
        return filled;
    }

    public boolean won() {
        int count = 0;
        for (Tile[] T: board) {
            for (Tile t : T) {
                if (t.isRevealed()) {
                    if (t.getType() == 9) return false;
                    else count++;
                }
            }
        }
        return (count == l*w - m && !lost());
    }

    public boolean lost() {
        for (Tile[] T: board) {
            for (Tile t: T) {
                if (t.isRevealed() && t.getType() == 9) {
                    return true;
                }
            }
        }
        return false;
    }
 
}

