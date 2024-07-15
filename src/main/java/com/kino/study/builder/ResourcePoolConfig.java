package com.kino.study.builder;


import org.apache.commons.lang.StringUtils;

/**
 * 构建者模式
 * @author kino
 * @date 2024/7/15 17:29
 */
public class ResourcePoolConfig {
    private static final int DEFAULT_MAX_TOTAL = 8;
    private static final int DEFAULT_MAX_IDLE = 8;
    private static final int DEFAULT_MIN_IDLE = 0;

    private String name;
    private int maxTotal = DEFAULT_MAX_TOTAL;
    private int maxIdle = DEFAULT_MAX_IDLE;
    private int minIdle = DEFAULT_MIN_IDLE;

    private ResourcePoolConfig(Builder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    public static class Builder {
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;

        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        private boolean isMaxTotalSet = false;
        private boolean isMaxIdleSet = false;
        private boolean isMinIdleSet = false;

        // 创建对象并校验参数
        public ResourcePoolConfig builder() {
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("name is null or empty");
            }
            if (isMaxTotalSet || isMaxIdleSet || isMinIdleSet) {
                if (!isMaxTotalSet || !isMaxIdleSet || !isMinIdleSet) {
                    throw new IllegalArgumentException("maxTotal, maxIdle, and minIdle must all be set if any of them are set");
                }
            }
            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException("maxIdle > maxTotal");
            }
            if (minIdle > maxTotal || minIdle > maxIdle) {
                throw new IllegalArgumentException("minIdle > maxTotal");
            }
            return new ResourcePoolConfig(this);
        }

        public Builder withName(String name) {
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("name is null or empty");
            }
            this.name = name;
            return this;
        }

        public Builder withMaxTotal(int maxTotal) {
            if (maxTotal <= 0) {
                throw new IllegalArgumentException("maxTotal is negative");
            }
            this.maxTotal = maxTotal;
            this.isMaxTotalSet = true;
            return this;
        }

        public Builder withMaxIdle(int maxIdle) {
            if (maxIdle <= 0) {
                throw new IllegalArgumentException("maxIdle is negative");
            }
            this.maxIdle = maxIdle;
            this.isMaxIdleSet = true;
            return this;
        }

        public Builder withMinIdle(int minIdle) {
            if (minIdle <= 0) {
                throw new IllegalArgumentException("minIdle is negative");
            }
            this.minIdle = minIdle;
            this.isMinIdleSet = true;
            return this;
        }
    }

    // public ResourcePoolConfig() {
    // }
    //
    // /**
    //  * 用构造器初始化对象
    //  *   目前看起来很正常, 但是如果需要设置的参数过多, 就会让调用者搞错顺序容易填错, 所以转用 set 方法
    //  * @param name
    //  * @param maxTotal
    //  * @param maxIdle
    //  * @param minIdle
    //  */
    // public ResourcePoolConfig(String name, Integer maxTotal, Integer maxIdle, Integer minIdle) {
    //     if (StringUtils.isBlank(name)) {
    //         throw new IllegalArgumentException("name is null or empty");
    //     }
    //     this.name = name;
    //     if (maxTotal < 0) {
    //         throw new IllegalArgumentException("maxTotal is negative");
    //     }
    //     this.maxTotal = maxTotal;
    //     if (maxIdle < 0) {
    //         throw new IllegalArgumentException("maxIdle is negative");
    //     }
    //     this.maxIdle = maxIdle;
    //     if (minIdle < 0) {
    //         throw new IllegalArgumentException("minIdle is negative");
    //     }
    //     this.minIdle = minIdle;
    // }
    //
    // /**
    //  * 这里也会有问题, 如果在初始化对象时:
    //  *   ResourcePoolConfig config = new ResourcePoolConfig
    //  *   config.setMaxTotal(10);
    //  * 没有setName, 那 name 就不再是必填了.当然也可以把必填项放到构造器中, 但是:
    //  *   1. 如果必填项过多, 又会出现第一个问题
    //  *   2. 假设配置项之间有一定的依赖关系，比如，如果用户设置了 maxTotal、maxIdle、minIdle 其中一个，就必须显式地设置另外两个
    //  */
    // public void setName(String name) {
    //     if (StringUtils.isBlank(name)) {
    //         throw new IllegalArgumentException("name is null or empty");
    //     }
    //     this.name = name;
    // }
    // public void setMaxTotal(int maxTotal) {
    //     if (maxTotal < 0) {
    //         throw new IllegalArgumentException("maxTotal is negative");
    //     }
    //     this.maxTotal = maxTotal;
    // }
    // public void setMaxIdle(int maxIdle) {
    //     if (maxIdle < 0) {
    //         throw new IllegalArgumentException("maxIdle is negative");
    //     }
    //     this.maxIdle = maxIdle;
    // }
    // public void setMinIdle(int minIdle) {
    //     if (minIdle < 0) {
    //         throw new IllegalArgumentException("minIdle is negative");
    //     }
    //     this.minIdle = minIdle;
    // }
}

class Test {
    public static void main(String[] args) {
        ResourcePoolConfig config = new ResourcePoolConfig.Builder()
                .withName("redis")
                .withMaxIdle(6)
                // .withMaxTotal(6)
                .withMinIdle(5)
                .builder();
    }
}