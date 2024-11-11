package src;
import java.awt.Graphics;
import java.awt.Color;

public class Ficha {
    private int x, y;
    private char tipo; // 'X' o 'O'
    private boolean enMovimiento;
    private int velocidadX, velocidadY; // Velocidad para simular deslizamiento

    public Ficha(int x, int y, char tipo) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
        this.enMovimiento = true; // Empieza en movimiento para la animación de deslizamiento
        this.velocidadX = 5; // Velocidad inicial para simular movimiento en X
        this.velocidadY = 5; // Velocidad inicial para simular movimiento en Y
    }

    public void dibujar(Graphics g) {
        if (tipo == 'X') {
            g.setColor(Color.RED);
            g.drawLine(x, y, x + 50, y + 50);
            g.drawLine(x + 50, y, x, y + 50);
        } else if (tipo == 'O') {
            g.setColor(Color.BLUE);
            g.drawOval(x, y, 50, 50);
        }
    }

    public void actualizar() {
        if (enMovimiento) {
            x += velocidadX;
            y += velocidadY;
            
            // Condiciones para simular rebote
            if (x < 0 || x > 250) velocidadX *= -1;
            if (y < 0 || y > 250) velocidadY *= -1;
            
            // Frenar el movimiento gradualmente
            velocidadX *= 0.9;
            velocidadY *= 0.9;

            if (Math.abs(velocidadX) < 1 && Math.abs(velocidadY) < 1) {
                enMovimiento = false; // Detener el movimiento
            }
        }
    }

    public boolean estaEnMovimiento() {
        return enMovimiento;
    }

    public char getTipo() {
        return tipo;
    }
}
