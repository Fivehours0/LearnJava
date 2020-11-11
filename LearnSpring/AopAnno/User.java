package LearnSpring.AopAnno;

import org.springframework.stereotype.Component;

@Component
public class User {
    public void add() {
        int i = 10/0;
        System.out.println("User's add");
    }
}
