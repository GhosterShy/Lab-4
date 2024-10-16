interface Transport
{
    public void Move();
    public void FuelUp();

}

abstract class Character
{
    private String Model;
    private int Speed;

    public Character(){}

    public Character(String model, int speed) {
        Model = model;
        Speed = speed;
    }

    public String getModel() {
        return Model;
    }

    public int getSpeed() {
        return Speed;
    }
}

class Car extends Character implements Transport{


    public Car(String model, int speed) {
        super(model, speed);
    }



    public Car(){}

    @Override
    public void Move() {
        System.out.println("Төрт дөңгелекпен жүреді");

    }

    @Override
    public void FuelUp() {
        System.out.println("Бензин және соляр майы");

    }



}


class Motocycle extends Character implements  Transport
{

    public Motocycle(String model, int speed) {
        super(model, speed);
    }

    public Motocycle(){}

    @Override
    public void Move() {
        System.out.println("Екі дөңгелекпен жүреді");

    }

    @Override
    public void FuelUp() {
        System.out.println("бензин");

    }
}


class Plane extends Character implements Transport
{

    public Plane(String model, int speed) {
        super(model, speed);
    }

    public Plane(){}

    @Override
    public void Move() {
        System.out.println("Ұшады");

    }

    @Override
    public void FuelUp() {
        System.out.println("Арнайы жасалынган топлива");

    }
}

class Velo extends Character implements Transport
{
    public Velo() {
    }

    public Velo(String model, int speed) {
        super(model, speed);
    }


    @Override
    public void Move() {
        System.out.println("Адам көмегімен жүреді ");

    }

    @Override
    public void FuelUp() {
        System.out.println("Топлива керек емес");

    }

}


interface TransportFactory
{
    public Transport CreateTrasport();

    Transport CreateTrasport(String model, int speed);
}

class CarFacrtory implements TransportFactory
{

    @Override
    public Transport CreateTrasport() {
        return new Car();
    }

    @Override
    public Transport CreateTrasport(String model, int speed) {
        return new Car();
    }
}

class  Motocyclefactory implements  TransportFactory
{

    @Override
    public Transport CreateTrasport() {
        return null;
    }

    @Override
    public Transport CreateTrasport(String model,int speed) {
        return new Motocycle(model,speed);
    }
}


class PlaneFactory implements TransportFactory
{

    @Override
    public Transport CreateTrasport() {
        return new Plane();
    }

    @Override
    public Transport CreateTrasport(String model, int speed) {
        return new Plane(model,speed);
    }
}


class  VeloFactory implements  TransportFactory
{

    @Override
    public Transport CreateTrasport() {
        return new Velo();
    }

    @Override
    public Transport CreateTrasport(String model, int speed) {
        return new Velo(model,speed);
    }
}


    
enum TransportType {
    CAR, MOTORCYCLE, PLANE, VELO;
}

public class Main {
    public static void main(String[] args) {
        TransportFactory transportFactory = new VeloFactory();
        Transport transport = transportFactory.CreateTrasport("BmW", 60);

        TransportType transportType = null;

        if (transport instanceof Car) {
            transportType = TransportType.CAR;
        } else if (transport instanceof Motocycle) {
            transportType = TransportType.MOTORCYCLE;
        } else if (transport instanceof Plane) {
            transportType = TransportType.PLANE;
        } else if (transport instanceof Velo) {
            transportType = TransportType.VELO;
        }


        switch (transportType) {
            case CAR:
                System.out.println("This is a car.");
                break;
            case MOTORCYCLE:
                System.out.println("This is a motorcycle.");
                break;
            case PLANE:
                System.out.println("This is a plane.");
                break;
            case VELO:
                System.out.println("This is a bicycle.");
                break;
            default:
                System.out.println("Unknown transport.");
                break;
        }

        transport.Move();
        transport.FuelUp();
    }
}

