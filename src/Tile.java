import javax.swing.*;

public class Tile {

    int type;
    ImageIcon coverImage; //initialize with generic tile image (same for all tiles)
    ImageIcon uncoveredImage; //initialize in constructor depending on the type
    ImageIcon display; //what the tile actually looks like

    //0 = empty tile, 1 = number tile, 2 = mine tile
    public Tile(int type) {
        this.type = type;
        if (type == 0) {
            //set uncovered image to an empty space
        } else if (type >= 1 && type <= 8) {
            //set uncovered image to a number
        } else if (type == 9) {
            // mine
        }
    }

    public int getType() {
        return type;
    }

    public void setUncoveredImage() {

    }

    public ImageIcon getTileImage() {
        return display;
    }


}
