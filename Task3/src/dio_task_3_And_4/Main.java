package dio_task_3_And_4;

import java.util.Arrays;

public class Main {

    public Pojo[] merge(Pojo[] leftArray, Pojo[] rightArray) {
        int count = 0;
        leftArray = checkAndSort(leftArray);
        rightArray = checkAndSort(rightArray);

        Pojo[] res = Arrays.copyOf(leftArray, leftArray.length + rightArray.length);
        //local code review (vtegza): replace with for each  @ 2/15/2015
        for (int i = 0; i < rightArray.length; i++) {
            if (Arrays.binarySearch(leftArray, rightArray[i]) < 0) {
                res[leftArray.length + count] = rightArray[i];
                count++;
            }
        }
        Pojo[] resultArray = Arrays.copyOf(res, leftArray.length + count);
        return resultArray;
    }

    public Pojo[] innerUnion(Pojo[] leftArray, Pojo[] rightArray) {
        int count = 0;
        leftArray = checkAndSort(leftArray);
        rightArray = checkAndSort(rightArray);

        Pojo [] res = new Pojo[leftArray.length + rightArray.length];
        Arrays.fill(res,new Pojo("ZZZZZ",1));
        //local code review (vtegza): replace with for each @ 2/15/2015
        for (int i = 0; i < rightArray.length; i++) {
            if (Arrays.binarySearch(leftArray, rightArray[i]) >= 0) {
                res[leftArray.length + count] = rightArray[i];
                count++;
            }
        }
        Arrays.sort(res);
        Pojo[] resultArray = Arrays.copyOf(res, count);

        return resultArray;
    }

    public Pojo[] outerUnion(Pojo[] leftArray, Pojo[] rightArray) {
        int count = 0;
        leftArray = checkAndSort(leftArray);
        rightArray = checkAndSort(rightArray);

        Pojo [] res = new Pojo[leftArray.length + rightArray.length];
        Arrays.fill(res,new Pojo("ZZZZZ",1));

        //local code review (vtegza): replace with foreach @ 2/15/2015
        for (int i = 0; i < rightArray.length; i++) {
            if (Arrays.binarySearch(leftArray, rightArray[i]) < 0) {
                res[count] = rightArray[i];
                count++;
            }
        }
        for (int i = 0; i < leftArray.length; i++) {
            if (Arrays.binarySearch(rightArray, leftArray[i]) < 0) {
                res[count] = leftArray[i];
                count++;
            }
        }
        Arrays.sort(res);
        Pojo[] resultArray = Arrays.copyOf(res, count);

        return resultArray;
    }

    //local code review (vtegza): use readable names for variables/parameters @ 2/15/2015
    public Pojo [] checkAndSort(Pojo p[]){
        if(p.length == 0){
            Arrays.sort(p);
        }
        else if(p[0] == null && p[p.length/2] == null
                && p[p.length-1] == null){
            p = new Pojo[0];
        }
        else{
            Arrays.sort(p);}
        return p;
    }
}

