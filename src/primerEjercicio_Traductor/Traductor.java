package primerEjercicio_Traductor;

import java.util.Scanner;

public class Traductor {
    Scanner sc = new Scanner(System.in);
    Diccionario palabras = new Diccionario();

    private String palabra;
    private String palabraTraducida;
    private String frase;
    private String fraseTraducida;
    private boolean power;

    //constructor
    public Traductor(){
        power = true;
    }

    //Método funcionamiento del traductor:
    public void ejecutar(){
        String option = "a";
        System.out.println("Bienvenido al traductor chano de Ceste.");
        while(power) {
            if(option.equals("a")) {
                System.out.println("Escribe una palabra para traducirla: ");
                palabra = sc.nextLine();
                palabraTraducida = traducir(palabra);
                if (palabraTraducida.equals("Not Found!")) {
                    System.out.println("Palabra no encontrada");
                } else {
                    System.out.println("La palabra " + palabra + " significa \"" + palabraTraducida + "\" en inglés.");
                }
            }else if(option.equals("b")){
                System.out.println("Escribe una frase para traducirla: ");
                frase = sc.nextLine();
                fraseTraducida = traducirFrase(frase);
                System.out.println("La frase " + frase + " significa \"" + fraseTraducida + "\" en ingés.");
            }

            System.out.println("¿Quiéres buscar otra palabra?  a.Sí  b.Quiero traducir una frase  c.No" );
            option = sc.nextLine();
            if(option.equals("c") ){
                power = false;
                System.out.println("Gracias por utilizar este traductor chano. ");
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
    //método para traducir una frase:
    public String traducirFrase(String fraseATraducir){
        String fraseTraducida = "";
        String[] palabrasFrase = fraseATraducir.split(" ");
        String[] palabrasFraseTraducidas = new String[palabrasFrase.length];
        for(int i = 0; i < palabrasFrase.length; i++){
            palabrasFraseTraducidas[i] = traducir(palabrasFrase[i]);
            if(i == 0){
                fraseTraducida += palabrasFraseTraducidas[i];
            }else {
                fraseTraducida += " " + palabrasFraseTraducidas[i];
            }
        }


        return fraseTraducida;
    }

}
