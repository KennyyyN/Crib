import java.util.*;

class Crib{
    ArrayList<String> crib = new ArrayList<String>();
    Combo combo=new Combo();

    public void addCardsCrib(String input){
        crib.add(input);
    }
    public int calculateCrib(){
        combo.assign(crib);
        return combo.getPoints();
    }
    public void reset(){
        while(!crib.isEmpty()){crib.remove(0);}}
        
    public ArrayList<String> getCrib(){
        return crib;
    }

}