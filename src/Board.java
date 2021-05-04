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
                    if (rand == 2) {
                        board[i][j] = new Tile(2);
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

    }

}
