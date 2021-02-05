package com.uks.ronak.core.day1;

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
