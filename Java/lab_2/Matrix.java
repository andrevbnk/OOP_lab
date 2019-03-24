package lab_2;

    class Matrix{
        double[][] transp(double[][] mass){
            double[][] let = new double[mass.length][mass.length];
            for(int i = 0;i<mass.length;i++){
                for(int j = 0;j<mass.length;j++){
                    let[i][j] = mass[j][i];
                }
            }
            return let;
        }

        double[][] creat_mat(int size){
            double[][] mat = new double[size][size];
            for(int i = 0;i<size;i++){
                for(int j = 0;j<size;j++){
                    mat[i][j] = Math.random() * 10;
                }
            }
            return mat;
        }


        double average(double[][] matrix){
            double sum = 0;
            for(int i = 0; i<matrix.length;i++){
                for(int j = 0; j<matrix.length;j++){
                    sum+=matrix[i][j];
                }
            }
            return sum/(matrix.length*matrix.length);
        }


        void out_matrix(double[][] x){
            for(int i = 0;i<x.length;i++){
                System.out.print("\n");
                for(int j = 0;j<x.length;j++){
                    System.out.print("  "+ x[i][j]);
                }
            }
            System.out.print("\n");
        }
    }

