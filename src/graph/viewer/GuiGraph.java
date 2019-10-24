package graph.viewer;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import graph.Link;
import graph.ParanaState;
import graph.Vertex;
import graph.viewer.GuiAdjacent;
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

    public JButton getBtn_add_link() {
        return btn_add_link;
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

    public JTextArea getText_list_adjacency() {
        return text_list_adjacency;
    }

    public JTextArea getText_matrix_adjacency() {
        return text_matrix_adjacency;
    }

    public JTextArea getText_matrix_incidence() {
        return text_matrix_incidence;
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
        btn_print_prim = new javax.swing.JButton();
        btn_print_bfs = new javax.swing.JButton();
        btn_print_dfs = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btn_load_map = new javax.swing.JButton();
        panel_text = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text_matrix_adjacency = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        text_matrix_incidence = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
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

        btn_print_prim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graph/img/prim.png"))); // NOI18N
        btn_print_prim.setFocusable(false);
        btn_print_prim.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_print_prim.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_print_prim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_print_primActionPerformed(evt);
            }
        });
        toolbar.add(btn_print_prim);

        btn_print_bfs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graph/img/bfs.png"))); // NOI18N
        btn_print_bfs.setFocusable(false);
        btn_print_bfs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_print_bfs.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_print_bfs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_print_bfsActionPerformed(evt);
            }
        });
        toolbar.add(btn_print_bfs);

        btn_print_dfs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graph/img/dfs.png"))); // NOI18N
        btn_print_dfs.setFocusable(false);
        btn_print_dfs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_print_dfs.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_print_dfs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_print_dfsActionPerformed(evt);
            }
        });
        toolbar.add(btn_print_dfs);
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

        text_matrix_adjacency.setEditable(false);
        text_matrix_adjacency.setColumns(20);
        text_matrix_adjacency.setRows(5);
        text_matrix_adjacency.setBorder(javax.swing.BorderFactory.createTitledBorder("Matriz de Adjacência"));
        jScrollPane1.setViewportView(text_matrix_adjacency);

        text_matrix_incidence.setEditable(false);
        text_matrix_incidence.setColumns(20);
        text_matrix_incidence.setRows(5);
        text_matrix_incidence.setBorder(javax.swing.BorderFactory.createTitledBorder("Matriz de Incidência"));
        jScrollPane2.setViewportView(text_matrix_incidence);

        text_list_adjacency.setEditable(false);
        text_list_adjacency.setColumns(20);
        text_list_adjacency.setRows(5);
        text_list_adjacency.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Adjacência"));
        jScrollPane3.setViewportView(text_list_adjacency);

        javax.swing.GroupLayout panel_textLayout = new javax.swing.GroupLayout(panel_text);
        panel_text.setLayout(panel_textLayout);
        panel_textLayout.setHorizontalGroup(
            panel_textLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_textLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panel_textLayout.setVerticalGroup(
            panel_textLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolbar, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 310, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addComponent(panel_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void btn_print_primActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_print_primActionPerformed
        control.printPrim();
    }//GEN-LAST:event_btn_print_primActionPerformed

    private void btn_remove_vertexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_remove_vertexActionPerformed
        control.removeVertex();
    }//GEN-LAST:event_btn_remove_vertexActionPerformed

    private void btn_remove_linkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_remove_linkActionPerformed
       control.removeLink();
    }//GEN-LAST:event_btn_remove_linkActionPerformed

    private void btn_cleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cleanActionPerformed
        control.cleanGui();
    }//GEN-LAST:event_btn_cleanActionPerformed

    private void btn_print_bfsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_print_bfsActionPerformed
        control.printBFS();
    }//GEN-LAST:event_btn_print_bfsActionPerformed

    private void btn_print_dfsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_print_dfsActionPerformed
        control.printDFS();
    }//GEN-LAST:event_btn_print_dfsActionPerformed

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
    private javax.swing.JButton btn_print_bfs;
    private javax.swing.JButton btn_print_dfs;
    private javax.swing.JButton btn_print_graph;
    private javax.swing.JButton btn_print_prim;
    private javax.swing.JButton btn_remove_link;
    private javax.swing.JButton btn_remove_vertex;
    private javax.swing.JButton btn_switch_link;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JPanel panel_text;
    private javax.swing.JToolBar.Separator separator01;
    private javax.swing.JToolBar.Separator separator02;
    private javax.swing.JTextArea text_list_adjacency;
    private javax.swing.JTextArea text_matrix_adjacency;
    private javax.swing.JTextArea text_matrix_incidence;
    private javax.swing.JToolBar toolbar;
    // End of variables declaration//GEN-END:variables

}
