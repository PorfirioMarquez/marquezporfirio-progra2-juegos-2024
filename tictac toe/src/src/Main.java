package src;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JPanel {
    private Tablero tablero;

    public Main() {
        tablero = new Tablero();

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int fila = e.getY() / 100;
                int columna = e.getX() / 100;
                tablero.colocarFicha(fila, columna);
                repaint();
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        tablero.dibujar(g);
    }

    public void actualizar() {
        tablero.actualizarFichas();
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic Tac Toe - Pool Edition");
        Main juego = new Main();
        
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(juego);
        frame.setVisible(true);

        // Ciclo de actualización para animación
        while (true) {
            juego.actualizar();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
