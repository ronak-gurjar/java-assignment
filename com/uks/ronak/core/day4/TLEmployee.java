package com.uks.ronak.core.day4;

class TLEmployee extends PLEmployee {

    TLEmployee(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void doWork() {
        System.out.println("do work in TLEmployee");
    }

    @Override
    public void assignTaskToJunior() {
        System.out.println("assign task to junior in TLEmployee");
    }

    @Override
    public void collectReportFromJunior() {
        System.out.println("collect report from junior in TLEmployee");
    }

    @Override
    public void reportToSenior() {
        System.out.println("report to senior in TLEmployee");
    }

    public static void main(String[] args) {

        // creating a reference of iWork and iReport and assign to
        // PLEmployee and TlEmployee
        TLEmployee tlEmployee = new TLEmployee("ronak", "gurajr");
        IWork tl1 = tlEmployee;
        IWork pl1 = tlEmployee;

        PLEmployee plEmployee = new PLEmployee("chirah", "soni");
        IReport tl2 = plEmployee;
        IReport pl2 = plEmployee;
        // calling interfaces method
        tl1.doWork();
        tl2.reportToSenior();
        pl1.doWork();
        pl2.reportToSenior();
    }
}
