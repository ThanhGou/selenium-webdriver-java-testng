package JavaOOP;

public class CarOOP {

    //Nested class:
    public class Head{
    }
    //Create an interface
    public interface ICar{
    }

    //Create an enum
    enum BrowserList{
        CHROME, FIREFOX, IE;
    }

    //INSTANCE VARIABLES
    private String carCompany;
    private String carType;
    private String fuelType;
    private Float mileAge;
    private Double carPrice;

    protected CarOOP(String carCompany, String carType, String fuelType, Float mileAge, Double carPrice) {
        this.carCompany = carCompany;
        this.carType = carType;
        this.fuelType = fuelType;
        this.mileAge = mileAge;
        this.carPrice = carPrice;
    }

    protected String getCarCompany() {
        return carCompany;
    }

    protected void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
    }

    protected String getCarType() {
        return carType;
    }

    protected void setCarType(String carType) {
        this.carType = carType;
    }

    protected String getFuelType() {
        return fuelType;
    }

    protected void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    protected Float getMileAge() {
        return mileAge;
    }

    protected void setMileAge(Float mileAge) {
        this.mileAge = mileAge;
    }

    protected Double getCarPrice() {
        return carPrice;
    }

    protected void setCarPrice(Double carPrice) {
        this.carPrice = carPrice;
    }

    protected void showCarInfo(){
        System.out.println("Car company: " + getCarCompany());
        System.out.println("Car type: " + getCarType());
        System.out.println("Fuel type: " + getFuelType());
        System.out.println("Mile age: " + getMileAge());
        System.out.println("Car price: " + getCarPrice());
    }
    public static void  main(String[] args){
        //Tạo object và gán dữ liệu
        CarOOP honda = new CarOOP("Honda", "City", "Petrol", 150f, 50000d);

    }
}
