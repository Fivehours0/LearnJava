package DesignModel.MediatorPattern;

public class AbstractColleague {
    AbstractMediator mediator = null;
    // 设置中介者
    AbstractColleague (AbstractMediator mediator) {
        this.mediator = mediator;
    }
}
