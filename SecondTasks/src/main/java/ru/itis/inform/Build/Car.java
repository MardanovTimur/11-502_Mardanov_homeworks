package ru.itis.inform.Build;

// New realization

public class Car {
    //About car
    private String mark;
    private String version;
    private double engineCapacity;

    //Number
    private int reqion;
    private int number;
    private char[] three = new char[3];

    //Technicans
    private boolean isAutomatic = true;

    public Car(String mark, String version, double engineCapacity, int reqion, int number, char[] three, boolean isAutomatic) {
        this.mark = mark;
        this.version = version;
        this.engineCapacity = engineCapacity;
        this.reqion = reqion;
        this.number = number;
        this.three = three;
        this.isAutomatic = isAutomatic;
    }

    public Car() {
    }



    public Builder newBuilder() {
        return new Car().new Builder();
    }

    //Builder
    public class Builder {

        private Builder() {
        }

        public Builder setMark(String mark) {
            Car.this.mark = mark;
            return this;
        }

        public Builder setVersion(String version) {
            Car.this.version = version;
            return this;
        }

        public Builder setEngineCapacity(double engineCapacity) {
            Car.this.engineCapacity = engineCapacity;
            return this;
        }

        public Builder setReqion(int reqion) {
            Car.this.reqion = reqion;
            return this;
        }

        public Builder setNumber(int number) {
            Car.this.number = number;
            return this;
        }

        public Builder setThree(char[] three) {
            Car.this.three = three;
            return this;
        }

        public Builder setAutomatic(boolean automatic) {
            Car.this.isAutomatic = automatic;
            return this;
        }

        public Car build() {
            return Car.this;
        }


    }


    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public void setReqion(int reqion) {
        this.reqion = reqion;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setThree(char[] three) {
        this.three = three;
    }

    public void setAutomatic(boolean automatic) {
        isAutomatic = automatic;
    }

    public String getMark() {
        return mark;
    }

    public String getVersion() {
        return version;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public int getReqion() {
        return reqion;
    }

    public int getNumber() {
        return number;
    }

    public char[] getThree() {
        return three;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }
}
