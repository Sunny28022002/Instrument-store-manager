package com.company;

import java.util.Scanner;

public class menu {

    public static int menuMain(){
        Scanner sc = new Scanner(System.in);
        int chon;

        System.out.println("---------------- Chọn đối tượng quản lý ----------------\n" +
                "1. Khách hàng.\n" +
                "2. Nhân Viên.\n" +
                "3. Hàng hóa.\n" +
                "4. Bill.\n" +
                "5. Thoát.\n");
        System.out.print("Chọn thao tác: ");

        chon = Integer.parseInt(sc.nextLine());
        System.out.println();
        return chon;
    }

    public static int menuCustomer(){
        Scanner sc = new Scanner(System.in);
        int chon;

        System.out.println("---------------- Chọn thao tác cần thực hiện ----------------\n" +
                "1. Thông tin khách hàng.\n" +
                "2. Thông tin chi tiết của khách hàng.\n" +
                "3. Thêm khách hàng.\n" +
                "4. Chỉnh sửa thông tin.\n" +
                "5. Quit.\n");
        System.out.print("Chọn thao tác: ");


        chon = Integer.parseInt(sc.nextLine());
        System.out.println();
        return chon;
    }

    public static int menuStaff(){
        Scanner sc = new Scanner(System.in);
        int chon;

        System.out.println("---------------- Chọn thao tác cần thực hiện ----------------\n" +
                "1. Thông tin nhân viên.\n" +
                "2. Thông tin chi tiết của nhân viên.\n" +
                "3. Thêm nhân viên.\n" +
                "4. Chỉnh sửa thông tin.\n" +
                "5. Quit.\n");
        System.out.print("Chọn thao tác: ");

        chon = Integer.parseInt(sc.nextLine());
        System.out.println();
        return chon;
    }

    public static int menuGoods(){
        Scanner sc = new Scanner(System.in);
        int chon;

        System.out.println("---------------- Chọn thao tác cần thực hiện ----------------\n" +
                "1. Thông tin hàng hóa.\n" +
                "2. Thông tin chi tiết của hàng hóa.\n" +
                "3. Thêm hàng hóa.\n" +
                "4. Nhập hàng hóa.\n" +
                "5. Quit.\n");
        System.out.print("Chọn thao tác: ");

        chon = Integer.parseInt(sc.nextLine());
        System.out.println();
        return chon;
    }
}
