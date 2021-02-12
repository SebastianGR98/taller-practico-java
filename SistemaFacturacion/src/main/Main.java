package main;

import facturacion.Factura;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Ingrese 1 para facturar, Ingrese 2 para salir: ");
                int opcion = entrada.nextInt();

                if (opcion == 1) {
                    Factura factura = new Factura();
                    continue;
                } else if (opcion == 2){
                    break;
                } else {
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Ingrese un numero entero");
                entrada.next();
            }
        }
    }
}
