import com.iancaffey.polygon.util.EdgeDetection;
import com.iancaffey.polygon.util.Grayscale;
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
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        IntStream.range(0, 40)
                .mapToObj(imageLoader(panel))
                .map(RasterTransform.toBuffer())
                .map(RasterTransform.toGrayscale(Grayscale.LUMINOSITY))
                .map(EdgeDetection.grayscaleMatch(Color.BLACK, EdgeDetection.VERY_PRECISE))
                .map(RasterTransform.toImage())
                .forEach(image1 -> panel2.add(new JLabel(new ImageIcon(image1))));

        JFrame frame = new JFrame("Edge Detection");
        JPanel panel3 = new JPanel(new BorderLayout());
        panel3.add(panel, BorderLayout.NORTH);
        panel3.add(panel2, BorderLayout.SOUTH);
        frame.setContentPane(panel3);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static IntFunction<BufferedImage> imageLoader(JPanel panel) {
        return value -> {
            try {
                BufferedImage image = ImageIO.read(ClassLoader.getSystemResourceAsStream(value + ".png"));
                panel.add(new JLabel(new ImageIcon(image)));
                return image;
            } catch (IOException e) {
                return null;
            }
        };
    }
}
