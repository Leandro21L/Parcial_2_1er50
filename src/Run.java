import javax.swing.*;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        try {
            int op = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un nivel", "Arbol de Pitagoras", JOptionPane.INFORMATION_MESSAGE));
            if (op>0) {
                new PythagorasTree(op);
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un numero mayor a 0", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Tiene que Ingresar un numero", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
