/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lantis.kolera.component.renderer;

import java.awt.Component;
import java.io.File;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Adem
 */
public class ListCustomCellRenderer extends DefaultListCellRenderer {

    public ListCustomCellRenderer() {
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        JLabel leftLabel = (JLabel) c;
        File file = (File) value;
        leftLabel.setText(FileSystemView.getFileSystemView().getSystemDisplayName(file));
        leftLabel.setIcon(FileSystemView.getFileSystemView().getSystemIcon(file));
        leftLabel.setBorder(new EmptyBorder(3, 3, 3, 3));
        return leftLabel;
    }
}
