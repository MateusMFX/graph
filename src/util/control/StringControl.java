package util.control;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Controlador de objetos String, alguns recursos de implementação de construção
 * de string entre outros.
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public abstract class StringControl {

    /**
     * Concatena a palavra em n vezes.
     *
     * @param word palavra a ser concatenada.
     * @param qtd a quantidade de vezes de repetição da palavra.
     * @return a concatenação em objeto String.
     */
    public static String concat(String word, int qtd) {
        String value = "";
        for (int i = 0; i < qtd; i++) {
            value += word;
        }
        return value;
    }

    /**
     * Vizualiza o que contem em um array com um espaçamento específico.
     *
     * @param array a lista a ser mostrada.
     * @param pad o espaçamento obrigatório do texto.
     * @return no formato de String.
     */
    public static String arrayViewer(Object[] array, int pad) {
        return Arrays.asList(array).stream()
                .map(value -> String.format("%-" + pad + "." + pad + "s\t", value.toString()))
                .collect(Collectors.joining());
    }

    /**
     * Vizualiza o que contem em uma matrix com um espaçamento específico.
     *
     * @param matrix a matrix a ser mostrada.
     * @param pad o espaçamento obrigatório do texto.
     * @return no formato de String.
     */
    public static String matrixViewer(Object[][] matrix, int pad) {
        return Arrays.stream(matrix)
                .map(value -> arrayViewer(value, pad) + "\n")
                .collect(Collectors.joining());
    }

    /**
     * Visualiza o que contém uma matrix com um cabeçalho na linha superior.
     *
     * @param matrix a matrix a ser mostrada.
     * @param headLine cabeçalho na linha superior
     * @param pad o espaçamento obrigatório do texto.
     * @return no formato de String.
     */
    public static String matrixHeadLineViewer(Object[][] matrix, Object[] headLine, int pad) {
        return arrayViewer(headLine, pad) + "\n" + matrixViewer(matrix, pad);
    }

    /**
     * Visualiza o que contém em uma matrix com um cabeçalho na coluna no canto
     * esquerdo.
     *
     * @param matrix a matrix a ser mostrada.
     * @param headColumn cabeçalho na coluna esquerda.
     * @param pad o espaçamento obrigatório do texto.
     * @throws ArrayIndexOutOfBoundsException caso o array de colunas seja maior
     * que a matrix.
     *
     * @return no formato de String.
     */
    public static String matrixHeadColumnViewer(Object[][] matrix, Object[] headColumn, int pad) {
        String value = "";
        for (int i = 0; i < headColumn.length; i++) {
            value += String.format("%-" + pad + "." + pad + "s\t", headColumn[i].toString())
                    + arrayViewer(matrix[i], pad) + "\n";
        }
        return value;
    }

    /**
     * Visualiza o que contém em uma matrix com um cabeçalho na coluna no canto
     * esquerdo e um cabeçalho na linha superior.
     *
     * @param matrix a matrix a ser mostrada.
     * @param headLine cabeçalho na linha superior
     * @param headColumn cabeçalho na coluna esquerda.
     * @param pad o espaçamento obrigatório do texto.
     * @throws ArrayIndexOutOfBoundsException caso o array de colunas seja maior
     * que a matrix.
     * @return no formato de String.
     */
    public static String matrixViewer(Object[][] matrix, Object[] headLine, Object[] headColumn, int pad) {
        if (pad != 0) {
            String value = String.format("%-" + pad + "." + pad + "s\t", "")
                    + arrayViewer(headLine, pad) + "\n";
            value += matrixHeadColumnViewer(matrix, headColumn, pad);
            return value;
        }
        return "";
    }
}
