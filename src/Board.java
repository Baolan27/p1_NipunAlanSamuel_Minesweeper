public class Board {

    private int l, w, m; //length, width,
    private Tile[][] board; //storing the tiles in a 2d array

    public Board() { //default is intermediate
        l = 16;
        w = 16;
        m = 40;
        board = new Tile[l][w];
        fill();
    }

    public Board(int length, int width, int numMines) { //custom game, beginner (9,9,10), expert (16,30,99)
        l = length;
        w = width;
        m = numMines;
        fill();
    }
  
    public void fill() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Tile((int) (Math.random() * 10));
                //board[i][j] = new Tile(3);
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
}