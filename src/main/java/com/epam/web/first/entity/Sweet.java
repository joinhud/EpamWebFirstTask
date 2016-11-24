package com.epam.web.first.entity;


import com.epam.web.first.type.SweetType;

public class Sweet extends Candy {
    private SweetType type;
    private SweetIngredients ingredients;

    public Sweet() {
        ingredients = new SweetIngredients();
    }

    public Sweet(String name, double energy, Value value, String production, SweetType type, SweetIngredients ingredients) {
        super(name, energy, value, production);
        this.type = type;
        this.ingredients = ingredients;
    }

    public class SweetIngredients {
        private double water;
        private double sugar;
        private double fructose;
        private double vanilla;

        public SweetIngredients() {
            water = 0;
            sugar = 0;
            fructose = 0;
            vanilla = 0;
        }

        public SweetIngredients(double water, double sugar, double fructose, double vanilla) {
            this.water = water;
            this.sugar = sugar;
            this.fructose = fructose;
            this.vanilla = vanilla;
        }

        public double getWater() {
            return water;
        }

        public void setWater(double water) {
            this.water = water;
        }

        public double getSugar() {
            return sugar;
        }

        public void setSugar(double sugar) {
            this.sugar = sugar;
        }

        public double getFructose() {
            return fructose;
        }

        public void setFructose(double fructose) {
            this.fructose = fructose;
        }

        public double getVanilla() {
            return vanilla;
        }

        public void setVanilla(double vanilla) {
            this.vanilla = vanilla;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SweetIngredients that = (SweetIngredients) o;

            if (Double.compare(that.water, water) != 0) return false;
            if (Double.compare(that.sugar, sugar) != 0) return false;
            if (Double.compare(that.fructose, fructose) != 0) return false;
            return Double.compare(that.vanilla, vanilla) == 0;

        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            temp = Double.doubleToLongBits(water);
            result = (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(sugar);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(fructose);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(vanilla);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }

        @Override
        public String toString() {
            return '[' +
                    "water=" + water + "ml." +
                    ", sugar=" + sugar + "mg." +
                    ", fructose=" + fructose + "mg." +
                    ", vanilla=" + vanilla + "mg." +
                    ']';
        }
    }

    public SweetType getType() {
        return type;
    }

    public void setType(SweetType type) {
        this.type = type;
    }

    public SweetIngredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(SweetIngredients ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Sweet sweet = (Sweet) o;

        if (type != sweet.type) return false;
        return ingredients.equals(sweet.ingredients);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + ingredients.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Sweet{" +
                "name=" + getName() +
                "energy=" + getEnergy() +
                "value=" + getValue() +
                "production=" + getProduction() +
                "type=" + type +
                ", ingredients=" + ingredients +
                '}';
    }
}
