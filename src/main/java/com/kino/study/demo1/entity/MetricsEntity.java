package com.kino.study.demo1.entity;

/**
 * 计数器的实体类
 * @author kino
 * @date 2024/6/24 22:57
 */
public class MetricsEntity {
    // 响应时间的最大值
    private double max;
    // 最小值
    private double mix;
    // 和
    private double sum;
    // 平均值
    private double avg;
    // 百分位值
    private double percentile;
    // 接口调用次数
    private Integer count;
    // 频率
    private double tps;
    // 可扩展...

    @Override
    public String toString() {
        return "MetricsEntity{" +
                "max=" + max +
                ", mix=" + mix +
                ", sum=" + sum +
                ", avg=" + avg +
                ", percentile=" + percentile +
                ", count=" + count +
                ", tps=" + tps +
                '}';
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMix() {
        return mix;
    }

    public void setMix(double mix) {
        this.mix = mix;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public double getPercentile() {
        return percentile;
    }

    public void setPercentile(double percentile) {
        this.percentile = percentile;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public double getTps() {
        return tps;
    }

    public void setTps(double tps) {
        this.tps = tps;
    }
}

