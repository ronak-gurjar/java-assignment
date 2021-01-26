package com.uks.ronak.core.day6;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CompanyInfo {
    public void translate(String language, String country) {
        Locale locale = new Locale(language, country);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("com/uks/ronak/core/day6/Message", locale);
        String[] str = new String[5];
        // this id for printing key of bundle
        Enumeration<String> s = resourceBundle.getKeys();
        while (s.hasMoreElements()) {
            //System.out.println(s.nextElement());// for printing key
            System.out.println(resourceBundle.getString(s.nextElement()));// printing value
        }
      /*
      // if we want to print particular key value
      str[0] = resourceBundle.getString("Name");
        str[1] = resourceBundle.getString("Address");
        str[2] = resourceBundle.getString("HeadOffice");
        str[3] = resourceBundle.getString("OfficeAddressOfBranch");*/
    }

    public static void main(String[] args) {
        CompanyInfo companyInfo = new CompanyInfo();
        Scanner scanner = new Scanner(System.in);
      /*  System.out.println("enter language");
        String language=scanner.nextLine();
        System.out.println("enter country");
        String country=scanner.nextLine();*/
        companyInfo.translate("en", "US");
    }
}