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

public class AccessMod {
    public static void main(String[] args) {
        TestAccessMod testAccessMod = new TestAccessMod();

        // access string
        testAccessMod.setName1("ronak");
        System.out.println("name=" + testAccessMod.getName());

        // printing property
        System.out.println("printing property through method");
        testAccessMod.printProperties();

        // access property
        System.out.println("printing property via object");
        System.out.println(testAccessMod.i);
        System.out.println(testAccessMod.l);

        // String s1 object is not accessible because it is private
        // system.out.println(ob.s1);

        System.out.println(testAccessMod.d);
        System.out.println(testAccessMod.b);
        System.out.println(testAccessMod.f);

    }
}
