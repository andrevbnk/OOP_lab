package lab_2;

public class Main {
    public static void main(String[] args){

        Matrix test = new Matrix();
        final int n = 3;
        double[][] matrix = test.creat_mat(n);
        test.out_matrix(matrix);

        double[][] let = test.transp(matrix);
        test.out_matrix(let);

        double average_matrix = test.average(let);
        System.out.println("\n"+ average_matrix);

    }
}
