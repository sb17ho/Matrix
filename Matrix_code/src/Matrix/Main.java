package Matrix;

import java.util.Scanner;

public class Main {

    private double[][] array1;
    private double[][] array2;
    Methods methods;

    public Main() {
        array1 = new double[3][3];
        array2 = new double[3][3];
        methods = new Methods();

        //Scanner scanner = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Select Methods\n");
            System.out.println(" 1) Determinant\n 2) Addition \n 3) Subtract \n 4) Multiply By Constant " +
                    "\n 5) Matrix Multiply \n 6) Transpose\n 7) Trace\n Press 0 to exit the program");
            int selection = input.nextInt();

            switch (selection) {
                case 0: {
                    System.exit(0);
                    break;
                }
                case 1: {
                    System.out.println("Enter the Elements of First Matrix");
                    for (int i = 0; i < array1.length; i++) {
                        for (int j = 0; j < array1[i].length; j++) {
                            array1[i][j] = input.nextInt();
                        }
                    }
                    System.out.println(methods.determinant(array1));
                    break;
                }
                case 2: {
                    System.out.println("Enter the Elements of First Matrix");
                    for (int i = 0; i < array1.length; i++) {
                        for (int j = 0; j < array1[i].length; j++) {
                            array1[i][j] = input.nextInt();
                        }
                    }

                    System.out.println("Enter the Elements of the second matrix");
                    for (int i = 0; i < array2.length; i++) {
                        for (int j = 0; j < array2[i].length; j++) {
                            array2[i][j] = input.nextInt();
                        }
                    }

                    double[][] result = methods.addition(array1, array2);
                    for (int i = 0; i < result.length; i++) {
                        for (int j = 0; j < result[0].length; j++) {
                            System.out.print(result[i][j] + " ");
                        }
                        System.out.println();
                    }

                    System.out.println();
                    break;
                }
                case 3: {
                    System.out.println("Enter the Elements of First Matrix");
                    for (int i = 0; i < array1.length; i++) {
                        for (int j = 0; j < array1[i].length; j++) {
                            array1[i][j] = input.nextInt();
                        }
                    }

                    System.out.println("Enter the Elements of the second matrix");
                    for (int i = 0; i < array2.length; i++) {
                        for (int j = 0; j < array2[i].length; j++) {
                            array2[i][j] = input.nextInt();
                        }
                    }

                    double[][] result = methods.subtract(array1, array2);
                    for (int i = 0; i < result.length; i++) {
                        for (int j = 0; j < result[0].length; j++) {
                            System.out.print(result[i][j] + " ");
                        }
                        System.out.println();
                    }

                    System.out.println();
                    break;
                }
                case 4: {
                    System.out.println("Enter the Elements of First Matrix");
                    for (int i = 0; i < array1.length; i++) {
                        for (int j = 0; j < array1[i].length; j++) {
                            array1[i][j] = input.nextInt();
                        }
                    }

                    System.out.println("Enter the constant you want to multiply with:\n");

                    int constant = input.nextInt();

                    double[][] result = methods.multiplyByConstant(array1, constant);
                    for (int i = 0; i < result.length; i++) {
                        for (int j = 0; j < result[0].length; j++) {
                            System.out.print(result[i][j] + " ");
                        }
                        System.out.println();
                    }

                    System.out.println();
                    break;
                }
                case 5: {
                    System.out.println("Enter the Elements of First Matrix");
                    for (int i = 0; i < array1.length; i++) {
                        for (int j = 0; j < array1[i].length; j++) {
                            array1[i][j] = input.nextInt();
                        }
                    }

                    System.out.println("Enter the Elements of the second matrix");
                    for (int i = 0; i < array2.length; i++) {
                        for (int j = 0; j < array2[i].length; j++) {
                            array2[i][j] = input.nextInt();
                        }
                    }

                    double[][] result = methods.multiplyMatrix(array1, array2);
                    for (int i = 0; i < result.length; i++) {
                        for (int j = 0; j < result[0].length; j++) {
                            System.out.print(result[i][j] + " ");
                        }
                        System.out.println();
                    }

                    System.out.println();
                    break;
                }
                case 6: {
                    System.out.println("Enter the Elements of First Matrix");
                    for (int i = 0; i < array1.length; i++) {
                        for (int j = 0; j < array1[i].length; j++) {
                            array1[i][j] = input.nextInt();
                        }
                    }

                    double[][] result = methods.transpose(array1);
                    for (int i = 0; i < result.length; i++) {
                        for (int j = 0; j < result[0].length; j++) {
                            System.out.print(result[i][j] + " ");
                        }
                        System.out.println();
                    }

                    System.out.println();
                    break;
                }
                case 7: {
                    System.out.println("Enter the Elements of First Matrix");
                    for (int i = 0; i < array1.length; i++) {
                        for (int j = 0; j < array1[i].length; j++) {
                            array1[i][j] = input.nextInt();
                        }
                    }

                    System.out.println(methods.trace(array1));

                    System.out.println();
                    break;
                }
            }

        }
    }

    public static void main(String[] args) {
        Main n = new Main();
    }
}
