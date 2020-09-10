package DesignModel.AbstractFactory;

public class Client {
    public static void main(String[] args) {
        HumanFactor factor = new FemaleFactory();
        AbstractHuman fy = factor.createYellowHuman();
        fy.getColor();
    }
}
