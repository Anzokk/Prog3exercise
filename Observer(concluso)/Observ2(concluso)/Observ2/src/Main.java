public class Main {
    public static void main(String[] args) {

        Model m=new Model();
        View v=new View("Pannello cazzo");
        Controller c = new Controller(m,v);
    }
}