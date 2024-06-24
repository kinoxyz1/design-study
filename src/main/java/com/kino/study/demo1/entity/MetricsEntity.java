package com.kino.study.demo1.entity;

/**
 * 计数器的实体类
 * @author kino
 * @date 2024/6/24 22:57
 */
public class MetricsEntity {
    // 响应时间的最大值
    private Double max;
    // 最小值
    private Double mix;
    // 和
    private Double sum;
    // 平均值
    private Double avg;
    // 百分位值
    private Double percentile;
    // 接口调用次数
    private Integer count;
    // 频率
    private Double tps;
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

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getMix() {
        return mix;
    }

    public void setMix(Double mix) {
        this.mix = mix;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public Double getPercentile() {
        return percentile;
    }

    public void setPercentile(Double percentile) {
        this.percentile = percentile;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getTps() {
        return tps;
    }

    public void setTps(Double tps) {
        this.tps = tps;
    }
}

