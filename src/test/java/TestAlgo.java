import utils.Algorithms;

import java.io.IOException;

/**
 * Created by Alex on 04.11.2016.
 */
public class TestAlgo {

    public static final String INPUT = "D:/Development/GitHub/Softheme/input.txt";
    public static final String OUTUT = "D:/Development/GitHub/Softheme/output.txt";

    public static void main(String[] args) throws IOException {
        Algorithms algo = new Algorithms();
        int res = algo.findMaxChainUnits(INPUT, OUTUT);
        System.out.println(res);
    }
}
