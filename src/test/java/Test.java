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
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        IntStream.range(0, 40)
                .mapToObj(Test.read())
                .map(RasterTransform.toBuffer())
                .map(RasterTransform.toGrayscale(Grayscale.LUMINOSITY))
                .map(EdgeDetection.grayscaleMatch(Color.BLACK, EdgeDetection.VERY_PRECISE))
                .map(PolyTransform.intToImage())
                .forEach(image1 -> panel.add(new JLabel(new ImageIcon(image1))));

        JFrame frame = new JFrame("Edge Detection");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static IntFunction<BufferedImage> read() {
        return value -> {
            try {
                return ImageIO.read(ClassLoader.getSystemResourceAsStream(value + ".png"));
            } catch (IOException e) {
                return null;
            }
        };
    }
}
