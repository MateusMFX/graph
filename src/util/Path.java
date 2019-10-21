package util;


import util.control.PathControl;

import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Endereço dos caminhos usados no projeto.
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public class Path {

    /**
     * Caminhos padrões de acesso a pastas.
     */
    public static final String PROJECT = System.getProperty("user.dir") + "\\";
    public static final String REPORTS = PROJECT + "report\\";
    public static final String IMAGE = PROJECT + "img\\";
    public static final String EXPORT = PROJECT + "export\\";
    public static final String LOGO = PROJECT + "image\\logo\\";
    public static final String IMPORT = PROJECT + "import\\";
    public static final String CONFIG = PROJECT + "config\\";

    private JFileChooser fileChooser;

    public Path(JFileChooser fileChooser) {
        this.fileChooser = fileChooser;
    }

    public JFileChooser getFileChooser() {
        return fileChooser;
    }

    public Path withFileChooser(JFileChooser fileChooser) {
        this.fileChooser = fileChooser;
        return this;
    }

    /**
     * Adiciona filtros de visibilidade dos formatos de arquivo na seleção do
     * arquivo.
     *
     * @param formats uma lista de formatos de aqruivo que será visivel na
     * seleção;
     */
    public void addFilter(String... formats) {
        Arrays.asList(formats).forEach(format
                -> fileChooser.setFileFilter(new FileNameExtensionFilter("." + format, format)));
    }

    /**
     * Busca o caminho do arquivo para abrir através do componente JFileChooser.
     *
     * @return retorna o caminho do arquivo caso o usuário selecione a opção
     * open, caso contrário retorna um valor null.
     */
    public String getOpenPath() {
        if (PathControl.getOptionDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getPath();
        }
        return null;
    }

    /**
     * Busca o caminho do arquivo para salvar através do componente JFileChooser.
     *
     * @return retorna o caminho do arquivo caso o usuário selecione a opção
     * save, caso contrário retorna um valor null.
     */
    public String getSavePath() {
        if (PathControl.getSaveDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
            return PathControl.saveFile(fileChooser);
        }
        return null;
    }

}
