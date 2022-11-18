import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int scelta, base, altezza;
        char s;
        int[] attributes=new int[2];

        Scanner input = new Scanner(System.in);
        Geometries figure = new Geometries();



        System.out.println("1-Triangle\n2-Rectangle\n3-Parellelogram\n4-Square");
        scelta=input.nextInt();

        switch(scelta){
            case 1:

            break;
            case 2:
                System.out.println("cazzi");
            break;
            case 3:
                System.out.println("catzi");
            break;
            case 4:
                System.out.println("caszi");
            break;
        }


        System.out.println("inserisci num vertici nuovo poligono: ");
        int numVertices = input.nextInt();
        Polygon p;

        do {
            System.out.println("Vuoi inserire subito parametri? s/n");
            s = input.next().charAt(0);
            if (s == 's') {
                System.out.println("Inserisci base: ");
                base = input.nextInt();
                System.out.println("Inserisci altezza: ");
                altezza = input.nextInt();
                Triangle triangle = new Triangle(base, altezza);
            } else if (s == 'n') {
                Triangle triangle = new Triangle();
                do {
                    System.out.println("Inserisci Base: ");
                    attributes[0]= input.nextInt();
                    System.out.println("Inserisci altezza: ");
                    attributes[1]= input.nextInt();
                    if(attributes[0]<0||attributes[1]<0){
                        System.out.println("inserisci valori positivi");
                    }
                }while(attributes[0]<0&&attributes[1]<0);
                triangle.describeAttributes();
                triangle.setAttributes(attributes);
            }
        }while(s != 's' && s != 'n');
    }
}