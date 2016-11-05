package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Algorithms {
    public int findMaxChainUnits(String fileInput, String fileOutput) throws IOException {
        String line = readString(fileInput);
        String[] strArray = line.split("0+");
        int maxCount = -1;
        int cellNum = -1;
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].length() > 0) {
                maxCount = strArray[i].length();
                cellNum = i;
            }
        }
        if (maxCount > 0) {
            writeString(strArray[cellNum], fileOutput);
        }
        return cellNum;
    }

    public List<Integer> allIntFactorsNumber(int num) {
        int temp = (int) Math.sqrt(num);
        List numList = new ArrayList();
        for (int i = 1; i <= temp; i++) {
            System.out.println(i);
            if (num % i == 0) {
                numList.add(i);
                if (i != num / i) {
                    numList.add(num / i);
                }
            }
        }
        return numList;
    }

    private String readString(String fileName){
        File file = new File(fileName);
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
            }finally {
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private void writeString(String line, String fileName) {
        File file = new File(fileName);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file.getAbsoluteFile());
            pw.print(line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }
    }
}
