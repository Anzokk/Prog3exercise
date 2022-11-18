public class Parallelogram extends Polygon {
    private int base;
    private int height;

    public Parallelogram(int base, int height){
        super(4);
        this.base=base;
        this.height=height;
    }

    public int getArea(){
        return base*height;
    }

    public int getPerimeter(){
        return (base*height)*2;
    }

    public int getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }

    public String[] describeAttributes(){
        return new String[]{"[Base],[Height]"};
    }

    public void setAttributes(int[] attributes){
        this.base=attributes[0];
        this.height=attributes[1];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Parallelogram that = (Parallelogram) o;

        if (base != that.base) return false;
        return height == that.height;
    }
}