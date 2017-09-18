package ru.itis.inform.Build;

public class OneField {
    private String oneRequired;
    private String two;
    private String three;

    public OneField(String oneRequired) {
        this.oneRequired = oneRequired;
    }

    public OneField() {
    }

    public Builder setAnotherFields() {
        return new Builder();
    }

    public class Builder {
        private Builder() {
        }


        public Builder setTwo(String two) {
            OneField.this.two = two;
            return this;
        }

        public Builder setThree(String three) {
            OneField.this.three = three;
            return this;
        }

        public OneField build() {
            return OneField.this;
        }
    }

    public String getOneRequired() {
        return oneRequired;
    }

    public void setOneRequired(String oneRequired) {
        this.oneRequired = oneRequired;
    }
}
