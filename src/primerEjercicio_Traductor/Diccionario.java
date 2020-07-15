package primerEjercicio_Traductor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Diccionario {

    private String[] listaCastellano;
    private String[] listaIngles;

    //constructor
    public Diccionario(){
        //listaCastellano = new String[]{"casa", "coche", "gato", "perro", "java", "abuelo", "abuela"};
        //listaIngles = new String[]{"house", "car", "cat", "dog", "java", "grandfather", "grandmother"};
        listaCastellano = readStringsFromFile("spanish-words.txt");
        listaIngles = readStringsFromFile("english-words.txt");
    }

    public String[] readStringsFromFile(String path) {
        try {
            List<String> strings = Files.readAllLines(Paths.get(path));
            return strings.toArray(new String[strings.size()]);
        } catch (IOException e) {
            return null;
        }
    }
    //getters y setters
    public String[] getListaCastellano() {
        return listaCastellano;
    }

    public void setListaCastellano(String[] listaCastellano) {
        this.listaCastellano = listaCastellano;
    }

    public String[] getListaIngles() {
        return listaIngles;
    }

    public void setListaIngles(String[] listaIngles) {
        this.listaIngles = listaIngles;
    }
}
