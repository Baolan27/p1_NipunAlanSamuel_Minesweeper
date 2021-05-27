import javax.swing.*;

public class Tile extends JLabel{

    public ImageIcon coverImage = new ImageIcon("src/Images/tile.png", "Uncovered tile image"); //initialize with generic tile image (same for all tiles)
    public ImageIcon uncoveredImage; //initialize in constructor depending on the type
    public ImageIcon display; //what the tile actually looks like
    int type;

    //0 = empty tile, 1 = number tile, 2 = mine tile
    public Tile(int type) {
        this.type = type;
        if (type == 0) {
            //set uncovered image to an empty space
            uncoveredImage = new ImageIcon("src/Images/empty.png", "Empty tile image");
        } else if (type >= 1 && type <= 8) {
            //set uncovered image to a number
            uncoveredImage = new ImageIcon("src/Images/" + type + ".png", "Number tile image");
        } else if (type == 9) {
            //set uncovered image to a mine
            uncoveredImage = new ImageIcon("src/Images/bomb.png", "Tile with mine image");
        }
        display = coverImage;
        super.setIcon(display);
    }

    public ImageIcon getTileImage() {
        return display;
    }

    public void revealTile() {
        display = uncoveredImage;
        super.setIcon(display);
    }

    public void flagTile() {
        //putting a flag on the tile
        coverImage = new ImageIcon("src/Images/flag.png", "Tile with flag");
        display = coverImage;
        super.setIcon(display);
    }

    public int getType() {
        return type;
    }
}
