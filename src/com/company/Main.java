package com.company;

import java.io.Serializable;
import java.util.Scanner;

interface Action{
    void input() ;
    void output();
}

public class Main {

    public static void Bill(int demC, int demS, int demG, Customer[] ListC, Staff[] ListS, Goods[] ListG){
        Scanner sc = new Scanner(System.in);

        String chonC,chonS, chonG, nameC = null, nameS = null, nameG = null;
        int QuantityPurchased;
        int TotalAmount;
        int j = 0;

        for (int i = 0 ; i < demC ; ++i)
            ListC[i].output2();
        System.out.print("Nhập ID khách hàng: ");
        chonC = sc.nextLine();

        for (int i = 0 ; i < demC ; ++i)
            if (ListC[i].getID().equals(chonC)) {
                nameC = ListC[i].getName();
                j=i;
            }

        for (int i = 0 ; i < demS ; ++i)
            ListS[i].output2();
        System.out.print("Nhập ID nhân viên: ");
        chonS = sc.nextLine();

        for (int i = 0 ; i < demS ; ++i)
            if (ListS[i].getID().equals(chonS)) nameS = ListS[i].getName();

        for (int i = 0 ; i < demG ; ++i)
            ListG[i].output2();
        System.out.print("Nhập ID hàng hóa: ");
        chonG = sc.nextLine();

        for (int i = 0 ; i < demG ; ++i)
            if (ListG[i].getID().equals(chonG)) nameG = ListG[i].getName();

        for (int i = 0 ; i < demG ; ++i)
            if(ListG[i].getRemainingProduct() == 0 ){
                System.out.println("Không còn hàng hóa!!!");
            } else{
                System.out.print("Nhập số lượng cần mua: ");
                QuantityPurchased = Integer.parseInt(sc.nextLine());
                if(ListG[i].getRemainingProduct() < QuantityPurchased ) {
                    System.out.println("Không đủ hàng hóa!!!");
                }
                else {
                    ListG[i].setRemainingProduct(ListG[i].getRemainingProduct() - QuantityPurchased);
                    TotalAmount = QuantityPurchased * ListG[i].getPrice();
                    ListC[j].setCumulativePoints((ListC[j].getCumulativePoints() + TotalAmount / 1000000));
                    if (ListC[j].getCumulativePoints() >= 10)
                        ListC[j].setCustomerType("Bạc");
                    else if (ListC[j].getCumulativePoints() >= 100 )
                        ListC[j].setCustomerType("Vàng");
                    else if (ListC[j].getCumulativePoints() >= 1000 )
                        ListC[j].setCustomerType("Kim cương");
                    else if (ListC[j].getCumulativePoints() >= 10000 )
                        ListC[j].setCustomerType("VIP");

                    System.out.println("---------BILL---------\n"+
                            "-- ID Khách hàng -- Tên khách hàng -- ID Nhân viên -- Tên Nhân viên -- ID Hàng hóa -- Tên Hàng hóa -- Chất liệu -- Sô lượng -- Giá -- Tổng tiền --");
                    System.out.println("-- "+ chonC +" -- "+ nameC +" -- "+ chonS +" -- "+ nameS +" -- "+ chonG +" -- "+ nameG +" -- "+ ListG[i].getMaterial() +" -- "+ QuantityPurchased +" -- "+ ListG[i].getPrice() + " -- "+ TotalAmount + " --");
                }
            }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chon = 0;
        int demC = 0;
        int demG = 0;
        int demS = 0;
        String chonID;

        Customer[] ListC = new Customer[20];
        Goods[] ListG = new Goods[20];
        Staff[] ListS = new Staff[20];

        menu menu = null;
        do {
            chon = menu.menuMain();
            switch (chon){
                case 1:
                    do{
                        chon = menu.menuCustomer();
                        switch (chon){
                            case 1:
                                System.out.println("----- Danh sách thông tin khách hàng -----\n\n" +
                                        "-- Tên -- Loại khách -- Điểm tích lũy --");
                                for (int i = 0 ; i < demC ; i++){
                                    ListC[i].output1();
                                }
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("----- Danh sách chi tiết thông tin khách hàng -----\n\n" +
                                        "-- ID -- Tên -- Loại khách -- Điểm tích lũy -- Số điện thoại -- Địa chỉ --");
                                for (int i = 0 ; i < demC ; i++){
                                    ListC[i].output3();
                                }
                                System.out.println();
                                break;
                            case 3:
                                ListC[demC] = new Customer("a","a","a","a","Đồng",0);
                                ListC[demC].input();
                                demC++;
                                System.out.println("Hoàn thành nhập dữ liệu");
                                System.out.println();
                                break;
                            case 4:
                                System.out.println("Danh sách khách hàng: \n");
                                for (int i = 0 ; i < demC ; i++){
                                    ListC[i].output2();
                                }
                                System.out.print("\nNhập ID khách hàng cẩn sửa thông tin: ");
                                chonID = sc.nextLine();
                                System.out.print("\nChọn thông tin cần sửa\n"+
                                        "1. Địa chỉ.\n" +
                                        "2. Số điện thoại.\n"+
                                        "3. Thoát.\n"+
                                        "Chọn mục cần sửa: ");
                                chon = Integer.parseInt(sc.nextLine());
                                for (int i = 0 ; i < demC ; i++){
                                    if (ListC[i].getID().equals(chonID)){
                                        switch (chon) {
                                            case 1:
                                                System.out.print("Nhập địa chỉ mới: ");
                                                ListC[i].setAddress(sc.nextLine());
                                                break;
                                            case 2:
                                                System.out.print("Nhập số điện thoại mới: ");
                                                ListC[i].setPhoneNumber(sc.nextLine());
                                                break;
                                            case 3:
                                                System.out.println("Chỉnh sửa thông tin hoàn tất!!!");
                                                break;
                                        }
                                        break;
                                    }
                                }
                                chon = 0;
                                System.out.println();
                                break;
                            case 5:
                                break;
                        }
                    }while (chon != 5);
                    chon = 0;
                    break;
                case 2:
                    do{
                        chon = menu.menuStaff();
                        switch (chon){
                            case 1:
                                System.out.println("----- Danh sách thông tin nhân viên -----\n\n" +
                                        "-- Tên --");
                                for (int i = 0 ; i < demS ; i++){
                                    ListS[i].output1();
                                }
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("----- Danh sách chi tiết thông tin nhân viên -----\n\n" +
                                        "-- ID -- Tên -- Chế độ làm việc -- Lương -- Thời gian làm việc -- Số điện thoại -- Địa chỉ --");
                                for (int i = 0 ; i < demS ; i++){
                                    ListS[i].output3();
                                }
                                System.out.println();
                                break;
                            case 3:
                                ListS[demS] = new Staff("a","a","a","a","a","a",1);
                                ListS[demS].input();
                                demS++;
                                System.out.println("Hoàn thành nhập dữ liệu");
                                System.out.println();
                                break;
                            case 4:
                                System.out.println("Danh sách nhân viên: \n");
                                for (int i = 0 ; i < demS ; i++){
                                    ListS[i].output2();
                                }
                                System.out.print("\nNhập ID nhân viên cẩn sửa thông tin: ");
                                chonID = sc.nextLine();
                                System.out.print("\nChọn thông tin cần sửa\n"+
                                        "1. Địa chỉ.\n" +
                                        "2. Số điện thoại.\n"+
                                        "3. Thời gian làm việc.\n" +
                                        "4. Chế độ làm việc.\n" +
                                        "5. Thoát.\n"+
                                        "Chọn mục cần sửa: ");
                                chon = Integer.parseInt(sc.nextLine());
                                for (int i = 0 ; i < demS ; i++){
                                    if (ListS[i].getID().equals(chonID)){
                                        switch (chon) {
                                            case 1:
                                                System.out.print("Nhập địa chỉ mới: ");
                                                ListS[i].setAddress(sc.nextLine());
                                                break;
                                            case 2:
                                                System.out.print("Nhập số điện thoại mới: ");
                                                ListS[i].setPhoneNumber(sc.nextLine());
                                                break;
                                            case 3:
                                                System.out.print("Nhập thời gian làm việc mới: ");
                                                ListS[i].setTimeserving(sc.nextLine());
                                                break;
                                            case 4:
                                                do{
                                                    System.out.print("Nhập chế độ làm việc mới(Full time/Part time): ");
                                                    ListS[i].setWorkingMode(sc.nextLine());
                                                    if (ListS[i].getWorkingMode().equals("Full time") || ListS[i].getWorkingMode().equals("Part time")) break;
                                                } while (true);
                                                break;
                                            case 5:
                                                System.out.println("Chỉnh sửa thông tin hoàn tất!!!");
                                                break;
                                        }
                                        break;
                                    }
                                }
                                chon = 0;
                                System.out.println();
                                break;
                            case 5:
                                break;
                        }
                    }while (chon != 5);
                    chon = 0;
                    break;
                case 3:
                    do{
                        chon = menu.menuGoods();
                        switch (chon){
                            case 1:
                                System.out.println("----- Danh sách thông tin sản phẩm -----\n\n" +
                                        "-- Tên -- Chất liệu --");
                                for (int i = 0 ; i < demG ; i++){
                                    ListG[i].output1();
                                }
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("----- Danh sách chi tiết thông tin khách hàng -----\n\n" +
                                        "-- ID -- Tên -- Chất liệu -- Giá -- Số lượng còn lại -- Năm sản xuất̉ --");
                                for (int i = 0 ; i < demG ; i++){
                                    ListG[i].output3();
                                }
                                System.out.println();
                                break;
                            case 3:
                                ListG[demG] = new Goods("a","a","a",1,1,1,1);
                                ListG[demG].input();
                                demG++;
                                System.out.println("Hoàn thành nhập dữ liệu");
                                System.out.println();
                                break;
                            case 4:
                                System.out.println("Danh sách hàng hóa: \n");
                                for (int i = 0 ; i < demG ; i++){
                                    ListG[i].output2();
                                }
                                System.out.print("\nNhập ID hàng hóa cẩn nhập: ");
                                chonID = sc.nextLine();
                                for (int i = 0 ; i < demG ; i++){
                                    if (ListG[i].getID().equals(chonID)){
                                        System.out.print("Nhập số lượng nhập vào: ");
                                        ListG[i].setRemainingProduct(ListG[i].getRemainingProduct() + Integer.parseInt(sc.nextLine()));
                                        break;
                                    }
                                }
                                chon = 0;
                                System.out.println();
                                break;
                            case 5:
                                break;
                        }
                    }while (chon != 5);
                    chon = 0;
                    break;
                case 4:
                    Bill(demC,demS,demG,ListC,ListS,ListG);
                    break;
                case 5:
                    System.out.println("Hoàn thành tra cứu!!!");
                    break;
            }
        } while (chon != 5);
    }
}
