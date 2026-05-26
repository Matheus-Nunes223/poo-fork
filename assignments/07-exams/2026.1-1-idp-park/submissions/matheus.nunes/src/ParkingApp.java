import java.util.ArrayList;
public class ParkingApp {
   abstract static class Vehicle{
   protected String plate;
   protected String brand;
   protected String model;
   public Vehicle(String plate, String brand, String model){
       this.plate = plate;
       this.brand = brand;
       this.model = model;
   }
   public String getPlate(){
       return plate;
   }

   public String getBrand(){
       return brand;
   }

   public String getModel(){
       return model;
   }

   public void setPlate(String plate){
     this.plate = plate;
   }

   public void setBrand(String brand){
       this.brand=brand;
   }

   public void setModel(String model){
       this.model=model;
   }
   public abstract double calculateParkingFee(int hours);

   public String toString(){
       return "Placa:" + plate + " - Marca:" + brand + " - Modelo" + model;
   }
   }


     static class Car extends Vehicle {

        public Car(String plate, String brand, String model) {
            super(plate, brand, model);
        }

        @Override
        public double calculateParkingFee(int hours){
            return hours * 5.00;

        }

        @Override
        public String toString(){
            return "Carro" + " - Placa:" + plate + " - Marca:" + brand + " - Modelo:" + model;
        }

    }
     static class Motorcycle extends Vehicle{
       public Motorcycle(String plate, String brand, String model){
           super(plate, brand, model);
       }
       @Override
        public double calculateParkingFee(int hours){
           return hours * 3.00;
       }

        @Override
        public String toString(){
            return "Moto" + " - Placa:" + plate + " - Marca:" + brand + " - Modelo:" + model;
        }
      }
      static class Truck extends Vehicle{
       public Truck(String plate, String brand, String model){
           super(plate, brand, model);
       }
          @Override
          public double calculateParkingFee(int hours){
              return hours * 10.00;
          }

          @Override
          public String toString(){
              return "Caminhão" + " - Placa:" + plate + " - Marca:" + brand + " - Modelo:" + model;
          }
        }
        public static void main(String[] args){

       ArrayList<Vehicle> Vehicles = new ArrayList<Vehicle>();

       Vehicles.add(new Car("POO-2026", "Peugeot", "2008"));
       Vehicles.add(new Motorcycle("ABJ-2199", "Yamaha", "CROSSER 150 S ABS"));
       Vehicles.add(new Truck("LMN-3245", "Volvo", "Renova Lenarge"));

       for(Vehicle v: Vehicles){
           System.out.println(v.toString());
           System.out.println("Valor a pagar por 4h: R$ " + String.format("%.2f", v.calculateParkingFee(4)));

       }
    }
}