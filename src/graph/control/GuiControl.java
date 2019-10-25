package graph.control;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import graph.Directable;
import graph.Directable.Directed;
import graph.viewer.GuiGraph;
import graph.Link;
import graph.algorithm.ListAdjacency;
import graph.Vertex;
import graph.algorithm.FloydWarshall;
import graph.algorithm.MatrixAdjacency;
import graph.algorithm.MatrixIncidence;
import graph.algorithm.WelshPowell;
import graph.viewer.ListAdjacencyViewer;
import graph.viewer.MatrixAdjacencyViewer;
import graph.viewer.MatrixIncidenceViewer;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Paint;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.apache.commons.collections15.Transformer;

public class GuiControl {

    private GuiGraph gui;
    private ListAdjacency list;
    private Directable direction;
    private char link;

    public GuiControl(GuiGraph gui) {
        this.gui = gui;
        this.direction = new Directable.UnDirected();
        this.list = new ListAdjacency(direction);
        this.link = 'A';
    }

    public JPanel createPanelVertex(String label) {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(new JLabel(label));
        panel.add(new JTextField("V"));
        return panel;
    }

    public JPanel createPanelLink(String label) {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(new JLabel(label));
        panel.add(new JTextField("L"));
        return panel;
    }

    public JPanel createPanelLink() {
        JPanel panel = new JPanel(new GridLayout(8, 1));
        panel.add(new JLabel("Tag da Aresta|Arco: "));
        panel.add(new JTextField("" + link));
        link++;
        panel.add(new JLabel("Tag da vértice: "));
        panel.add(new JTextField("V"));
        panel.add(new JLabel("Tag da vértice adjacente: "));
        panel.add(new JTextField("V"));
        panel.add(new JLabel("Custo: "));
        panel.add(new JTextField(""));
        return panel;
    }

    public JOptionPane createOptionPane(JPanel panel) {
        return new JOptionPane(panel, JOptionPane.QUESTION_MESSAGE, JOptionPane.OK_CANCEL_OPTION) {
            @Override
            public void selectInitialValue() {
                ((JTextField) panel.getComponent(1)).requestFocusInWindow();
            }
        };
    }

    public void removeVertex() {
        JPanel panel = createPanelVertex("Tag da vértice: ");
        JOptionPane pane = createOptionPane(panel);
        pane.createDialog(gui, "Remover Vértice").setVisible(true);
        if (pane.getOptionType() == 2) {
            list.removeVertex(new Vertex(((JTextField) panel.getComponent(1)).getText()));
        }
        updateGui();
    }

    public void removeLink() {
        JPanel panel = createPanelLink("Tag do link: ");
        JOptionPane pane = createOptionPane(panel);
        pane.createDialog(gui, "Remover Link").setVisible(true);
        if (pane.getOptionType() == 2) {
            list.removeLink(new Link(((JTextField) panel.getComponent(1)).getText()));
        }
        updateGui();
    }

    public void addVertex() {
        JPanel panel = createPanelVertex("Tag da vértice: ");
        JOptionPane pane = createOptionPane(panel);
        pane.createDialog(gui, "Adicionar Vértice").setVisible(true);
        if (pane.getOptionType() == 2) {
            list.addVertex(new Vertex(((JTextField) panel.getComponent(1)).getText()));
        }
        updateGui();
    }

    public void addLink() {
        JPanel panel = createPanelLink();
        JOptionPane pane = createOptionPane(panel);
        pane.createDialog(gui, "Adicionar Ligação").setVisible(true);
        if (pane.getOptionType() == 2) {
            list.addLink(new Link(((JTextField) panel.getComponent(1)).getText())
                    .withVertex(new Vertex(((JTextField) panel.getComponent(3)).getText()))
                    .withAdjacent(new Vertex(((JTextField) panel.getComponent(5)).getText()))
                    .withCost(Integer.valueOf(((JTextField) panel.getComponent(7)).getText())));
        }
        updateGui();
    }

    public void switchDirection() {
        if (direction.getClass() == Directable.UnDirected.class) {
            direction = new Directable.Directed();
        } else {
            direction = new Directable.UnDirected();
        }
        if (!list.getLinks().isEmpty()) {
            list.rebuildList(direction);
            updateGui();
        }

    }

    public void setList(ListAdjacency list) {
        this.list = list;
    }

    public void cleanGui() {
        list = new ListAdjacency(direction);
        link = 'A';
        updateGui();
    }

    public void updateGui() {
        new WelshPowell(list).run();      
        gui.getText_list_adjacency().setText(ListAdjacencyViewer.status(list));
        gui.getText_matrix_adjacency().setText(MatrixAdjacencyViewer.status(new MatrixAdjacency(list)));
        gui.getText_matrix_incidence().setText(MatrixIncidenceViewer.status(new MatrixIncidence(list)));
        gui.getText_floyd_warshall().setText(new FloydWarshall(list).run().getLog());
    }

    public void printGraph() {
        print(list);
    }


    private EdgeType getTypeGraph(Class clazz) {
        return clazz == Directed.class ? EdgeType.DIRECTED : EdgeType.UNDIRECTED;
    }

    private Graph<Vertex, Link> createGraphJung(ListAdjacency list) {
        Graph<Vertex, Link> g = new SparseMultigraph<>();
        list.getVertexes().forEach(vertex -> g.addVertex(vertex));
        list.getLinks().forEach(link -> g.addEdge(link, link.getVertex(),
                link.getAdjacent(), getTypeGraph(list.getType().getClass())));
        return g;
    }

    private Layout<Vertex, Link> createLayoutJung(Graph<Vertex, Link> graph) {
        Layout<Vertex, Link> layout = new FRLayout(graph);
        layout.setSize(new Dimension(300, 300));
        return layout;
    }

    private Transformer<Vertex, Paint> vertexPaint() {
        Transformer<Vertex, Paint> vp = (Vertex input) -> {
            return input.getColor();
        };
        return vp;
    }

    private VisualizationViewer<Vertex, Link> createVisualizationJung(Layout<Vertex, Link> layout) {
        VisualizationViewer<Vertex, Link> vv = new VisualizationViewer<>(layout);
        vv.setPreferredSize(new Dimension(350, 350));
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint());
        DefaultModalGraphMouse gm = new DefaultModalGraphMouse();
        gm.setMode(ModalGraphMouse.Mode.PICKING);
        vv.setGraphMouse(gm);
        return vv;
    }

    private void createFrame(VisualizationViewer<Vertex, Link> vv) {
        String nameWindow = "Custo Total: " + list.getTotalCost()
                + " - " + (list.isPlanarity() ? "É Planar!" : "Não é Planar!");
        JFrame frame = new JFrame(nameWindow);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setVisible(true);
    }

    public void print(ListAdjacency list) {
        Graph<Vertex, Link> graph = createGraphJung(list);
        Layout<Vertex, Link> layout = createLayoutJung(graph);
        VisualizationViewer<Vertex, Link> vv = createVisualizationJung(layout);
        createFrame(vv);
    }

    public ListAdjacency getList() {
        return list;
    }
}
