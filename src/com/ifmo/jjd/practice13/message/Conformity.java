package com.ifmo.jjd.practice13.message;

public class Conformity<T> {
    public int count;
    public T value;

    public Conformity(T value) {
        this.value = value;
        this.count = 0;
    }

    public Conformity(T value, int count) {
        this.value = value;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Conformity{" +
                "count=" + count +
                ", value=" + value +
                '}';
    }
}
