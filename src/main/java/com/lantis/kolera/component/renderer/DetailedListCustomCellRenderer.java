/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lantis.kolera.component.renderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Adem
 */
public class DetailedListCustomCellRenderer extends JPanel implements ListCellRenderer {

    JLabel fileNameLabel;
    JLabel dateLabel;
    JLabel sizeLabel;
    JLabel sizeTypeLabel;

    public DetailedListCustomCellRenderer() {
        setLayout(new GridLayout(1, 3));
        fileNameLabel = new JLabel();
        dateLabel = new JLabel();
        sizeLabel = new JLabel();
        sizeTypeLabel = new JLabel();
        fileNameLabel.setOpaque(true);
        dateLabel.setOpaque(true);
        sizeLabel.setOpaque(true);
        sizeTypeLabel.setOpaque(true);
        add(fileNameLabel);
        add(dateLabel);
        add(sizeLabel);
        add(sizeTypeLabel);
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        File file = (File) value;

        fileNameLabel.setText(FileSystemView.getFileSystemView().getSystemDisplayName(file));
        fileNameLabel.setIcon(FileSystemView.getFileSystemView().getSystemIcon(file));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date lastModifiedDate = new Date(file.lastModified());
        dateLabel.setText(simpleDateFormat.format(lastModifiedDate));

        if (!file.isDirectory()) {
            double fileSize = file.length() / 1024;
            sizeLabel.setText(String.format("%.2f", fileSize));
            sizeTypeLabel.setText(" kb");
            if (fileSize > 1024) {
                fileSize = fileSize / 1024;
                sizeLabel.setText(String.format("%.2f", fileSize));
                sizeTypeLabel.setText(" mb");
            }
            if (fileSize > 1024) {
                fileSize = fileSize / 1024;
                sizeLabel.setText(String.format("%.2f", fileSize));
                sizeTypeLabel.setText(" gb");
            }
        } else {
            sizeLabel.setText(" ");
            sizeTypeLabel.setText(" ");
        }

        fileNameLabel.setHorizontalAlignment(JLabel.LEFT);
        fileNameLabel.setPreferredSize(new Dimension(150, sizeLabel.getPreferredSize().height));

        dateLabel.setHorizontalAlignment(JLabel.RIGHT);
        dateLabel.setPreferredSize(new Dimension(100, sizeLabel.getPreferredSize().height));

        sizeLabel.setHorizontalAlignment(JLabel.RIGHT);
        sizeLabel.setPreferredSize(new Dimension(100, sizeLabel.getPreferredSize().height));

        sizeTypeLabel.setHorizontalAlignment(JLabel.LEFT);
        sizeTypeLabel.setPreferredSize(new Dimension(25, sizeLabel.getPreferredSize().height));

        if (isSelected) {
            fileNameLabel.setBackground(list.getSelectionBackground());
            fileNameLabel.setForeground(list.getSelectionForeground());
            dateLabel.setBackground(list.getSelectionBackground());
            dateLabel.setForeground(list.getSelectionForeground());
            sizeLabel.setBackground(list.getSelectionBackground());
            sizeLabel.setForeground(list.getSelectionForeground());
            sizeTypeLabel.setBackground(list.getSelectionBackground());
            sizeTypeLabel.setForeground(list.getSelectionForeground());
        } else {
            fileNameLabel.setBackground(Color.white);
            fileNameLabel.setForeground(list.getForeground());
            dateLabel.setBackground(Color.white);
            dateLabel.setForeground(list.getForeground());
            sizeLabel.setBackground(Color.white);
            sizeLabel.setForeground(list.getForeground());
            sizeTypeLabel.setBackground(Color.white);
            sizeTypeLabel.setForeground(list.getForeground());
        }
        setEnabled(list.isEnabled());
        setFont(list.getFont());
        return this;
    }
}
