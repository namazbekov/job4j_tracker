package ru.job4j.stream;

public class Car {
    private String brand;
    private String model;
    private String color;
    private int year;
    private int power;
    private int engineVolume;
    private int tankVolume;

      static class CarInitialization {
          private String brand;
          private String model;
          private String color;
          private int year;
          private int power;
          private int engineVolume;
          private int tankVolume;


          CarInitialization carBrand(String brand) {
              this.brand = brand;
              return this;
          }

          CarInitialization carModel(String model) {
              this.model = model;
              return this;
          }

          CarInitialization carColor(String color) {
              this.color = color;
              return this;
          }

          CarInitialization carYear(int year) {
              this.year = year;
              return this;
          }

          CarInitialization carPower(int power) {
              this.power = power;
              return this;
          }

          CarInitialization carEngineVolume(int engineVolume) {
              this.engineVolume = engineVolume;
              return this;
          }

          CarInitialization carTankVolume(int tankVolume) {
              this.tankVolume = tankVolume;
              return this;
          }

          Car build() {
              Car car = new Car();
              car.brand = brand;
              car.model = model;
              car.color = color;
              car.year = year;
              car.power = power;
              car.engineVolume = engineVolume;
              car.tankVolume = tankVolume;
              return car;
          }
      }

          @Override
          public String toString() {
              return "CarInitialization {" +
                      "brand='" + brand + '\'' +
                      ", model='" + model + '\'' +
                      ", color='" + color + '\'' +
                      ", year=" + year +
                      ", power=" + power +
                      ", engineVolume=" + engineVolume +
                      ", tankVolume=" + tankVolume +
                      '}';
          }

          public static void main(String[] args) {
              Car carAudi = new CarInitialization()
                      .carBrand ("Audi")
                      .carModel("4")
                      .carColor("white")
                      .carYear(2010)
                      .carPower(170)
                      .carEngineVolume(2)
                      .carTankVolume(60)
                      .build();
              System.out.println(carAudi);
          }

}
