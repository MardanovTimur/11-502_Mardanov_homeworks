package ru.itis.inform;


public class Auto {
    private String name;
    private String year;

    public Auto() {
    }

    public Auto(String name, String year) {
        this.name = name;
        this.year = year;
    }


    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
