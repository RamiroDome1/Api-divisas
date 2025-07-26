import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
    ConsultarDivisa divisa = new ConsultarDivisa();
    boolean programa = true;
    Double resultado = null;

    while (programa){
        if (resultado==null) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("********************************************************* \n" +
                    "Bienvenido al conversor de monedas \n" +
                    "Ingrese lo que desea hacer \n \n" +
                    "1. Dolar a pesos \n" +
                    "2. pesos a dolar \n" +
                    "3. dolar a real \n" +
                    "4. real a dolar \n" +
                    "5. dolar a colombia\n" +
                    "6. colombia a dolar \n" +
                    "7. salir \n" +
                    "********************************************************* ");
            double numeroIngresado = scanner.nextInt();

            if (numeroIngresado == 1) {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Ingrese el numero de Dolares a convertir a pesos");
                double dolarACambiar = scanner1.nextInt();
                Double tasaCambio = divisa.HacerCambio("USD", "ARS");
                resultado = dolarACambiar*tasaCambio;
            }
            if (numeroIngresado == 2) {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Ingrese el numero de Pesos a convertir a Dolares");
                double dolarACambiar = scanner1.nextInt();
                Double tasaCambio = divisa.HacerCambio("ARS", "USD");
                resultado = dolarACambiar*tasaCambio;
            }
            if (numeroIngresado == 3) {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Ingrese el numero de Dolares a convertir a Reales");
                double dolarACambiar = scanner1.nextInt();
                Double tasaCambio = divisa.HacerCambio("USD", "BRL");
                resultado = dolarACambiar*tasaCambio;
            }
            if (numeroIngresado == 4) {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Ingrese el numero de Reales a convertir a Dolares");
                double dolarACambiar = scanner1.nextInt();
                Double tasaCambio = divisa.HacerCambio("BRL", "USD");
                resultado = dolarACambiar*tasaCambio;
            }
            if (numeroIngresado == 5) {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Ingrese el numero de USD a convertir a Pesos Colombianos");
                double dolarACambiar = scanner1.nextInt();
                Double tasaCambio = divisa.HacerCambio("USD", "COP");
                resultado = dolarACambiar*tasaCambio;
            }
            if (numeroIngresado == 6) {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Ingrese el numero de Pesos Colombianos a convertir a Dolares");
                double dolarACambiar = scanner1.nextInt();
                Double tasaCambio = divisa.HacerCambio("COP", "USD");
                resultado = dolarACambiar*tasaCambio;
            }
            if (numeroIngresado == 7) {
                System.out.println("Saliste del conversor");
                programa = false;
            }
            }
        else{
            System.out.println("Fue un total de: " + resultado);
            resultado = null;
        }
        }
    }
}
