package com.epam.web.first.entity;


import com.epam.web.first.type.ChocolateColor;

public class Chocolate extends Candy {
    private ChocolateColor color;
    private ChocolateIngredients ingredients;

    public Chocolate() {
        ingredients = new ChocolateIngredients();
    }

    public Chocolate(String name, double energy, Value value, String production, ChocolateColor color, ChocolateIngredients ingredients) {
        super(name, energy, value, production);
        this.color = color;
        this.ingredients = ingredients;
    }

    public class ChocolateIngredients {
        private double cocoaMass;
        private double sugar;
        private double cocoaButter;

        public ChocolateIngredients() {
        }

        public ChocolateIngredients(double cocoaMass, double sugar, double cocoaButter) {
            this.cocoaMass = cocoaMass;
            this.sugar = sugar;
            this.cocoaButter = cocoaButter;
        }

        public double getCocoaMass() {
            return cocoaMass;
        }

        public void setCocoaMass(double cocoaMass) {
            this.cocoaMass = cocoaMass;
        }

        public double getSugar() {
            return sugar;
        }

        public void setSugar(double sugar) {
            this.sugar = sugar;
        }

        public double getCocoaButter() {
            return cocoaButter;
        }

        public void setCocoaButter(double cocoaButter) {
            this.cocoaButter = cocoaButter;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ChocolateIngredients that = (ChocolateIngredients) o;

            if (Double.compare(that.cocoaMass, cocoaMass) != 0) return false;
            if (Double.compare(that.sugar, sugar) != 0) return false;
            return Double.compare(that.cocoaButter, cocoaButter) == 0;

        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            temp = Double.doubleToLongBits(cocoaMass);
            result = (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(sugar);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(cocoaButter);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }

        @Override
        public String toString() {
            return '[' +
                    "cocoaMass=" + cocoaMass + "mg." +
                    ", sugar=" + sugar + "mg." +
                    ", cocoaButter=" + cocoaButter + "mg." +
                    ']';
        }
    }

    public ChocolateColor getColor() {
        return color;
    }

    public void setColor(ChocolateColor color) {
        this.color = color;
    }

    public ChocolateIngredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(ChocolateIngredients ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Chocolate chocolate = (Chocolate) o;

        if (color != chocolate.color) return false;
        return ingredients.equals(chocolate.ingredients);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + ingredients.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Chocolate{" +
                "name=" + getName() +
                "energy=" + getEnergy() + "kkal." +
                "value=" + getValue() +
                "production=" + getProduction() +
                "color=" + color +
                ", ingredients=" + ingredients +
                '}';
    }
}
