import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class PixelSorter {

    public PixelSorter() {

    }

    public BufferedImage sort(BufferedImage img) {

        int width = img.getWidth();
        int height = img.getHeight();

        float[][] imgPixelsHSB = new float[width * height][3];

        Color tempColor;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tempColor = new Color(img.getRGB(x, y));
                imgPixelsHSB[y * width + x] = Color.RGBtoHSB(tempColor.getRed(), tempColor.getGreen(), tempColor.getBlue(), null);
            }
        }

        java.util.Arrays.sort(imgPixelsHSB, (a, b) -> Float.compare(a[0], b[0]));

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                img.setRGB(x, y, Color.HSBtoRGB(imgPixelsHSB[y * width + x][0], imgPixelsHSB[y * width + x][1], imgPixelsHSB[y * width + x][2]));
            }
        }

        return img;
    }
}
