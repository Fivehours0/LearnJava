package DesignModel.AbstractFactory;

public interface HumanFactor {
    AbstractHuman createYellowHuman ();
    AbstractHuman createBlackHuman ();
    AbstractHuman createWhiteHuman ();
}

class FemaleFactory implements HumanFactor {

    @Override
    public AbstractHuman createYellowHuman() {
        return new FemaleYellowHuman();
    }

    @Override
    public AbstractHuman createBlackHuman() {
        return new FemaleBlackHuman();
    }

    @Override
    public AbstractHuman createWhiteHuman() {
        return new FemaleWhiteHuman();
    }
}

class MaleFactory implements HumanFactor {

    @Override
    public AbstractHuman createYellowHuman() {
        return new MaleYellowHuman();
    }

    @Override
    public AbstractHuman createBlackHuman() {
        return new MaleBlackHuman();
    }

    @Override
    public AbstractHuman createWhiteHuman() {
        return new MaleWhiteHuman();
    }
}