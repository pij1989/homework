public class Main {
    public static void main(String[] args) {
        Car audi = new Car ("A6",3200,2015,"sedan","black",150_000,2200);
        Car bmw = new Car ("X5",3000,2012,"allroad","black",100_000,3000);
        Car ford =new Car ("Mondeo",2000,2005,"sedan","blue",250_000,2300);

        audi.startEngine();
        audi.drive(25);
        System.out.println("Mileage "+audi.mileage);
        audi.stopEngine();

        bmw.startEngine();
        bmw.startEngine();
        bmw.openWindow();
        bmw.drive(5);
        System.out.println("Mileage "+bmw.mileage);
        bmw.closeWindow();
        bmw.stopEngine();

        ford.startEngine();
        ford.drive(30);
        System.out.println("Mileage "+ford.mileage);
        ford.closeWindow();
        ford.stopEngine();
    }
}
