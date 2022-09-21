package com.company;

import java.io.Serializable;
import java.util.Scanner;

public class People implements Action, Serializable {
    private String name;
    private String ID;
    String Address;
    String PhoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public People(String name, String ID, String address, String phoneNumber) {
        this.name = name;
        this.ID = ID;
        Address = address;
        PhoneNumber = phoneNumber;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập ID: ");
        String ID = sc.nextLine();
        this.setID(ID);

        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        this.setName(name);

        System.out.print("Nhập địa chỉ: ");
        String address = sc.nextLine();
        this.setAddress(address);

        System.out.print("Nhập số điện thoại: ");
        String PhoneNumber = sc.nextLine();
        this.setPhoneNumber(PhoneNumber);
    }

    @Override
    public void output() {
    }
}

class Customer extends People implements Action, Serializable{
    private String CustomerType;
    private float CumulativePoints;

    public String getCustomerType() {
        return CustomerType;
    }

    public void setCustomerType(String customerType) {
        CustomerType = customerType;
    }

    public float getCumulativePoints() {
        return CumulativePoints;
    }

    public void setCumulativePoints(float cumulativePoints) {
        CumulativePoints = cumulativePoints;
    }

    public Customer(String name, String ID, String address, String phoneNumber, String customerType, int cumulativePoints) {
        super(name, ID, address, phoneNumber);
        CustomerType = customerType;
        CumulativePoints = cumulativePoints;
    }


    public void output1(){
        System.out.println("-- "+ getName()+" -- "+ getCustomerType() +" -- "+ getCumulativePoints() +" --");
    }

    public void output2(){
        System.out.println("-- "+ getID() +" -- "+ getName() +" --");
    }

    public void output3(){
        System.out.println("-- "+ getID() +" -- "+ getName() +" -- "+ getCustomerType() +" -- "+ getCumulativePoints() +" -- "+ getPhoneNumber() +" -- "+ getAddress() +" --");
    }
}

class Staff extends People implements Action, Serializable{
    private String Timeserving;
    private String WorkingMode;
    private int Salary;

    public String getTimeserving() {
        return Timeserving;
    }

    public void setTimeserving(String timeserving) {
        Timeserving = timeserving;
    }

    public String getWorkingMode() {
        return WorkingMode;
    }

    public void setWorkingMode(String workingMode) {
        WorkingMode = workingMode;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public Staff(String name, String ID, String address, String phoneNumber, String timeserving, String workingMode, int salary) {
        super(name, ID, address, phoneNumber);
        Timeserving = timeserving;
        WorkingMode = workingMode;
        Salary = salary;
    }

    @Override
    public void input() {
        super.input();
        int i = 0;
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập khung giờ làm việc: ");
        String Timeserving = sc.nextLine();
        this.setTimeserving(Timeserving);

        do{
            System.out.print("Nhập chể độ làm việc(Full time/ Part time): ");
            String WorkingMode = sc.nextLine();
            this.setWorkingMode(WorkingMode);
            if (this.getWorkingMode().equals("Full time") || this.getWorkingMode().equals("Part time"))
                i = 1;
            else {
                System.out.println("Vui lòng nhập đúng mẫu (Full time/Part time)");
            }
        } while (i == 0);

        if(this.getWorkingMode().equals("Full time")){
            this.setSalary(30);
        } else this.setSalary(20);
    }


    public void output1(){
        System.out.println("-- "+ getName()+" --");
    }

    public void output2(){
        System.out.println("-- "+ getID() +" -- "+ getName() +" --");
    }

    public void output3(){
        System.out.println("-- "+ getID() +" -- "+ getName() +" -- "+ getWorkingMode() +" -- "+ getSalary() +" -- "+ getTimeserving() +" -- "+ getPhoneNumber() +" -- "+ getAddress() +" --");
    }
}