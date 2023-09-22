import javax.swing.*;
import java.awt.*;

public class PitagorasTree extends JFrame {

    private int nivel;
    private double lado;

    public PitagorasTree(int nivel, double lado) throws HeadlessException {

        this.nivel = nivel;
        this.lado = lado;

        setTitle("Arbol de Pitagoras");
        setMinimumSize(new Dimension(800, 700));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g, int nivel, double lado) {
        int[] x = {(getSize().width / 2) - ((int) lado / 2),
                (getSize().width / 2) - ((int) lado / 2),
                (getSize().width / 2) + ((int) lado / 2),
                (getSize().width / 2) + ((int) lado / 2)};
        int[] y = {getHeight() - 10,
                (getHeight() - 10) - (int) lado,
                (getHeight() - 10) - (int) lado,
                getHeight() - 10};
        if (nivel == 0) {
            g.fillPolygon(x, y, 4);
        } else {
            int newLado = (int)(lado*(Math.sqrt(2)/2));
            paint(g, nivel - 1, newLado);
        }

    }

    @Override
    public void paint(Graphics g) {
        paint(g, nivel, lado);
        //L*(raiz(2)/2)
    }
}
