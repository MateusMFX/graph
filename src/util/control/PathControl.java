package util.control;

import javax.swing.JFileChooser;

/**
 * Classe para controle de ajustes da classe Path
 * @author Andre
 */
public abstract class PathControl {

    /**
     * Opção da escolha do usário na seleção para abrir arquivo ou pasta, as
     * opções se encontram na classe JFileChooser.
     *
     * @param fileChooser componente que iniciará a seleção de arquivo.
     * @return o valor da ação da escolha do usuário, ver a classe JFileChoose.
     */
    public static int getOptionDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(fileChooser.getRootPane());
    }

    /**
     * Opção da escolha do usário na seleção para salvar arquivo, as opções se
     * encontram na classe JFileChooser.
     *
     * @param fileChooser componente que iniciará a seleção de arquivo.
     * @return o valor da ação da escolha do usuário, ver a classe JFileChoose.
     */
    public static int getSaveDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(fileChooser.getRootPane());
    }

    /**
     * Ajustar o nome do arquivo para salvar conforme o formato do filtro do
     * componente JFileChooser
     *
     * @param fileChooser componente de busca de pasta e arquivos.
     * @return o caminho para salvar o arquivo em formato de string.
     */
    public static String saveFile(JFileChooser fileChooser) {
        String path = fileChooser.getSelectedFile().getPath();
        String format = fileChooser.getFileFilter().getDescription();
        return path.contains(format) ? path : path + format;
    }

}
