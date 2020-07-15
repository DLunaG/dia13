package primerEjercicio_Traductor;

import java.util.Scanner;

public class Traductor {
    Scanner sc = new Scanner(System.in);
    Diccionario palabras = new Diccionario();

    String palabra;
    String palabraTraducida;
    boolean power;

    //constructor
    public Traductor(){
        power = true;
    }

    //Método funcionamiento del traductor:
    public void ejecutar(){

        System.out.println("Bienvenido al traductor chano de Ceste.");
        while(power) {
            System.out.println("Escribe una palabra para traducirla: ");
            palabra = sc.nextLine();
            palabraTraducida = traducir(palabra);
            if(palabraTraducida.equals("Not Found!")){
                System.out.println("Palabra no encontrada");
            }else {
                System.out.println("La palabra " + palabra + " significa \"" + palabraTraducida + "\" en inglés.");
            }

            System.out.println("¿Quiéres buscar otra palabra?  a.Sí  b.No" );
            if(sc.nextLine().equals("b") ){
                power = false;
            }
        }

    }

    //método que busca la palabra en el diccionario y devuelve la traducción:
    public String traducir(String palabraABuscar){
        String palabraTraducida = "Not Found!";

        for(int i = 0; i < palabras.getListaCastellano().length; i++) {
            if(palabraABuscar.equalsIgnoreCase(palabras.getListaCastellano()[i])){
                palabraTraducida = palabras.getListaIngles()[i];
            }
        }
        return palabraTraducida;
    }


}
