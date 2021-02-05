package com.uks.ronak.core.day1;

class TestAccessMod {

    int i = 1;
    char ch = 'c';
    boolean b = true;
    protected float f = 10.0f;
    protected double d = 100.0d;
    protected long l = 10000;
    private String name;

    // getter and setter method
    public String getName() {
        return name;
    }

    public void setName1(String name1) {
        this.name = name;
    }

    public void printProperties() {

        System.out.println("i=" + i);
        System.out.println("ch=" + ch);
        System.out.println("b=" + b);
        System.out.println("f=" + f);
        System.out.println("d=" + d);
        System.out.println("l=" + l);
    }
}
