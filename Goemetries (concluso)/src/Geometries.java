import java.util.ArrayList;

public class Geometries {
    private ArrayList <Polygon> poligoni;

    public Geometries(){
        this.poligoni=new ArrayList<>();
    }
    
    public void add(Polygon coso){
        if(!poligoni.contains(coso)){
            poligoni.add(coso);
        }
    }
    
    public void remove(Polygon coso){
        if(poligoni.contains(coso)) {
            poligoni.add(coso);
        }
    }

    public void print(){
        System.out.println("Poligoni: ");
        for(Polygon num:this.poligoni){
            System.out.println("Tipo oggetto: "+num.getClass()+"Area: "+num.getArea());
        }
    }

    public int count(){
        return poligoni.size();
    }
}
