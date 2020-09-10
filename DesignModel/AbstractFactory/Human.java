package DesignModel.AbstractFactory;

// 具体实现
class MaleYellowHuman extends AbstractYellowAbstractHuman {

    @Override
    public void getSex() {
        System.out.println("male y");
    }
}

// 具体实现
class FemaleYellowHuman extends AbstractYellowAbstractHuman {

    @Override
    public void getSex() {
        System.out.println("female y");
    }
}

// 具体实现
class MaleBlackHuman extends AbstractYellowAbstractHuman {

    @Override
    public void getSex() {
        System.out.println("male b");
    }
}

// 具体实现
class FemaleBlackHuman extends AbstractYellowAbstractHuman {

    @Override
    public void getSex() {
        System.out.println("female b");
    }
}

// 具体实现
class MaleWhiteHuman extends AbstractYellowAbstractHuman {

    @Override
    public void getSex() {
        System.out.println("male w");
    }
}

// 具体实现
class FemaleWhiteHuman extends AbstractYellowAbstractHuman {

    @Override
    public void getSex() {
        System.out.println("female w");
    }
}