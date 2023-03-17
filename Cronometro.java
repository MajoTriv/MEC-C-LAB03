import java.util.Timer;
import java.util.TimerTask;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Cronometro {

    private static int contador = 0;
    private static int tiempoAlarma = 0;
    private static boolean alarmaActiva = false;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("En cuantos minutos desea sonar la arlama--> ");
        tiempoAlarma = scanner.nextInt();

        Timer timer = new Timer();
        TimerTask tarea = new TimerTask() {
            public void run() {
                contador++;
                System.out.println(obtenerHora());

                if (contador == tiempoAlarma * 60) {
                    activarAlarma();
                }

                if (alarmaActiva) {
                    if (contador % 10 == 0) {
                        sonarAlarma();
                    }
                }
            }
        };

        timer.scheduleAtFixedRate(tarea, 0, 1000);

    }

    public static void activarAlarma() {
        System.out.println("¡Se activa la alarma!");
        alarmaActiva = true;
    }

    public static void sonarAlarma() {
        System.out.println("¡ALARMA ALARMA ALARMA!");
    }

    public static String obtenerHora() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }

}
