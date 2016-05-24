import com.iancaffey.polygon.util.EdgeDetection;
import com.iancaffey.polygon.util.Grayscale;
import com.iancaffey.polygon.util.PolyTransform;
import com.iancaffey.polygon.util.RasterTransform;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

/**
 * Test
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Test {
    public static void main(String[] args) throws IOException {
        JPanel orig = new JPanel(new GridLayout(1, 40));
        JPanel edges = new JPanel(new GridLayout(1, 40));

        IntStream.range(0, 40)
                .mapToObj(imageLoader(orig))
                .map(RasterTransform.toBuffer())
                .map(RasterTransform.toGrayscale(Grayscale.LUMINOSITY))
                .map(EdgeDetection.grayscaleMatchPoly(Color.BLACK, EdgeDetection.VERY_PRECISE))
                .map(PolyTransform.intToImage())
                .forEach(image -> edges.add(new JLabel(new ImageIcon(image), SwingConstants.LEFT)));

        JFrame frame = new JFrame("Edge Detection");
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(orig, BorderLayout.NORTH);
        panel.add(edges, BorderLayout.SOUTH);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static IntFunction<BufferedImage> imageLoader(JPanel panel) {
        return value -> {
            try {
                BufferedImage image = ImageIO.read(ClassLoader.getSystemResourceAsStream(value + ".png"));
                panel.add(new JLabel(new ImageIcon(image), SwingConstants.LEFT));
                return image;
            } catch (IOException e) {
                return null;
            }
        };
    }
}
