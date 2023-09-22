import javax.swing.*;
import java.awt.*;

public class PythagorasTree extends JFrame {

    private final int level;

    public PythagorasTree(int level) {

        setTitle("Arbol de Pitagoras");
        setMinimumSize(new Dimension(1100, 720));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        this.level = level;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int width = getWidth();
        int height = getHeight();

        g.setColor(Color.DARK_GRAY);

        int x1, x2, x3, y1, y2, y3;
        int base = width / 7;

        x1 = (width / 2) - (base / 2);
        x2 = (width / 2) + (base / 2);
        x3 = width / 2;
        y1 = (height - (height / 15)) - base;
        y2 = height - (height / 15);
        y3 = (height - (height / 15)) - (base + (base / 2));

        g.fillPolygon(new int[]{x1, x1, x2, x2, x1}, new int[]{y1, y2, y2, y1, y1}, 5);

        int n1 = level;

        if (--n1 > 0) {
            g.fillPolygon(new int[]{x1, x3, x2}, new int[]{y1, y3, y1}, 3);
            paintMore(n1, g, x1, x3, x2, y1, y3, y1);
            paintMore(n1, g, x2, x3, x1, y1, y3, y1);
        }
    }

    public void paintMore(int n1, Graphics g, double x1_1, double x2_1, double x3_1, double y1_1, double y2_1, double y3_1) {
        int x1, x2, x3, y1, y2, y3;

        x1 = (int) (x1_1 + (x2_1 - x3_1));
        x2 = (int) (x2_1 + (x2_1 - x3_1));
        x3 = (int) (((x2_1 + (x2_1 - x3_1)) + ((x2_1 - x3_1) / 2)) + ((x1_1 - x2_1) / 2));
        y1 = (int) (y1_1 + (y2_1 - y3_1));
        y2 = (int) (y2_1 + (y2_1 - y3_1));
        y3 = (int) (((y1_1 + (y2_1 - y3_1)) + ((y2_1 - y1_1) / 2)) + ((y2_1 - y3_1) / 2));

        g.setColor(Color.MAGENTA);
        g.drawPolygon(new int[]{x1, x2, (int) x2_1, x1}, new int[]{y1, y2, (int) y2_1, y1}, 4);
        g.drawLine(x1, y1, (int) x1_1, (int) y1_1);
        g.drawLine((int) x2_1, (int) y2_1, x2, y2);
        g.drawLine(x1, y1, x2, y2);

        if (--n1 > 0) {
            g.drawLine(x1, y1, x3, y3);
            g.drawLine(x2, y2, x3, y3);
            paintMore(n1, g, x1, x3, x2, y1, y3, y2);
            paintMore(n1, g, x2, x3, x1, y2, y3, y1);
        }
    }
}
