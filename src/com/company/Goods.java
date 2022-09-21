package com.company;

import java.io.Serializable;
import java.util.Scanner;

public class Goods implements Action, Serializable {
    private String Name;
    private String ID;
    private String Material;
    int Price;
    private int YearOfManufacture; // năm sản xuất
    int RemainingProduct; // sản phẩm còn lại
    private int Import; // sản phẩm nhập vào


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String material) {
        Material = material;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getYearOfManufacture() {
        return YearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        YearOfManufacture = yearOfManufacture;
    }

    public int getRemainingProduct() {
        return RemainingProduct;
    }

    public void setRemainingProduct(int remainingProduct) {
        RemainingProduct = remainingProduct;
    }

    public int getImport() {
        return Import;
    }

    public void setImport(int anImport) {
        Import = anImport;
    }

    public Goods(String name, String ID, String material, int price, int yearOfManufacture, int remainingProduct, int anImport) {
        Name = name;
        this.ID = ID;
        Material = material;
        Price = price;
        YearOfManufacture = yearOfManufacture;
        RemainingProduct = remainingProduct;
        Import = anImport;
    }


    @Override
    public void input() {
        this.setRemainingProduct(0);
        this.setImport(0);
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập ID: ");
        String ID = sc.nextLine();
        this.setID(ID);

        System.out.print("Nhập tên: ");
        String Name = sc.nextLine();
        this.setName(Name);

        System.out.print("Nhập chất liệu: ");
        String Material = sc.nextLine();
        this.setMaterial(Material);

        System.out.print("Nhập giá: ");
        int price = Integer.parseInt(sc.nextLine());
        this.setPrice(price);

        System.out.print("Nhập năm sản xuất: ");
        int Year = Integer.parseInt(sc.nextLine());
        this.setYearOfManufacture(Year);

        System.out.print("Nhập số lượng sản phẩm nhập vào: ");
        int Import = Integer.parseInt(sc.nextLine());
        this.setImport(Import);
        this.setRemainingProduct(getImport() + getRemainingProduct());

    }

    @Override
    public void output(){
    }

    public void output1(){
        System.out.println("-- "+ getName()+" -- "+ getMaterial() +" --");
    }

    public void output2(){
        System.out.println("-- "+ getID() +" -- "+ getName() +" --");
    }

    public void output3(){
        System.out.println("-- "+ getID() +" -- "+ getName() +" -- "+ getMaterial() +" -- "+ getPrice() +" -- "+ getRemainingProduct() +" -- "+ getYearOfManufacture() +" --");
    }
}
