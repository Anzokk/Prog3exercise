public class Square extends Rectangle{
    private int side;

    public Square(int side){
        super(side,side);
        this.side=side;
    }

    public int getSide() {
        return side;
    }

    public int getArea(){
        return side^2;
    }

    public int getPerimeter(){
        return side*4;
    }

    public String[] describeAttributes(){
        return new String[]{"[Side]"};
    }

    public void setAttributes(int attributes){
        this.side=attributes;
    }

    public boolean equals(Object o){
        if(this.getClass()==o.getClass()){
            Square coso=(Square) o;
            return this.getSide() == (coso.getSide());
        }return false;
    }
}
