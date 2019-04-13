public class Car {
    String model;
    int engineVolume;
    int yearManufacture;
    String bodyType;
    String color;
    int mileage;
    int weight;
    private boolean isOpen = false;
    private boolean isStart = false;

    public Car(){
        this("unknown model",0,0,"unknown type","unknown color",0,0);
    }

    public Car(String model, int engineVolume, int yearManufacture, String bodyType, String color, int mileage, int weight) {
        this.model = model;
        this.engineVolume = engineVolume;
        this.yearManufacture = yearManufacture;
        this.bodyType = bodyType;
        this.color = color;
        this.mileage = mileage;
        this.weight = weight;
    }

    public void startEngine(){
        if(isStart == false){
            System.out.println(model+" engine starting");
            isStart = true;
        } else System.out.println(model+" engine has already started");
    }

    public void stopEngine(){
        if(isStart == true){
            System.out.println("Turn off the engine of "+model);
            isStart = false;
        }else System.out.println(model+" engine has already stopped ");
    }

    public void openWindow(){
        if(isOpen == false){
            System.out.println(model+" window is opening");
            isOpen = true;
        } else System.out.println(model+" window has already opened");
    }
    public void closeWindow(){
        if(isOpen == true){
            System.out.println(model+" window is closing");
            isOpen = false;
        } else System.out.println(model+" window has already closed");
    }

    public void drive(int distance){
        System.out.println(model+" is driving");
        mileage = mileage+distance;
    }
}
