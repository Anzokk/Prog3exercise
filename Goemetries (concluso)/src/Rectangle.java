import org.w3c.dom.css.Rect;

public class Rectangle extends Polygon {
    private int base;
    private int height;

    public Rectangle(int base, int height){
        super(4);
        this.base=base;
        this.height=height;
    }

    public int getArea(){
        return base*height;
    }

    public int getBase(){
        return base;
    }

    public int getHeight(){
        return height;
    }

    public int getPerimeter(){
        return (base*height)*2;
    }

    public String[] describeAttributes(){
        return new String[]{"[Base],[Height]"};
    }

    public void setAttributes(int[] attributes){
        this.base=attributes[0];
        this.height=attributes[1];
    }

    public boolean equals(Object o) {
        if(this.getClass()==(o.getClass())){
            if(this.getBase()==((Rectangle) o).getBase()&&this.getHeight()==(((Rectangle)o).getHeight())){return true;}
        }return false;
    }
}