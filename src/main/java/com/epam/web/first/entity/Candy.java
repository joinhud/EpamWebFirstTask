package com.epam.web.first.entity;

public abstract class Candy {
    private String name;
    private double energy;
    private Value value;
    private String production;

    public Candy() {
        name = "no name";
        value = new Value();
        production = "none";
    }

    public Candy(String name, double energy, Value value, String production) {
        this.name = name;
        this.energy = energy;
        this.value = value;
        this.production = production;
    }

    public static class Value {
        private double proteins;
        private double fats;
        private double carbohydrates;

        public Value() {
        }

        public Value(double proteins, double fats, double carbohydrates) {
            this.proteins = proteins;
            this.fats = fats;
            this.carbohydrates = carbohydrates;
        }

        public double getProteins() {
            return proteins;
        }

        public void setProteins(double proteins) {
            this.proteins = proteins;
        }

        public double getFats() {
            return fats;
        }

        public void setFats(double fats) {
            this.fats = fats;
        }

        public double getCarbohydrates() {
            return carbohydrates;
        }

        public void setCarbohydrates(double carbohydrates) {
            this.carbohydrates = carbohydrates;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Value value = (Value) o;

            if (Double.compare(value.proteins, proteins) != 0) return false;
            if (Double.compare(value.fats, fats) != 0) return false;
            return Double.compare(value.carbohydrates, carbohydrates) == 0;

        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            temp = Double.doubleToLongBits(proteins);
            result = (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(fats);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(carbohydrates);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }

        @Override
        public String toString() {
            return '[' +
                    "proteins=" + proteins + "gr." +
                    ", fats=" + fats + "gr." +
                    ", carbohydrates=" + carbohydrates + "gr." +
                    ']';
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candy candy = (Candy) o;

        if (Double.compare(candy.energy, energy) != 0) return false;
        if (!name.equals(candy.name)) return false;
        if (!value.equals(candy.value)) return false;
        return production.equals(candy.production);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(energy);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + value.hashCode();
        result = 31 * result + production.hashCode();
        return result;
    }
}
