package lab_1;

class Loop_sum {
        double sum(int a,int b){
            double sum = 0;
            for(int i = 1; i <= a;i++){
                for(int j = 1; j <= b;j++){
                    sum+= ((double)i/j)/i;
                }
            }
            return sum;
        }

}
