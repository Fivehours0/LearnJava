package LearnSpring.OuterBean;

public class Service {
    private Dao dao;

    public void add() {
        System.out.println("Service add.........");
        this.dao.update();
    }

    // 使用set方法来实现bean的外部注入
    public void setDao(Dao dao) {
        this.dao = dao;
    }
}
