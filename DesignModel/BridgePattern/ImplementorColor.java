package DesignModel.BridgePattern;

/**
 * 颜色的接口
 * @author 98583
 *
 */
public abstract class ImplementorColor {

    public abstract String bepaint();
}

/**
 * 红色的具体实现
 * @author 98583
 *
 */
class OncreteImplementorRed extends ImplementorColor{

    public String bepaint() {
        return "red";
    }

}