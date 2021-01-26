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
        IWork tl1 = new TLEmployee("ronak", "gurjar");
        IWork pl1 = new PLEmployee("simba", "joshi");

        IReport tl2 = new TLEmployee("sandip", "gor");
        IReport pl2 = new PLEmployee("chirag", "sharma");
        // calling interfaces method
        tl1.doWork();
        tl2.reportToSenior();
        pl1.doWork();
        pl2.reportToSenior();
    }
}
