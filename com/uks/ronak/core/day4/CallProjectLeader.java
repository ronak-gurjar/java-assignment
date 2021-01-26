package com.uks.ronak.core.day4;

public class CallProjectLeader {
    public static void main(String[] args) {
        ProjectLeader projectLeaderOne = new ProjectLeader("ronak", "gurjar", 123456);
        ProjectLeader projectLeaderTwo = new ProjectLeader("simba", "joshi", 123455);
        projectLeaderOne.print();
        projectLeaderTwo.print();
    }
}
