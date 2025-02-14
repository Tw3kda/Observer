package edu.unisabana.dyas.patterns.observer;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import edu.unisabana.dyas.patterns.observer.impl.ConfigurationManager;
import edu.unisabana.dyas.patterns.observer.impl.observers.DateFormatObserver;
import edu.unisabana.dyas.patterns.observer.impl.observers.MoneyFormatObserver;

/**
 * @author cesarvefe
 
 */
public class ObserverMain {

    public static void main(String[] args) {
        ConfigurationManager conf = ConfigurationManager.getInstance();

         //Se establecen los valores por default.
         conf.setDefaultDateFormat(new SimpleDateFormat("yyyy/MM/dd"));
         conf.setMoneyFormat(new DecimalFormat("##.00"));
         System.out.println("Established configuration");
         
         //Se dan de alta lo observers
         DateFormatObserver dateFormatObserver = new DateFormatObserver();
         MoneyFormatObserver moneyFormatObserver = new MoneyFormatObserver();
         conf.addObserver(dateFormatObserver);
         conf.addObserver(moneyFormatObserver);

        Scanner scanner = new Scanner(System.in);

        // Ciclo en ejecución para cambios en runtime o tiempo real.
        while (true) {
            System.out.println("\nSelecciona (0, 1 o 2):");
            System.out.println("0. Salir");
            System.out.println("1. Cambiar formato de fecha");
            System.out.println("2. Cambiar formato de dinero");
            int command = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            if (command == 0) {
                break;  // Salir del ciclo
            }

            switch (command) {
                case 1: // Cambiar formato de fecha
                    System.out.println("");
                    System.out.println("Selecciona formato de fecha:");
                    System.out.println("1. dd/MM/yyyy");
                    System.out.println("2. yyyy-MM-dd");
                    System.out.println("3. MM-dd-yyyy");
                    int dateOption = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer

                    switch (dateOption) {
                        case 1:
                            conf.setDefaultDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
                            break;
                        case 2:
                            conf.setDefaultDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
                            break;
                        case 3:
                            conf.setDefaultDateFormat(new SimpleDateFormat("MM-dd-yyyy"));
                            break;
                        default:
                            System.out.println("Incorrecto. Pruebe de nuevo.");
                            break;
                    }
                    break;

                case 2: // Cambiar formato de dinero
                    System.out.println("");
                    System.out.println("Selecciona un formato de dinero:");
                    System.out.println("1. ###,#00.00");
                    System.out.println("2. ###,#00");
                    System.out.println("3. ###,###.00");
                    int moneyOption = scanner.nextInt();
                    scanner.nextLine();

                    switch (moneyOption) {
                        case 1:
                            conf.setMoneyFormat(new DecimalFormat("###,#00.00"));
                            break;
                        case 2:
                            conf.setMoneyFormat(new DecimalFormat("###,#00"));
                            break;
                        case 3:
                            conf.setMoneyFormat(new DecimalFormat("###,##0.00"));
                            break;
                        default:
                            System.out.println("Incorrecto. Pruebe de nuevo.");
                            break;
                    }
                    break;

                default:
                    System.out.println("Incorrecto. Pruebe de nuevo.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Programa terminado.");
    }
}