package DesignModel.FactoryPattern;

interface Human {
    public abstract void getColor();
    public abstract void talk();
}

class YellowHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("yellow");
    }

    @Override
    public void talk() {
        System.out.println("我是黄种人");
    }
}

class BlackHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("black");
    }

    @Override
    public void talk() {
        System.out.println("我是黑人");
    }
}

class WhiteHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("white");
    }

    @Override
    public void talk() {

    }
}