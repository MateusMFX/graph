package graph.viewer;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import graph.Link;
import graph.ParanaState;
import graph.Vertex;
import graph.control.GuiControl;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class GuiGraph extends javax.swing.JFrame {

    private GuiControl control;
    Graph<Vertex, Link> graph;
    private VisualizationViewer<Vertex, Link> graphPanel;

    public GuiGraph() {
        initComponents();
        this.control = new GuiControl(this);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new GuiGraph().setVisible(true);
        });
    }

    public JTextArea getText_a_star() {
        return text_a_star;
    }

    public JTextArea getText_floyd_warshall() {
        return text_floyd_warshall;
    }

    public JButton getBtn_add_link() {
        return btn_add_link;
    }

    public JTextArea getText_list_adjacency() {
        return text_list_adjacency;
    }

    public JTextArea getText_matrix_adjacency() {
        return text_matrix_adjacency;
    }

    public JTextArea getText_matrix_incidence() {
        return text_matrix_incidence;
    }

    public JButton getBtn_add_vertex() {
        return btn_add_vertex;
    }

    public JButton getBtn_remove_link() {
        return btn_remove_link;
    }

    public JButton getBtn_remove_vertex() {
        return btn_remove_vertex;
    }

    public JButton getBtn_switch_link() {
        return btn_switch_link;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolbar = new javax.swing.JToolBar();
        btn_add_vertex = new javax.swing.JButton();
        btn_add_link = new javax.swing.JButton();
        separator01 = new javax.swing.JToolBar.Separator();
        btn_remove_vertex = new javax.swing.JButton();
        btn_remove_link = new javax.swing.JButton();
        btn_clean = new javax.swing.JButton();
        separator02 = new javax.swing.JToolBar.Separator();
        btn_switch_link = new javax.swing.JButton();
        btn_adjacent = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btn_print_graph = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btn_load_map = new javax.swing.JButton();
        panel_text = new javax.swing.JPanel();
        split_1 = new javax.swing.JSplitPane();
        split_2 = new javax.swing.JSplitPane();
        split_3 = new javax.swing.JSplitPane();
        split_4 = new javax.swing.JSplitPane();
        scroll_5 = new javax.swing.JScrollPane();
        text_a_star = new javax.swing.JTextArea();
        scroll_6 = new javax.swing.JScrollPane();
        text_floyd_warshall = new javax.swing.JTextArea();
        scroll_3 = new javax.swing.JScrollPane();
        text_matrix_incidence = new javax.swing.JTextArea();
        scroll_2 = new javax.swing.JScrollPane();
        text_matrix_adjacency = new javax.swing.JTextArea();
        scroll_1 = new javax.swing.JScrollPane();
        text_list_adjacency = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        toolbar.setFloatable(false);
        toolbar.setRollover(true);

        btn_add_vertex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graph/img/add_vertex.png"))); // NOI18N
        btn_add_vertex.setFocusable(false);
        btn_add_vertex.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_add_vertex.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_add_vertex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_vertexActionPerformed(evt);
            }
        });
        toolbar.add(btn_add_vertex);

        btn_add_link.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graph/img/add_link.png"))); // NOI18N
        btn_add_link.setFocusable(false);
        btn_add_link.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_add_link.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_add_link.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_linkActionPerformed(evt);
            }
        });
        toolbar.add(btn_add_link);
        toolbar.add(separator01);

        btn_remove_vertex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graph/img/remove_vertex.png"))); // NOI18N
        btn_remove_vertex.setFocusable(false);
        btn_remove_vertex.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_remove_vertex.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_remove_vertex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_remove_vertexActionPerformed(evt);
            }
        });
        toolbar.add(btn_remove_vertex);

        btn_remove_link.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graph/img/remove_link.png"))); // NOI18N
        btn_remove_link.setFocusable(false);
        btn_remove_link.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_remove_link.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_remove_link.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_remove_linkActionPerformed(evt);
            }
        });
        toolbar.add(btn_remove_link);

        btn_clean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graph/img/clean.png"))); // NOI18N
        btn_clean.setFocusable(false);
        btn_clean.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_clean.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cleanActionPerformed(evt);
            }
        });
        toolbar.add(btn_clean);
        toolbar.add(separator02);

        btn_switch_link.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graph/img/switch_direction.png"))); // NOI18N
        btn_switch_link.setFocusable(false);
        btn_switch_link.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_switch_link.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_switch_link.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_switch_linkActionPerformed(evt);
            }
        });
        toolbar.add(btn_switch_link);

        btn_adjacent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graph/img/adjacent.png"))); // NOI18N
        btn_adjacent.setFocusable(false);
        btn_adjacent.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_adjacent.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_adjacent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adjacentActionPerformed(evt);
            }
        });
        toolbar.add(btn_adjacent);
        toolbar.add(jSeparator1);

        btn_print_graph.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graph/img/graph.png"))); // NOI18N
        btn_print_graph.setFocusable(false);
        btn_print_graph.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_print_graph.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_print_graph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_print_graphActionPerformed(evt);
            }
        });
        toolbar.add(btn_print_graph);
        toolbar.add(jSeparator2);

        btn_load_map.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graph/img/map.png"))); // NOI18N
        btn_load_map.setFocusable(false);
        btn_load_map.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_load_map.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_load_map.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_load_mapActionPerformed(evt);
            }
        });
        toolbar.add(btn_load_map);

        split_1.setDividerLocation(170);
        split_1.setDividerSize(11);
        split_1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        split_1.setMaximumSize(new java.awt.Dimension(200, 200));
        split_1.setMinimumSize(new java.awt.Dimension(200, 200));
        split_1.setPreferredSize(new java.awt.Dimension(200, 200));

        split_2.setDividerLocation(170);
        split_2.setDividerSize(11);
        split_2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        split_2.setMaximumSize(new java.awt.Dimension(200, 200));
        split_2.setMinimumSize(new java.awt.Dimension(200, 200));
        split_2.setPreferredSize(new java.awt.Dimension(200, 200));

        split_3.setDividerLocation(170);
        split_3.setDividerSize(11);
        split_3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        split_3.setMaximumSize(new java.awt.Dimension(200, 200));
        split_3.setMinimumSize(new java.awt.Dimension(200, 200));
        split_3.setPreferredSize(new java.awt.Dimension(200, 200));

        split_4.setDividerLocation(170);
        split_4.setDividerSize(11);
        split_4.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        split_4.setMaximumSize(new java.awt.Dimension(200, 200));
        split_4.setMinimumSize(new java.awt.Dimension(200, 200));
        split_4.setName(""); // NOI18N
        split_4.setPreferredSize(new java.awt.Dimension(200, 200));

        text_a_star.setEditable(false);
        text_a_star.setColumns(20);
        text_a_star.setRows(5);
        text_a_star.setBorder(javax.swing.BorderFactory.createTitledBorder("A Estrela"));
        text_a_star.setPreferredSize(new java.awt.Dimension(450, 350));
        scroll_5.setViewportView(text_a_star);

        split_4.setRightComponent(scroll_5);

        text_floyd_warshall.setEditable(false);
        text_floyd_warshall.setColumns(20);
        text_floyd_warshall.setRows(5);
        text_floyd_warshall.setBorder(javax.swing.BorderFactory.createTitledBorder("Floyd-Warshall"));
        text_floyd_warshall.setPreferredSize(null);
        scroll_6.setViewportView(text_floyd_warshall);

        split_4.setLeftComponent(scroll_6);

        split_3.setRightComponent(split_4);

        text_matrix_incidence.setEditable(false);
        text_matrix_incidence.setColumns(20);
        text_matrix_incidence.setRows(5);
        text_matrix_incidence.setBorder(javax.swing.BorderFactory.createTitledBorder("Matriz de Incidência"));
        text_matrix_incidence.setPreferredSize(new java.awt.Dimension(450, 350));
        scroll_3.setViewportView(text_matrix_incidence);

        split_3.setLeftComponent(scroll_3);

        split_2.setRightComponent(split_3);

        text_matrix_adjacency.setEditable(false);
        text_matrix_adjacency.setColumns(20);
        text_matrix_adjacency.setRows(5);
        text_matrix_adjacency.setBorder(javax.swing.BorderFactory.createTitledBorder("Matriz de Adjacência"));
        text_matrix_adjacency.setPreferredSize(new java.awt.Dimension(450, 350));
        scroll_2.setViewportView(text_matrix_adjacency);

        split_2.setLeftComponent(scroll_2);

        split_1.setRightComponent(split_2);

        scroll_1.setPreferredSize(new java.awt.Dimension(369, 151));

        text_list_adjacency.setEditable(false);
        text_list_adjacency.setColumns(20);
        text_list_adjacency.setRows(5);
        text_list_adjacency.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Adjacência"));
        text_list_adjacency.setPreferredSize(new java.awt.Dimension(450, 350));
        scroll_1.setViewportView(text_list_adjacency);

        split_1.setLeftComponent(scroll_1);

        javax.swing.GroupLayout panel_textLayout = new javax.swing.GroupLayout(panel_text);
        panel_text.setLayout(panel_textLayout);
        panel_textLayout.setHorizontalGroup(
            panel_textLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_textLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(split_1, javax.swing.GroupLayout.DEFAULT_SIZE, 1060, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_textLayout.setVerticalGroup(
            panel_textLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_textLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(split_1, javax.swing.GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolbar, javax.swing.GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE)
            .addComponent(panel_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_add_vertexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_vertexActionPerformed
        control.addVertex();
    }//GEN-LAST:event_btn_add_vertexActionPerformed

    private void btn_add_linkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_linkActionPerformed
        control.addLink();
    }//GEN-LAST:event_btn_add_linkActionPerformed

    private void btn_print_graphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_print_graphActionPerformed
        control.printGraph();
    }//GEN-LAST:event_btn_print_graphActionPerformed

    private void btn_switch_linkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_switch_linkActionPerformed
        control.switchDirection();
    }//GEN-LAST:event_btn_switch_linkActionPerformed

    private void btn_remove_vertexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_remove_vertexActionPerformed
        control.removeVertex();
    }//GEN-LAST:event_btn_remove_vertexActionPerformed

    private void btn_remove_linkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_remove_linkActionPerformed
        control.removeLink();
    }//GEN-LAST:event_btn_remove_linkActionPerformed

    private void btn_cleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cleanActionPerformed
        control.cleanGui();
    }//GEN-LAST:event_btn_cleanActionPerformed

    private void btn_adjacentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adjacentActionPerformed
        GuiAdjacent adjacent = new GuiAdjacent(control);
        adjacent.setVisible(true);
    }//GEN-LAST:event_btn_adjacentActionPerformed

    private void btn_load_mapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_load_mapActionPerformed
        control.cleanGui();
        control.setList(new ParanaState().getListAdjacency());
        control.updateGui();
    }//GEN-LAST:event_btn_load_mapActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add_link;
    private javax.swing.JButton btn_add_vertex;
    private javax.swing.JButton btn_adjacent;
    private javax.swing.JButton btn_clean;
    private javax.swing.JButton btn_load_map;
    private javax.swing.JButton btn_print_graph;
    private javax.swing.JButton btn_remove_link;
    private javax.swing.JButton btn_remove_vertex;
    private javax.swing.JButton btn_switch_link;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JPanel panel_text;
    private javax.swing.JScrollPane scroll_1;
    private javax.swing.JScrollPane scroll_2;
    private javax.swing.JScrollPane scroll_3;
    private javax.swing.JScrollPane scroll_5;
    private javax.swing.JScrollPane scroll_6;
    private javax.swing.JToolBar.Separator separator01;
    private javax.swing.JToolBar.Separator separator02;
    private javax.swing.JSplitPane split_1;
    private javax.swing.JSplitPane split_2;
    private javax.swing.JSplitPane split_3;
    private javax.swing.JSplitPane split_4;
    private javax.swing.JTextArea text_a_star;
    private javax.swing.JTextArea text_floyd_warshall;
    private javax.swing.JTextArea text_list_adjacency;
    private javax.swing.JTextArea text_matrix_adjacency;
    private javax.swing.JTextArea text_matrix_incidence;
    private javax.swing.JToolBar toolbar;
    // End of variables declaration//GEN-END:variables

}
