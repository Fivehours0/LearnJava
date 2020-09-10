package DesignModel.BuilderPattern;

import java.util.ArrayList;

public class Director {
    private ArrayList<String> sequence = new ArrayList<>();

    public BenZ getABenzModel () {
        BenzBuilder benzBuilder = new BenzBuilder();
        this.sequence.clear();
        sequence.add("start");
        sequence.add("alarm");
        sequence.add("stop");
        benzBuilder.setSequence(sequence);
        return (BenZ) benzBuilder.getCarModel();
    }

    public BenZ getBBenzModel () {
        BenzBuilder benzBuilder = new BenzBuilder();
        this.sequence.clear();
        sequence.add("start");
        sequence.add("stop");
        benzBuilder.setSequence(sequence);
        return (BenZ) benzBuilder.getCarModel();
    }
}
