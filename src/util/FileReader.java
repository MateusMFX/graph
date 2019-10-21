package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Ler arquivos e transforma em uma estrutura de facil manipulação.
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public abstract class FileReader {

    public static final String UTF_8 = "utf-8";
    public static final String WIND_1232 = "windows-1252";

    /**
     * Transforma o arquivo selecionado em uma estrutura de leitura das linhas
     * do arquivo.
     *
     * @param path o caminho da localização do arquivo.
     * @param unicode o formato unicode que o arquivo esta formatado, para
     * evitar perdas de caracteres
     * @return retorna o arquivo lido na estrutura de Scanner, podendo ser
     * convertido depois para String através do método getText() ou tabela pelo
     * getTabke().
     * @throws FileNotFoundException lança uma excessão caso não encontre o
     * arquivo.
     */
    public static Scanner getScanner(String path, String unicode)
            throws FileNotFoundException {
        return new Scanner(new InputStreamReader(new FileInputStream(path),
                Charset.forName(unicode).newEncoder().charset()));
    }

    /**
     * Transforma a estrutura Scanner em tabela, eficiente em importação de CSV
     * ou tabelas.
     *
     * @param scanner a estrutura com os dados do arquivo.
     * @param delimiter o caracter responsável pela quebra de coluna, a linha é
     * conforme a quebra de linha.
     * @return uma lista de lista de strings, ou seja, uma tabela.
     */
    public static List<List<String>> getTable(Scanner scanner, String delimiter) {
        List<List<String>> records = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] values = scanner.nextLine().split(delimiter, -2);
            records.add(Arrays.asList(values));
        }
        return records;
    }

    /**
     * Transforma a estrutura Scanner em um texto corrido, conforme o arquivo
     * exportado.
     *
     * @param scanner a estrutura com os dados do arquivo.
     * @return o texto corrido dos dados do arquivo.
     */
    public static String getText(Scanner scanner) {
        String line = "";
        while (scanner.hasNextLine()) {
            line += scanner.nextLine() + '\n';
        }
        return line;
    }

    /**
     * Transforma o arquivo de importação em formato de um texto corrido, ou
     * seja, string.
     *
     * @param path o caminho da localização do arquivo.
     * @param unicode o formato unicode que o arquivo esta formatado, para
     * evitar perdas de caracteres
     * @return o texto corrido dos dados do arquivo.
     * @throws FileNotFoundException lança uma excessão caso não encontre o
     * arquivo.
     */
    public static String getImport(String path, String unicode)
            throws FileNotFoundException {
        Scanner scanner = getScanner(path, unicode);
        return getText(scanner);
    }

    /**
     * Transforma o arquivo de importação em formato de uma tabela.
     *
     * @param delimiter o caracter responsável pela quebra de coluna, a linha é
     * conforme a quebra de linha.
     * @param path o caminho da localização do arquivo.
     * @param unicode o formato unicode que o arquivo esta formatado, para
     * evitar perdas de caracteres
     * @return uma lista de lista de strings, ou seja, uma tabela.
     * @throws FileNotFoundException lança uma excessão caso não encontre o
     * arquivo.
     */
    public static List<List<String>> getImport(String delimiter, String path, String unicode)
            throws FileNotFoundException {
        Scanner scanner = getScanner(path, unicode);
        return getTable(scanner, delimiter);
    }
}
