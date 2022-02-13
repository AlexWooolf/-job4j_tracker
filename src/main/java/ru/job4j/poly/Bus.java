package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("едем в соседнее село на дискотеку");

    }

    @Override
    public void passengers(int count) {
        int passangers = count;
    }

    @Override
    public double refuel(double count) {
        double price = 1.5;
        return price * count;
    }
}
