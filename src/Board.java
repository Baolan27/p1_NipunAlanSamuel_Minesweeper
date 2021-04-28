public class Board {
    int l, w, m;
    Tile[][] board = new Tile[l][w];

    public Board() { //default is intermediate
        l = 16;
        w = 16;
        m = 40;
    }

    public Board(int length, int width, int numMines) { //custom game, beginner (9,9,10), expert (16,30,99)
        l = length;
        w = width;
        m = numMines;
    }

}
