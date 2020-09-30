package DesignModel.CompositePattern;

import java.util.ArrayList;

/**
 * Composite树枝构件
 * 树枝对象， 它的作用是组合树枝节点和叶子节点形成一个树形结构。(拥有子节点的节点)
 */
public class Composite extends Component {
    private final ArrayList<Component> componentArrayList = new ArrayList<>();

    //增加一个叶子构件或树枝构件
    public void add(Component component){
        this.componentArrayList.add(component);
    }

    //删除一个叶子构件或树枝构件
    public void remove(Component component){
        this.componentArrayList.remove(component);
    }

    //获得分支下的所有叶子构件和树枝构件
    public ArrayList<Component> getChildren(){
        return this.componentArrayList;
    }
}
