import javax.swing.*;

public class Tile {

    ImageIcon coverImage; //initialize with generic tile image (same for all tiles)
    ImageIcon uncoveredImage; //initialize in constructor depending on the type
    ImageIcon display; //what the tile actually looks like

    //0 = empty tile, 1 = number tile, 2 = mine tile
    public Tile(int type) {
        if (type == 0) {
            //set uncovered image to an empty space
        } else if (type == 1) {
            //set uncovered image to a number
        } else if (type == 2) {
            //set uncovered image to a mine
        }
    }

    public ImageIcon getTileImage() {
        return display;
    }

}
