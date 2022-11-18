public class Triangle extends Polygon{
    private int base;
    private int height;

    public Triangle(int base, int height){
        super(3);
        this.base=base;
        this.height=height;
    }

    public Triangle(){
        super(3);
    }

    public int getBase(){
        return base;
    }

    public int getHeight(){
        return height;
    }

    public int getArea(){
        return base*height/2;
    }

    public String[] describeAttributes(){
        return new String[]{"[Base],[Height]"};
    }

    public void setAttributes(int[] attributes){
        this.base=attributes[0];
        this.height=attributes[1];
    }


    public boolean equals(Object o){
        if(o!=null&&o.getClass()==this.getClass()){
            if(((Triangle) o).getBase()==this.getBase()&&((Triangle) o).getHeight()==this.getHeight()){
                return true;
            }
        }return false;
    }
}
