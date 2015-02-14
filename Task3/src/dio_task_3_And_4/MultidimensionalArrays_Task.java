package dio_task_3_And_4;

public class MultidimensionalArrays_Task {
    public static void main(String[] args) {
        double d [][] = {{3.1,3,3},{3,3,3},{3,3}};

        sum_And_Max(d);
    }
    public static void sum_And_Max(double [][] d){
        double sum = 0;
        int count = 0;
        for(int i = 0; i<d.length; i++){
            for(int j = 0; j<d[i].length; j++){
                sum+=d[i][j];
                count++;
            }
        }
        System.out.println("Общая сумма элементов = " + sum);
        System.out.println("Среднее значение = " + (sum/count));
    }
}
