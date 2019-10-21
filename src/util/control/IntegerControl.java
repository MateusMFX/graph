package util.control;

import java.util.Arrays;

/**
 * Controlador de objetos Integer, alguns recursos de implementação de construção
 * de Integer entre outros.
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public class IntegerControl {
    
    public static Integer[][] getFilled(int weigth, int heigth , int fill){
        Integer[][] value = new Integer[weigth][heigth];
        for(Integer[] line : value){
            Arrays.fill(line, fill);
        }
        return value;
    }
    
}
