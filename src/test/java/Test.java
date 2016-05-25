import com.iancaffey.polygon.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.function.Consumer;
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

        IntStream.range(0, 50)
                .mapToObj(imageLoader(orig))
                .map(RasterTransform::toBuffer)
                .map(RasterTransform.apply(Grayscale.LUMINOSITY))
                .map(EdgeDetection.grayscaleMatch(Color.BLACK, EdgeDetection.VERY_PRECISE))
                .map(ConvexHull::giftWrap)
                .map(PolyTransform::toImage)
                .forEach(imageRenderer(edges));
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

    public static Consumer<BufferedImage> imageRenderer(JPanel panel) {
        return image -> panel.add(new JLabel(new ImageIcon(image), SwingConstants.LEFT));
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
