package DesignModel.BuilderPattern;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        ArrayList<String> sequence = new ArrayList<>();
        sequence.add("start");
        sequence.add("alarm");
        sequence.add("stop");

        BenzBuilder benzBuilder = new BenzBuilder();
        benzBuilder.setSequence(sequence);
        BenZ benZ = (BenZ) benzBuilder.getCarModel();
        benZ.run();
    }
}
