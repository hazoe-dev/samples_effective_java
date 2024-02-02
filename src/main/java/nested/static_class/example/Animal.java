package nested.static_class.example;

class Animal {
    private String name;
    // inner class
    class Reptile {
        public void displayInfo() {
            System.out.println("I am a reptile. " + Animal.this.getClass());
            System.out.println("Name:" + name);
        }
    }

    // static class
    static class Mammal {
        public void displayInfo() {

            System.out.println("I am a mammal.");
            System.out.println("Name:" );
        }
    }
}

class Main {
    public static void main(String[] args) {
        // object creation of the outer class
        Animal animal = new Animal();

        // object creation of the non-static class
        Animal.Reptile reptile = animal.new Reptile();
        reptile.displayInfo();

        // object creation of the static nested class
        Animal.Mammal mammal = new Animal.Mammal();
        mammal.displayInfo();

    }
}
