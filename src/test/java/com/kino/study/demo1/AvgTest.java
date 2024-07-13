package com.kino.study.demo1;

import com.kino.study.factory.demo1.statistical.AvgStatistical;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author kino
 * @date 2024/6/24 23:22
 */
public class AvgTest {
    @Test
    public void test() {
        AvgStatistical avg = new AvgStatistical();
        Assertions.assertEquals(2, avg.calculation(2.0));
        Assertions.assertEquals(3, avg.calculation(4.0));
        Assertions.assertEquals(4.666666666666667, avg.calculation(8.0));
    }
}
