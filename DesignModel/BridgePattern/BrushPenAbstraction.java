package DesignModel.BridgePattern;

public abstract class BrushPenAbstraction {
    /**
     * 保留对颜色的引用
     */
    protected ImplementorColor imp;

    /**
     * 每种笔都有自己的实现
     */
    public abstract void operationDraw();

    public void setImplementor(ImplementorColor imp) {
        this.imp = imp;
    }
}

/**
 * 粗毛笔的实现
 * @author 98583
 *
 */
class BigBrushPenRefinedAbstraction extends BrushPenAbstraction{

    public void operationDraw() {
        System.out.println("Big and "+imp.bepaint()+" drawing!");
    }
}