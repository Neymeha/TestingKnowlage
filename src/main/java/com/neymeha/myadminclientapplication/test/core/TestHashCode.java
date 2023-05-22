package com.neymeha.myadminclientapplication.test.core;

import java.util.Objects;

public class TestHashCode {
    int i=1;
    char a='a';

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestHashCode that)) return false;
        return i == that.i && a == that.a;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, a);
    }

    public static void main(String[] args) {
        TestHashCode test = new TestHashCode();
        System.out.println(test.hashCode());
    }
}
