public class Board {

    private int l, w, m; //length, width,
    private Tile[][] board; //storing the tiles in a 2d array
    private boolean filled; //checks if the board is filled yet or just has empty tiles

    public Board() { //default is intermediate
        l = 16;
        w = 16;
        m = 40;
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
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Tile(7, this, i, j);
            }
        }
    }

    //implement filling algorithm
    public void fill(int clickX, int clickY) {
        //fill in mines
        for (int i = 0; i < m; i++) {
            int x = (int) (Math.random() * 9);
            int y = (int) (Math.random() * 9);
            if (board[x][y].getType() == 7 && !(x == clickX && y == clickY)) {
                board[x][y] = new Tile(9, this, x, y);
                System.out.println("filled a mine at " + x + y);
            } else {
                i--;
            }
        }

        //fill in method that fills out all the remaining tiles (they are empty by default)
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getType() != 9) {
                    // @alan - fill in your code here that calculates tile numbers (right now just puts 1)
                    board[i][j] = new Tile(3, this, i, j);
                }
            }
        }

        filled = true; // do not remove
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

    public boolean isFilled() {
        return filled;
    }
}