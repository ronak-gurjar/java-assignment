package com.uks.ronak.core.day3;

class ShowSystemProperties {
    //user name
    public void uName() {
        System.out.println(System.getProperty("user.name"));
    }

    // os name
    public void oName() {
        System.out.println(System.getProperty("os.name"));
    }

    // user directory
    public void uDir() {
        System.out.println(System.getProperty("user.dir"));
    }
}
