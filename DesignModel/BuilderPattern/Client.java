package DesignModel.BuilderPattern;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        ArrayList<String> sequence = new ArrayList<>();
        sequence.add("start");
        sequence.add("alarm");
        sequence.add("stop");

        // 一个Builder只能返回一个benz对象
        BenzBuilder benzBuilder = new BenzBuilder();
        benzBuilder.setSequence(sequence);
        BenZ benZ = (BenZ) benzBuilder.getCarModel();
        benZ.run();
    }
}

class DirectorClient {
    public static void main(String[] args) {
        Director director = new Director();
        BenZ benZA = director.getABenzModel();
        BenZ benZB = director.getBBenzModel();
        benZA.run();
        benZB.run();
    }
}