import com.iancaffey.polygon.util.EdgeDetection;
import com.iancaffey.polygon.util.PolyRendering;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.stream.IntStream;

/**
 * Test
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Test {
    public static void main(String[] args) throws IOException {
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        IntStream.range(0, 40).mapToObj(value -> {
            try {
                BufferedImage image1 = ImageIO.read(ClassLoader.getSystemResourceAsStream(value + ".png"));
                panel1.add(new JLabel(new ImageIcon(image1)));
                return image1;
            } catch (IOException e) {
                return null;
            }
        }).map(PolyRendering.buffer()).map(EdgeDetection.colorMatch(Color.BLACK, EdgeDetection.VERY_LOW)).map(PolyRendering.intToImage()).forEach(image1 -> panel2.add(new JLabel(new ImageIcon(image1))));

        JPanel panel3 = new JPanel(new BorderLayout());
        panel3.add(panel1, BorderLayout.NORTH);
        panel3.add(panel2, BorderLayout.SOUTH);
        JFrame frame = new JFrame("Edge Detection");
        frame.setContentPane(panel3);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
