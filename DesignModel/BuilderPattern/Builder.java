package DesignModel.BuilderPattern;

import java.util.ArrayList;

abstract class Builder {
    public abstract void setSequence (ArrayList<String> sequence);
    public abstract CarModel getCarModel ();
}

class BenzBuilder extends Builder {
    private final BenZ benz = new BenZ();

    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.benz.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return benz;
    }
}

class BWMBuilder extends Builder {
    private final BWM bwm = new BWM();

    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.bwm.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return bwm;
    }
}


