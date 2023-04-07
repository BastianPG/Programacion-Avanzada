import edu.princeton.cs.stdlib.StdDraw;
import java.awt.*;
public class taller1 {
    public static void main(String[] args) {

        double min = -1.0;
        double max = 1.0;

        StdDraw.setYscale(min, max);
        StdDraw.setXscale(min, max);
        StdDraw.enableDoubleBuffering();

        double x0 = min + (max - min) * Math.random(); // estos randoms son para hacer puntos aleatorios que formaran la linea
        double y0 = min + (max - min) * Math.random();
        double x1 = min + (max - min) * Math.random();
        double y1 = min + (max - min) * Math.random();

        //Velocidad random
        double velocidad = 1 * Math.random();

        double velocidadY0 = 0.01 * velocidad;
        double velocidadX0 = 0.02 * velocidad;
        double velocidadY1 = 0.03 * velocidad;
        double velocidadX1 = 0.04 * velocidad;

        while (true) {

            //los if son para hacer que rebote si se sale del cuadrado grafico
            if (Math.abs(x0 + velocidadX0) > 1.0) {
                velocidadX0 = -velocidadX0;
            }
            if (Math.abs(y0 + velocidadY0) > 1.0) {
                velocidadY0 = -velocidadY0;
            }
            if (Math.abs(x1 + velocidadX1) > 1.0) {
                velocidadX1 = -velocidadX1;
            }
            if (Math.abs(y1 + velocidadY1) > 1.0) {
                velocidadY1 = -velocidadY1;
            }
            //Aux para copiar los puntos
            double auxX0 = x0;
            double auxX1 = x1;
            double auxY0 = y0;
            double auxY1 = y1;

            //Aux para copiar las velocidades
            double auxVelocidadX0 = velocidadX0;
            double auxVelocidadX1 = velocidadX1;
            double auxVelocidadY0 = velocidadY0;
            double auxVelocidadY1 = velocidadY1;

            generadorLineas(x0, x1, y0, y1, velocidadX0, velocidadX1, velocidadY0, velocidadY1);
            StdDraw.show();
            StdDraw.clear();
            //Se les asigna la velocidad anterior
            velocidadX0 = auxVelocidadX0;
            velocidadX1 = auxVelocidadX1;
            velocidadY0 = auxVelocidadY0;
            velocidadY1 = auxVelocidadY1;

            //Se les asigna los valores anteriores de los puntos
            x0 = auxX0 + velocidadX0;
            y0 = auxY0 + velocidadY0;
            x1 = auxX1 + velocidadX1;
            y1 = auxY1 + velocidadY1;
        }
    }

    private static void generadorLineas(double x0, double x1, double y0, double y1, double velocidadX0, double velocidadX1, double velocidadY0, double velocidadY1) {
        for (int i = 0; i < 6; i++) {
            if (Math.abs(x0 + velocidadX0) > 1.0) {
                velocidadX0 = -velocidadX0;
            }
            if (Math.abs(y0 + velocidadY0) > 1.0) {
                velocidadY0 = -velocidadY0;
            }
            if (Math.abs(x1 + velocidadX1) > 1.0) {
                velocidadX1 = -velocidadX1;
            }
            if (Math.abs(y1 + velocidadY1) > 1.0) {
                velocidadY1 = -velocidadY1;
            }
            Color[] colores = {Color.BLACK, Color.CYAN, Color.BLUE, Color.RED, Color.DARK_GRAY, Color.GREEN, Color.YELLOW};
            int random = (int) (Math.random() * colores.length);
            Color color = colores[random];
            StdDraw.setPenColor(colores[random]);
            StdDraw.line(x0, y0, x1, y1);
            x0 += velocidadX0;
            y0 += velocidadY0;
            x1 += velocidadX1;
            y1 += velocidadY1;
            StdDraw.pause(8);
        }
    }
}