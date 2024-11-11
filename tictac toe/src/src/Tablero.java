package src;
import java.awt.Graphics;

public class Tablero {
    private Ficha[][] casillas;
    private char turnoActual;

    public Tablero() {
        casillas = new Ficha[3][3];
        turnoActual = 'X';
    }

    public void reiniciar() {
        casillas = new Ficha[3][3];
        turnoActual = 'X';
    }

    public boolean colocarFicha(int fila, int columna) {
        if (casillas[fila][columna] == null) {
            casillas[fila][columna] = new Ficha(fila * 100, columna * 100, turnoActual);
            turnoActual = (turnoActual == 'X') ? 'O' : 'X';
            return true;
        }
        return false;
    }

    public void verificarVictoria() {
        // Implementa la lógica de verificación de victoria aquí
    }

    public void dibujar(Graphics g) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (casillas[i][j] != null) {
                    casillas[i][j].dibujar(g);
                }
            }
        }
    }

    public void actualizarFichas() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (casillas[i][j] != null && casillas[i][j].estaEnMovimiento()) {
                    casillas[i][j].actualizar();
                }
            }
        }
    }
}
