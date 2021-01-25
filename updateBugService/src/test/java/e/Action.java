package e;

import java.util.List;

/**
 * @Author: cjx
 * @Date: 2021-01-25 11:05
 * @Description;
 */
public class Action {

    public void action(Family f){
        f.eat();
    }

    public void action(Father f){
        f.eat();
    }

    public void action(Father ... fl){
        for (Father father : fl) {
           father.eat();
        }
    }
}
