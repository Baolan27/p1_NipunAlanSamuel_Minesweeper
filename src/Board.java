public class Board {

    private int l, w, m; //length, width,
    private Tile[][] board; //storing the tiles in a 2d array

    public Board() { //default is intermediate
        l = 16;
        w = 16;
        m = 40;
        board = new Tile[l][w];
        fillTemp();
    }

    public Board(int length, int width, int numMines) { //custom game, beginner (9,9,10), expert (16,30,99)
        l = length;
        w = width;
        m = numMines;
        fill();
    }

    //temporarily filling the board with empty tiles
    public void fillTemp() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Tile(0);
            }
        }
    }

    //implement filling algorithm
    public void fill() {
        //fill in mines
        for (int i = 0; i < m; i++) {
            int x = (int) (Math.random() * 9);
            int y = (int) (Math.random() * 9);
            if (board[x][y].getType() == 0) {
                board[x][y] = new Tile(9);
            } else {
                i--;
            }
        }
        //@alan - fill in method that fills out all the remaining tiles (they are empty by default)
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
}