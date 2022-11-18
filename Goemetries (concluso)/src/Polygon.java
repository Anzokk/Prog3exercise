public abstract class Polygon {
    private final int numVertices;

    public Polygon(int numVertices){
        this.numVertices=numVertices;
    }
    public abstract int getArea();
    public abstract String[] describeAttributes();
    public abstract void setAttributes(int[] attributes);

    public int getNumVertices(){
        return numVertices;
    }



    public boolean equals(Object o){
        return o != null && o.getClass() == this.getClass();
    }
}
