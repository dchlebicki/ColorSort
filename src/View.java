import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class View extends JFrame {

    private String currentImageFileName;

    public View() {
        super("Sort");
        this.getContentPane().add(new JPanel());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setSize(200, 200);
        this.setVisible(true);

        // todo: add buttons and file selector
    }

    public void paint(Graphics g) {
        if(currentImageFileName == null)
            return;

        File file = new File(currentImageFileName);
        try {
            BufferedImage img = ImageIO.read(file);
            g.drawImage(img, 5,5,this);
            img = new PixelSorter().sort(ImageIO.read(file));
            g.drawImage(img, img.getWidth() + 10, 5, this);

            this.setSize(2*img.getWidth() + 15, img.getHeight() + 10);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setImage(String imageName) {
        this.currentImageFileName = imageName;
        repaint();
    }
}
