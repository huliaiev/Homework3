package com.kiev.prog;

public class Flat {

    @Id
    private int id;

    String district;
    String adress;
    double square;
    int numberRooms;
    int cost;

    public Flat(String district, String adress, double square, int numberRooms, int cost) {
        this.district = district;
        this.adress = adress;
        this.square = square;
        this.numberRooms = numberRooms;
        this.cost = cost;
    }

    public Flat() {

    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getNumberRooms() {
        return numberRooms;
    }

    public void setNumberRooms(int numberRooms) {
        this.numberRooms = numberRooms;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "district='" + district + '\'' +
                ", adress='" + adress + '\'' +
                ", square=" + square +
                ", numberRooms=" + numberRooms +
                ", cost=" + cost +
                '}';
    }
}
