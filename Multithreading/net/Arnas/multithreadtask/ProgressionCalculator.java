package net.Arnas.multithreadtask;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class ProgressionCalculator implements Runnable{
    private BigDecimal countFrom;
    private int calcTimes;
    private BigDecimal result = BigDecimal.ZERO;
    private final int scale;

    /**
     *
     * @param countFrom number from which the arithmetic iterations will start
     * @param calcTimes how many progression arithmetic iterations will be calculated
     * @param scale count of digits after decimal point
     */
    public ProgressionCalculator(BigDecimal countFrom, int calcTimes, int scale){
        this.countFrom = countFrom;
        this.calcTimes = calcTimes;
        this.scale = scale;
    }

    @Override
    public void run() {
        BigDecimal four = new BigDecimal(BigInteger.ONE);
        four = four.add(BigDecimal.ONE);
        four = four.add(BigDecimal.ONE);
        four = four.add(BigDecimal.ONE);

        for (int i = 0; i != calcTimes; i++) {
            if (i % 2 == 0) {
                result = result.add(four.divide(countFrom, scale, RoundingMode.HALF_UP));
            } else {
                result = result.subtract(four.divide(countFrom, scale, RoundingMode.HALF_UP));
            }
            countFrom = countFrom.add(BigDecimal.ONE);
            countFrom = countFrom.add(BigDecimal.ONE);
        }
    }

    /**
     *
     * @return BigDecimal value of calculated progression
     */
    public BigDecimal getResult(){
        return result;
    }

}
