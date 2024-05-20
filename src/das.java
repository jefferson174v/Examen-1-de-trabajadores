import java.util.Scanner;
import java.util.InputMismatchException;

public class das {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------------------------------------------");
        System.out.println("    Hola! Bienvenido a soluciones rapidas S.A.");
        System.out.println("    A continuacion complete lo que se le pida.");
        System.out.println("----------------------------------------------------");
        String[][] ArregloTrabajadores = trabajadores(sc);
        System.out.println("----------------------------------------------------");
        double[] ArregloSalarios = salarios(sc);
        System.out.println("----------------------------------------------------");
        mostrar(ArregloTrabajadores, ArregloSalarios);
        System.out.println("----------------------------------------------------");
        while (true) {
            int opcionMenu = opciones(sc);
            System.out.println("----------------------------------------------------");
            if (opcionMenu == 1) {
                int opcionTrabajador = opcionaumentoSalario(sc, ArregloSalarios);
                aumentoDelSalario(opcionTrabajador, ArregloSalarios);
                System.out.println("----------------------------------------------------");
                mostrar(ArregloTrabajadores, ArregloSalarios);
                System.out.println("----------------------------------------------------");
            } else if (opcionMenu == 2) {
                ArregloTrabajadores = aumnetoTrabajadorenUno(ArregloTrabajadores, sc);
                ArregloSalarios = SalarioTrabajadornuevo(ArregloSalarios, sc);
                System.out.println("----------------------------------------------------");
                mostrar(ArregloTrabajadores, ArregloSalarios);
                System.out.println("----------------------------------------------------");
            } else if (opcionMenu == 3) {
                break;
            }
        }
    }

    public static String[][] trabajadores(Scanner sc) {
        String[][] ArregloTrabajadores = new String[5][2];
        for (int i = 0; i < ArregloTrabajadores.length; i++) {
            for (int j = 0; j < ArregloTrabajadores[i].length; j++) {
                if (j == 0) {
                    System.out.println("Dijite del nombre del trabajador numero " + "(" + (i + 1) + ")");
                    ArregloTrabajadores[i][j] = sc.nextLine();
                } else if (j == 1) {
                    System.out.println("Dijite del  cargo del trabajador numero " + "(" + (i + 1) + ")");
                    ArregloTrabajadores[i][j] = sc.nextLine();
                }
            }
        }
        return ArregloTrabajadores;
    }

    public static double[] salarios(Scanner sc) {
        double[] salarios = new double[5];
        int o = 1;
        while (true) {
            try {
                for (int i = 0; i < salarios.length;) {
                    System.out.println("Dijite el salario del trabajdor " + "(" + (o) + ")");
                    salarios[i] = sc.nextInt();
                    if (salarios[i] <= -1) {
                        System.out.println("Dijite numeros positivos.");
                        i--;
                    } else {
                        o++;
                        i++;
                    }
                }
                return salarios;
            } catch (InputMismatchException e) {
                System.out.println("Dijite un numero entero");
                sc.nextLine();
            }
        }
    }

    public static void mostrar(String[][] x, double[] y) {
        for (int i = 0; i < x.length; i++) {
            System.out.println((i + 1) + ") " + "Nombre: " + x[i][0] + " Cargo: " + x[i][1] + " - Salario: " + y[i]);
        }
    }

    public static int opciones(Scanner sc) {
        System.out.println("Dijite 1 si desea aumentar el salario del trabajador.");
        System.out.println("Dijite 2 si desea agregar a otro trabajador.");
        System.out.println("Dijite 3 si desea salir.");
        System.out.println("----------------------------------------------------");
        while (true) {
            try {
                int opcion = sc.nextInt();
                if (opcion > 0) {
                    if (opcion >= 1 && opcion <= 3) {
                        return opcion;
                    } else {
                        System.out.println("Dijite un numero del 1 al 3.");
                    }
                } else {
                    System.out.println("Dijite un numero positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Dijite un numero entero.");
                sc.nextLine();

            }
        }
    }

    public static int opcionaumentoSalario(Scanner sc, double[] x) {
        System.out.println("Dijite el numero del trabajador a umentar el salario.");
        while (true) {
            try {
                int opcionTrabajador = sc.nextInt();
                if (opcionTrabajador >= 1) {
                    if ((opcionTrabajador >= 1 && opcionTrabajador <= x.length)) {
                        return opcionTrabajador;
                    } else {
                        System.out.println("Dijite un trabajador valido, de 1 al " + x.length);
                    }
                } else {
                    System.out.println("Dijite un numero positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Dijite un numero!");
                sc.nextLine();
            }
        }
    }

    public static void aumentoDelSalario(int x, double[] y) {
        if (y[x - 1] < 1000) {
            y[x - 1] = (y[x - 1] * 1.3);
        } else {
            System.out.println("Su salario no puede ser aumentado al ya tener mas de mil. " + y[x - 1]);
        }
    }

    public static String[][] aumnetoTrabajadorenUno(String[][] x, Scanner sc) {
        String[][] temp = new String[x.length + 1][2];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                temp[i][j] = x[i][j];
            }
        }
        sc.nextLine();
        System.out.println("Dijite el nombre del nuevo trabajador: ");
        temp[x.length][0] = sc.nextLine();
        System.out.println("Dijite el cargo el nuevo trabajador: ");
        temp[x.length][1] = sc.nextLine();
        x = temp;
        return x;
    }

    public static double[] SalarioTrabajadornuevo(double[] x, Scanner sc) {
        double[] temp = new double[x.length + 1];
        for (int i = 0; i < x.length; i++) {
            temp[i] = x[i];
        }
        while (true) {
            try {
                System.out.println("Dijite el salario del nuevo trabajador.");
                temp[x.length] = sc.nextDouble();
                if (temp[x.length] >= 0) {
                    return temp;
                } else if (temp[x.length] < 0) {
                    System.out.println("Dijite un numero positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Dijite un numero!");
                sc.nextLine();
            }
        }
    }
}