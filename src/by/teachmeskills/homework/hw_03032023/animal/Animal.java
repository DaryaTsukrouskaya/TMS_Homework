package by.teachmeskills.homework.hw_03032023.animal;

import static by.teachmeskills.homework.hw_03032023.animal.Dop.animal;

public abstract class Animal {
    protected String picture;
    protected String food;
    protected int hunger;
    protected Boundaries boundaries;
    protected Location location;

    public Animal(String picture, String food, int hunger, Boundaries boundaries, Location location) {
        this.picture = picture;
        this.food = food;
        this.hunger = hunger;
        this.boundaries = boundaries;
        this.location = location;
    }

    protected static class Boundaries {
        private int width;
        private int height;

        public Boundaries(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        @Override
        public String toString() {
            return "Boundaries{" +
                    "width=" + width +
                    ", height=" + height +
                    '}';
        }
    }

    protected static class Location {
        private int x;
        private int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    protected abstract void makeNoise();

    protected abstract void eat();

    protected void sleep() {
        System.out.println("The animal is sleeping....");
    }

    protected void roam() {
        System.out.println("The animal is roaming....");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "picture='" + picture + '\'' +
                ", food='" + food + '\'' +
                ", hunger=" + hunger +
                ", boundaries=" + boundaries +
                ", location=" + location +
                '}';
    }

    static void getInfo(String pic) {
        for (int i = 0; i < animal.length; i++) {
            if (animal[i].picture.equals(pic)) {
                System.out.println(animal[i].toString());
                return;
            }
        }
    }
}
