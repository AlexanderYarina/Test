package utils;

import java.io.*;

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

    private String readString(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        fr.close();
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
