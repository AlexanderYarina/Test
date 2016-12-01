import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindSumNumbersPow {
    public static void main(String[] args) {
        List<Integer> resList = new LinkedList();
        int res = 0;
        int pow = 4;
        int iEnd = (int)Math.pow(10, pow);
        int iStart = iEnd / 10;
        for (int i = iStart; i < iEnd; i++) {

            int[] iToArray = getArrayNumbers(i, pow);
            int sumNum = sumArrayNumbers(iToArray, pow);

            if(sumNum >= iStart && !resList.contains(sumNum) &&
                    arrayEquals(iToArray, getArrayNumbers(sumNum, pow), pow)) {
                resList.add(sumNum);
            }
        }
        for (Integer integer : resList) {
            res = res + integer;
        }
        System.out.println(res);
    }

    private static int[] getArrayNumbers(int num, int pow) {
        int[] array = new int[pow];
        for (int i = 0; i < array.length; i++) {
            array[i] = num % 10;
            num = num / 10;
        }
        return array;
    }

    private static int sumArrayNumbers(int[] array, int pow){
        int sumNum = 0;
        for (int i = 0; i < pow; i++) {
            sumNum = sumNum + (int)Math.pow(array[i], pow);
        }
        return sumNum;
    }

    private static boolean arrayEquals(int[] array1, int[] array2, int pow){
        boolean res = false;
        int[] firstArray = Arrays.copyOf(array1, pow);
        int[] secondArray = Arrays.copyOf(array2, pow);
        Arrays.sort(firstArray);
        Arrays.sort(secondArray);
        for (int i = 0; i < pow; i++) {
            if(firstArray[i] == secondArray[i]){
                res = true;
            }else{
                return false;
            }
        }
        return res;
    }
}
