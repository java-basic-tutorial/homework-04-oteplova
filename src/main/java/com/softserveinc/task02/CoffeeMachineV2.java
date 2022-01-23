package com.softserveinc.task02;

import com.softserveinc.task01.CoffeeMachineV1;

public class CoffeeMachineV2 extends CoffeeMachineV1 {
    protected final int milkReservoirCapacity;
    private int milk; // represent how much milk now is the Coffee Machine

    public CoffeeMachineV2(int coffeeBeanStorageCapacity, int waterReservoirCapacity, int wasteCoffeeBeanCapacity, int milkReservoirCapacity) {
        super(coffeeBeanStorageCapacity, waterReservoirCapacity, wasteCoffeeBeanCapacity);
        this.milkReservoirCapacity = milkReservoirCapacity;
    }

    public void addMilk(int milk) {
        this.milk = Math.min(milk + this.milk, milkReservoirCapacity);
    }

    public int getMilk() {
        return milk;
    }

    public boolean makeCoffeeWithMilk(int milk) {
        boolean Espresso = makeEspresso();
        if (Espresso) {
            if (milk > this.milk) {
                System.err.println("Not enough milk");
                return false;
            }
            this.milk -= milk;
            return true;
        }
        return false;
    }

    public boolean makeCappuccino() {
        return makeCoffeeWithMilk(85);
    }

    public boolean makeLatte() {
        return makeCoffeeWithMilk(150);
    }

}
