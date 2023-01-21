import java.util.*;


public class Combo {
    ArrayList<String> cards = new ArrayList<String>();
    String cutCard="";
    int points=0;

    public void getCut(String input){
        cutCard=input;
    }
    public String getCut(){
        return cutCard;
    }
    public int assign(String input){
        cards.add(input);
        return getPoints();
    }
    public int assign(ArrayList<String> input){
        cards.addAll(input);
        return getPoints();
    }
    public int getPoints(){
        points=cards.size();
        return points;
    }
    
}

