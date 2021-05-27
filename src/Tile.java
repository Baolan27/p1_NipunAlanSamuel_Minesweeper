import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;

public class Tile extends JLabel{

    private ImageIcon coverImage = new ImageIcon("/Users/Loki/Downloads/p1_NipunAlanSamuel_Minesweeper/src/Images/tile.png", "Uncovered tile image"); //initialize with generic tile image (same for all tiles)
    private ImageIcon uncoveredImage; //initialize in constructor depending on the type
    private ImageIcon display; //what the tile actually looks like
    private boolean isFlagged = false;
    int type;

    //0 = empty tile, 1 = number tile, 2 = mine tile
    public Tile(int type) {
        this.type = type;
        if (type == 0) {
            //set uncovered image to an empty space
            uncoveredImage = new ImageIcon("/Users/Loki/Downloads/p1_NipunAlanSamuel_Minesweeper/src/Images/empty.png", "Empty tile image");
        } else if (type >= 1 && type <= 8) {
            //set uncovered image to a number
            uncoveredImage = new ImageIcon("/Users/Loki/Downloads/p1_NipunAlanSamuel_Minesweeper/src/Images/" + type + ".png", "Number tile image");
        } else if (type == 9) {
            //set uncovered image to a mine
            uncoveredImage = new ImageIcon("/Users/Loki/Downloads/p1_NipunAlanSamuel_Minesweeper/src/Images/mine.png", "Tile with mine image");
        }
        display = coverImage;
        super.setIcon(display);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    revealTile();
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    if (!isFlagged) {
                        flagTile();
                    } else {
                        unFlagTile();
                    }
                }
                System.out.println(type);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
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
        coverImage = new ImageIcon("/Users/Loki/Downloads/p1_NipunAlanSamuel_Minesweeper/src/Images/flag.png", "Tile with flag");
        display = coverImage;
        super.setIcon(display);
        isFlagged = true;
    }

    public void unFlagTile() {
        //removing the flag from a flagged tile
        coverImage = new ImageIcon("/Users/Loki/Downloads/p1_NipunAlanSamuel_Minesweeper/src/Images/tile.png", "Uncovered tile image");
        display = coverImage;
        super.setIcon(display);
        isFlagged = false;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public int getType() {
        return type;
    }
}