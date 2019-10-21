package graph.control;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
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
import graph.GuiGraph;
import graph.Link;
import graph.algorithm.ListAdjacency;
import graph.Vertex;
import graph.algorithm.BreadthFirstSearch;
import graph.algorithm.DepthFirstSearch;
import graph.algorithm.MatrixAdjacency;
import graph.algorithm.MatrixIncidence;
import graph.algorithm.Prim;
import graph.viewer.ListAdjacencyViewer;
import graph.viewer.MatrixAdjacencyViewer;
import graph.viewer.MatrixIncidenceViewer;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuiControl {

    private GuiGraph gui;
    private ListAdjacency list;
    private Directable direction;

    public GuiControl(GuiGraph gui) {
        this.gui = gui;
        this.direction = new Directable.UnDirected();
        this.list = new ListAdjacency(direction);
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
        panel.add(new JTextField("L"));
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

    public void cleanGui() {
        list = new ListAdjacency(direction);
        updateGui();
    }

    public void updateGui() {
        gui.getText_list_adjacency().setText(ListAdjacencyViewer.status(list));
        gui.getText_matrix_adjacency().setText(MatrixAdjacencyViewer.status(new MatrixAdjacency(list)));
        gui.getText_matrix_incidence().setText(MatrixIncidenceViewer.status(new MatrixIncidence(list)));
    }

    public void printGraph() {
        print(list, "Grafo");
    }

    public void printPrim() {
        JPanel panel = createPanelVertex("Vértice Inicial: ");
        JOptionPane pane = createOptionPane(panel);
        pane.createDialog(gui, "Prim").setVisible(true);
        if (pane.getOptionType() == 2) {
            Prim prim = new Prim(list)
                    .withStart(new Vertex(((JTextField) panel.getComponent(1)).getText()));
            print(prim.runPrim(), "Prim");
        }
    }

    public void printBFS() {
        JPanel panel = createPanelVertex("Vértice Inicial: ");
        JOptionPane pane = createOptionPane(panel);
        pane.createDialog(gui, "BFS").setVisible(true);
        if (pane.getOptionType() == 2) {
            BreadthFirstSearch bfs = new BreadthFirstSearch(list)
                    .withStart(new Vertex(((JTextField) panel.getComponent(1)).getText()));
            print(bfs.runBFS(), "BFS");
        }
    }

    public void printDFS() {
        JPanel panel = createPanelVertex("Vértice Inicial: ");
        JOptionPane pane = createOptionPane(panel);
        pane.createDialog(gui, "DFS").setVisible(true);
        if (pane.getOptionType() == 2) {
            DepthFirstSearch dfs = new DepthFirstSearch(list)
                    .withStart(new Vertex(((JTextField) panel.getComponent(1)).getText()));
            print(dfs.runDFS(), "DFS");
        }
    }

    public void print(ListAdjacency list, String name) {
        Graph<Vertex, Link> g = new SparseMultigraph<>();
        list.getVertexes().forEach(vertex -> g.addVertex(vertex));
        list.getLinks().forEach(link -> g.addEdge(link, link.getVertex(), link.getAdjacent(),
                list.getType().getClass() == Directed.class ? EdgeType.DIRECTED : EdgeType.UNDIRECTED));
        Layout<Vertex, Link> layout = new CircleLayout(g);
        layout.setSize(new Dimension(300, 300));
        VisualizationViewer<Vertex, Link> vv = new VisualizationViewer<>(layout);
        vv.setPreferredSize(new Dimension(350, 350));
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        DefaultModalGraphMouse gm = new DefaultModalGraphMouse();
        gm.setMode(ModalGraphMouse.Mode.TRANSFORMING);
        vv.setGraphMouse(gm);
        JFrame frame = new JFrame(name + " - Custo Total: " + list.getTotalCost());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setVisible(true);
    }

    public ListAdjacency getList() {
        return list;
    }
    
    
}
