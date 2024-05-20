import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hola!! bienvenido a el sistema de salarios de clean fast S.A.");
        System.out.println("A continuación, digite lo que se le pide.");
        String[][] arreglo = digTrabajadores(sc);
        System.out.println("----------------------------------------");
        double[] salarios = digSalarios(sc);
        mostrar(arreglo, salarios);
        int seleccion = seleccion(sc);

        while (true) {
            if (seleccion == 1) {
                salarios = aumento(sc, salarios);
                mostrar(arreglo, salarios);
            } else if (seleccion == 2) {
                arreglo = aumentoTrabajadores(arreglo, sc);
                salarios = aumentoSalario(salarios, sc);
                mostrar(arreglo, salarios);
            } else if (seleccion == 0) {
                break;
            }
            seleccion = seleccion(sc);
        }
    }

    public static String[][] digTrabajadores(Scanner sc) {
        String[][] arreglo = new String[5][2];
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                if (j == 0) {
                    System.out.println("Digite el nombre del trabajador número: " + (i + 1));
                    arreglo[i][j] = sc.nextLine();
                } else {
                    System.out.println("Digite el cargo del trabajador número: " + (i + 1));
                    arreglo[i][j] = sc.nextLine();
                }
            }
        }
        return arreglo;
    }

    public static double[] digSalarios(Scanner sc) {
        double[] salarios = new double[5];
        while (true) {
            try {
                for (int i = 0; i < salarios.length; i++) {
                    System.out.println("Digite el salario del trabajador número: " + (i + 1));
                    salarios[i] = sc.nextDouble();
                    if (salarios[i] < 0) {
                        System.out.println("El salario debe ser mayor o igual a 0.");
                        i--;
                    }
                }
                sc.nextLine(); 
                return salarios;
            } catch (InputMismatchException e) {
                System.out.println("Digite un número entero");
                sc.nextLine();
            }
        }
    }

    public static void mostrar(String[][] arreglo, double[] salarios) {
        System.out.println("-----------------------------------");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println((i + 1) + ") Nombre: " + arreglo[i][0] + " Cargo: " + arreglo[i][1] + " - Salario: " + salarios[i]);
        }
    }

    public static int seleccion(Scanner sc) {
        System.out.println("------------------------------------");
        System.out.println("Digite 1 para subir el salario a un trabajador.");
        System.out.println("Digite 2 para añadir a un nuevo trabajador.");
        System.out.println("Digite 0 para salir.");
        while (true) {
            try {
                int seleccion = sc.nextInt();
                if (seleccion >= 0 && seleccion <= 2) {
                    return seleccion;
                } else {
                    System.out.println("Digite el número de la opción a elegir.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite un número entero del 0 al 2");
                sc.nextLine();
            }
        }
    }

    public static String[][] aumentoTrabajadores(String[][] arreglo, Scanner sc) {
        String[][] temp1 = new String[arreglo.length + 1][2];
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                temp1[i][j] = arreglo[i][j];
            }
        }
        sc.nextLine(); 
        System.out.println("Digite el nuevo trabajador: ");
        temp1[arreglo.length][0] = sc.nextLine();
        System.out.println("Digite el cargo del trabajador: ");
        temp1[arreglo.length][1] = sc.nextLine();
        return temp1;
    }

    public static double[] aumentoSalario(double[] arreglo2, Scanner sc) {
        double[] temp2 = new double[arreglo2.length + 1];
        for (int o = 0; o < arreglo2.length; o++) {
            temp2[o] = arreglo2[o];
        }
        while (true) {
            try {
                System.out.println("Digite el salario del nuevo trabajador: ");
                temp2[arreglo2.length] = sc.nextDouble();
                if (temp2[arreglo2.length] >= 0) {
                    return temp2;
                } else {
                    System.out.println("Digite un número positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite un salario entero.");
                sc.nextLine();
            }
        }
    }

    public static double[] aumento(Scanner sc, double[] salarios) {
        while (true) {
            try {
                System.out.println("Digite el número del trabajador: ");
                int opcion = sc.nextInt();
                if (opcion >= 1 && opcion <= salarios.length) {
                    if (salarios[opcion - 1] >= 0 && salarios[opcion - 1] <= 1000) {
                        salarios[opcion - 1] += salarios[opcion - 1] * 0.30; 
                        break;
                    } else {
                        System.out.println("No se le puede aumentar más su salario.");
                        break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite un número de trabajador válido");
                sc.nextLine();
            }
        }
        return salarios;
    }
}
