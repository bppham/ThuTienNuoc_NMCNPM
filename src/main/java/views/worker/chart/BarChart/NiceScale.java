package views.worker.chart.BarChart;

public class NiceScale {

    private double min;
    private double max;
    private int maxTicks = 10;
    private double tickSpacing;
    private double range;
    private double niceMin;
    private double niceMax;

    public NiceScale(final double MIN, final double MAX) {
        min = MIN;
        max = MAX;
        calculate();
    }

    private void calculate() {
        range = niceNum(max - min, false);
        tickSpacing = niceNum(range / (maxTicks - 1), true);
        niceMin = Math.floor(min / tickSpacing) * tickSpacing;
        niceMax = Math.ceil(max / tickSpacing) * tickSpacing;
    }

    
    /**
     * Lấy giới hạn tốt nhất cho biểu đồ
     * @param RANGE
     * @param ROUND
     * @return 
     */
    private double niceNum(final double RANGE, final boolean ROUND) {
        double exponent;     // Số mũ - số lượng số 0
        double fraction;     // fractional part of RANGE
        double niceFraction; // nice, rounded fraction

        exponent = Math.floor(Math.log10(RANGE)); //Tính số mũ để lấy base là 10, 100, 1000...
        fraction = RANGE / Math.pow(10, exponent); //Chia range với base để xác định hệ số để lấy giới hạn trên
        //Ví dụ RANGE 7235 => exponent = 3 => fraction = 7.235 (7235/10^3)

        if (ROUND) {
            if (fraction < 1.5) {
                niceFraction = 1;
            } else if (fraction < 3) {
                niceFraction = 2;
            } else if (fraction < 7) {
                niceFraction = 5;
            } else {
                niceFraction = 10;
            }
        } else {
            if (fraction <= 1) {
                niceFraction = 1;
            } else if (fraction <= 2) {
                niceFraction = 2;
            } else if (fraction <= 5) {
                niceFraction = 5;
            } else {
                niceFraction = 10;
            }
        }
        return niceFraction * Math.pow(10, exponent);
    }

    public void setMinMax(final double MIN, final double MAX) {
        min = MIN;
        max = MAX;
        calculate();
    }

    public void setMaxTicks(final int MAX_TICKS) {
        maxTicks = MAX_TICKS;
        calculate();
    }

    public double getTickSpacing() {
        return tickSpacing;
    }

    public double getNiceMin() {
        return niceMin;
    }

    public double getNiceMax() {
        return niceMax;
    }

    public int getMaxTicks() {
        return maxTicks;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
        calculate();
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
        calculate();
    }

}
