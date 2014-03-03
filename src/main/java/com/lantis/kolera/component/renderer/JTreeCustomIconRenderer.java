/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lantis.kolera.component.renderer;

import com.lantis.kolera.db.entity.Repository;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author 1001299
 */
public class JTreeCustomIconRenderer extends DefaultTreeCellRenderer {

    private ImageIcon specialIcon;

    public JTreeCustomIconRenderer() {
        specialIcon = new ImageIcon(JTreeCustomIconRenderer.class.getResource("/com/lantis/kolera/icon/repository.png"));
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) value;
        Object node = currentNode.getUserObject();
        if (node != null) {
            if (node instanceof Repository) {
                setIcon(specialIcon);
                Repository repository = (Repository)node;
                setText(repository.getRepositoryName());
            }
        }
        return this;
    }
}