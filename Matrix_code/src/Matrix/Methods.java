package Matrix;

public class Methods {

    public double determinant(double[][] array) {
        if (array.length == 1) {
            return array[0][0];
        }
        //if the size of the array is 1 then return 1st element

        double det = 0;
        int sign = 1;

        double[][] temp = new double[array.length - 1][array.length - 1];

        if (array.length == 2) {
            return array[0][0] * array[1][1] - array[0][1] * array[1][0];
        } else {
            for (int col = 0; col < array.length; col++) {
                cofactor(0, col, temp, array);
                det += sign * array[0][col] * determinant(temp);
                sign *= -1;     //to change the sign
            }
        }

        return det;
    }

    public void cofactor(int row, int col, double[][] temp, double[][] array) {
        int r1 = 0, c1 = 0;
        for (int i = 0; i < array.length; i++) {        //rows
            for (int j = 0; j < array[0].length; j++) {    //columns
                if (i != row && j != col) {
                    temp[r1][c1] = array[i][j];
                    c1 += 1;
                    //when the col reaches the size == array - 1 then change the col to 0 and move to next row
                    if (c1 == array.length - 1) {
                        c1 = 0;
                        r1 += 1;
                    }
                }
            }
        }
    }

    public double[][] addition(double[][] arr1, double[][] arr2) {
        double[][] result = new double[arr1.length][arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                result[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return result;
    }

    public double[][] subtract(double[][] arr1, double[][] arr2) {
        double[][] result = new double[arr1.length][arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                result[i][j] = arr1[i][j] - arr2[i][j];
            }
        }

        return result;
    }

    public double[][] multiplyByConstant(double[][] arr1, int constant) {
        double[][] result = new double[arr1.length][arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                result[i][j] = constant * arr1[i][j];
            }
        }

        return result;
    }

    public double[][] multiplyMatrix(double[][] arr1, double[][] arr2) {
        double[][] result = new double[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return result;
    }

    public double[][] transpose(double[][] arr1) {
        double[][] result = new double[arr1.length][arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                result[i][j] = arr1[j][i];
            }
        }
        return result;
    }

    public double trace(double[][] arr1) {
        double sum = 0;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (i == j) {
                    sum += arr1[i][j];
                }
            }
        }
        return sum;
    }

}
