package DesignModel.MediatorPattern;

public class Purchase extends AbstractColleague {
    Purchase(AbstractMediator mediator) {
        super(mediator);
    }

    //采购IBM电脑,任务交给中介者做
    public void buyIBMComputer(int number){
        super.mediator.execute("purchase.buy", number);
    }
    //不再采购IBM电脑
    public void refuseBuyIBM(){
        System.out.println("不再采购IBM电脑");
    }
}
