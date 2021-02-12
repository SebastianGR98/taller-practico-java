package facturacion;

import electrodomesticos.Electrodomestico;
import electrodomesticos.Nevera;
import electrodomesticos.Televisor;
import java.util.HashMap;
import java.util.Scanner;

public class Factura {
    private HashMap<Integer, Electrodomestico> electrodomesticos;
    private int totalElectrodomesticos;
    private int numeroElectrodomesticos;
    private int totalTelevisores;
    private int numeroTelevisores;
    private int totalNeveras;
    private int numeroNeveras;

    public Factura() {
        this.electrodomesticos = new HashMap<Integer, Electrodomestico>();
        this.totalElectrodomesticos = 0;
        this.numeroElectrodomesticos = 0;
        this.totalTelevisores = 0;
        this.numeroTelevisores = 0;
        this.totalNeveras = 0;
        this.numeroNeveras = 0;
        facturar();
    }

    private void facturar() {
        Scanner entrada = new Scanner(System.in);
        int numeroElectrodomesticos;

        // El usuario ingresa cuantos electrodomesticos quiere facturar
        while (true) {
            try {
                System.out.print("Ingrese el número de electrodomésticos que desea facturar: ");
                numeroElectrodomesticos = entrada.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Favor ingresar un número entero");
                entrada.next();
            }
        }

        ingresarElectrodomesticos(entrada, numeroElectrodomesticos);
        totalizar();
    }

    private char ingresarConsumo(Scanner entrada) {
        char consumo;

        // El usuario ingresa consumo
        while (true) {
            try {
                System.out.print("Ingrese consumo (A, B ó C): ");
                consumo = entrada.next().charAt(0);

                if ((consumo != 'A') && (consumo != 'B') && (consumo != 'C')) {
                    continue;
                }

                break;
            } catch (Exception e) {
                System.out.println("Ingrese un caracter");
                entrada.next();
            }
        }

        return consumo;
    }

    private String ingresarProcedencia(Scanner entrada) {
        int procedencia;

        // El usuario ingresa consumo
        while (true) {
            try {
                System.out.print("Ingrese 1 para Nacional\nIngrese 2 para Importado\n¿Qué procedencia desea escoger?: ");
                procedencia = entrada.nextInt();

                if (procedencia == 1) {
                    return "Nacional";
                } else if (procedencia == 2) {
                    return "Importado";
                } else {
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Ingrese un numero entero");
                entrada.next();
            }
        }
    }

    private void ingresarElectrodomesticos(Scanner entrada, int numeroElectrodomesticos) {
        for (int i = 0; i < numeroElectrodomesticos; i++) {
            // El usuario ingresa que electrodomestico quiere facturar
            while (true) {
                try {
                    System.out.print("Ingrese 1 para electrodoméstico\nIngrese 2 para televisor\nIngrese 3 para nevera\n¿Qué desea agregar?: ");
                    int opcion = entrada.nextInt();

                    switch (opcion) {
                        case 1: {
                            char consumo = ingresarConsumo(entrada);
                            String procedencia = ingresarProcedencia(entrada);
                            ingresarElectrodomestico(consumo, procedencia, i);
                            break;
                        }
                        case 2: {
                            char consumo = ingresarConsumo(entrada);
                            String procedencia = ingresarProcedencia(entrada);
                            ingresarTelevisor(entrada, consumo, procedencia, i);
                            break;
                        }
                        case 3: {
                            char consumo = ingresarConsumo(entrada);
                            String procedencia = ingresarProcedencia(entrada);
                            ingresarNevera(entrada, consumo, procedencia, i);
                            break;
                        }
                        default:
                            System.out.println("Ingrese una opción en el rango de 1 a 3");
                            i--;
                            break;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Favor ingresar un número entero");
                    entrada.next();
                }
            }
        }
    }

    private void ingresarElectrodomestico(char consumo, String procedencia, int i) {
        Electrodomestico electrodomestico = new Electrodomestico(consumo, procedencia);
        electrodomestico.mostrarInformacion();
        this.electrodomesticos.put(i, electrodomestico);
    }

    private void ingresarTelevisor(Scanner entrada, char consumo, String procedencia, int i) {
        int tamano;
        int entradaTDT;
        boolean tieneTDT;

        // Ingresar tamaño televisor
        while (true) {
            try {
                System.out.print("Ingresar tamaño televisor (pulgadas): ");
                tamano = entrada.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Ingrese un número entero");
                entrada.next();
            }
        }

        // Ingresar si tiene TDT
        while (true) {
            try {
                System.out.print("Ingrese 1 si tiene\nIngrese 2 si no tiene\n¿Tiene TDT?: ");
                entradaTDT = entrada.nextInt();

                if (entradaTDT == 1){
                    tieneTDT = true;
                    break;
                } else if (entradaTDT == 2) {
                    tieneTDT = false;
                    break;
                } else {
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Ingrese un número entero");
                entrada.next();
            }
        }

        Electrodomestico televisor = new Televisor(consumo, procedencia, tamano, tieneTDT);
        televisor.mostrarInformacion();
        this.electrodomesticos.put(i, televisor);
    }

    private void ingresarNevera(Scanner entrada, char consumo, String procedencia, int i) {
        int capacidad;

        // Ingresar capacidad
        while (true) {
            try {
                System.out.print("Ingresar capacidad nevera (litros): ");
                capacidad = entrada.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Ingrese un número entero");
                entrada.next();
            }
        }

        Electrodomestico nevera = new Nevera(consumo, procedencia, capacidad);
        nevera.mostrarInformacion();
        this.electrodomesticos.put(i, nevera);
    }

    private void totalizar() {
        for (int i : this.electrodomesticos.keySet()) {
            if (this.electrodomesticos.get(i) instanceof Televisor) {
                this.totalTelevisores += this.electrodomesticos.get(i).getPrecio();
                this.numeroTelevisores++;
            } else if (this.electrodomesticos.get(i) instanceof Nevera) {
                this.totalNeveras += this.electrodomesticos.get(i).getPrecio();
                this.numeroNeveras++;
            }

            this.totalElectrodomesticos += this.electrodomesticos.get(i).getPrecio();
            this.numeroElectrodomesticos++;
        }

        System.out.println("----------------------------------------------------------------");
        System.out.println("Número de televisores: " + this.numeroTelevisores);
        System.out.println("Número de neveras: " + this.numeroNeveras);
        System.out.println("Número de electrodomesticos: " + this.numeroElectrodomesticos);
        System.out.println("Valor total de televisores: " + this.totalTelevisores);
        System.out.println("Valor total de neveras: " + this.totalNeveras);
        System.out.println("Valor total de electrodomesticos: " + this.totalElectrodomesticos);
        System.out.println("----------------------------------------------------------------");
    }
}
