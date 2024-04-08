package controller;

public class ScoreController {
    
    Integer count;

    public ScoreController(){
        this.count = 0;
    }

    public boolean control(final Integer nbPoint){
        if (this.count < nbPoint){
            return false;
        }else{
            return true;
        }
    }

    public Integer getCount(){
        return this.count;
    }

    public void setCount(Integer count){
        this.count += count;
    }
}
