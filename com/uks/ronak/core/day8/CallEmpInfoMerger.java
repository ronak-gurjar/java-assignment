package com.uks.ronak.core.day8;

public class CallEmpInfoMerger extends Thread {
    public static void main(String[] args) throws InterruptedException {
        EmpInfoMerger nameFileRead = new EmpInfoMerger("src\\com\\uks\\ronak\\core\\day8\\name.txt", "read");

        EmpInfoMerger addFileRead = new EmpInfoMerger("src\\com\\uks\\ronak\\core\\day8\\address.txt", "read");

        EmpInfoMerger newFileWrite = new EmpInfoMerger("src\\com\\uks\\ronak\\core\\day8\\newFileName.txt", "write");

        nameFileRead.start();
        addFileRead.start();
        sleep(2000);
        newFileWrite.start();
    }
}
