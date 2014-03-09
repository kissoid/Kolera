/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lantis.kolera.ui.component;

/**
 *
 * @author Adem
 */
import com.lantis.kolera.ui.component.filter.GitDirectoryFilter;
import com.lantis.kolera.ui.component.renderer.DetailedListCustomCellRenderer;
import com.lantis.kolera.db.entity.RepositoryInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.AbstractListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

/**
 * This code uses a JList in two forms (layout orientation vertical & horizontal
 * wrap) to display a File[]. The renderer displays the file icon obtained from
 * FileSystemView.
 *
 * @param <T>
 */
public class FileList<T> extends JList {

    private File currentDirectory;
    private JTextField pathComponent;
    private RepositoryInfo selectedRepositoryInfo;

    public FileList(JTextField pathComponent) {
        this.pathComponent = pathComponent;
        init();
    }

    public FileList() {
        init();
    }

    private void init() {
        //setCellRenderer(new ListCustomCellRenderer());
        setCellRenderer(new DetailedListCustomCellRenderer());

        setLayoutOrientation(javax.swing.JList.VERTICAL);
        setVisibleRowCount(-1);
        addMouseListener(createMouseListener());
        addKeyListener(createKeyListener());
        File file = FileSystemView.getFileSystemView().getDefaultDirectory();
        listFiles(file);
    }

    private MouseListener createMouseListener() {
        return new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() != 2) {
                    return;
                }
                checkFileBeforeList();
            }
        };
    }

    private KeyListener createKeyListener() {
        return new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                switch (KeyEvent.getKeyText(evt.getKeyCode())) {
                    case "Enter":
                        checkFileBeforeList();
                        break;
                    case "Backspace":
                        moveToUpDirectory();
                        break;
                }
            }
        };
    }

    public File[] listFiles(File directory) {

        final File[] directoryItemList = directory.listFiles(new GitDirectoryFilter());
        if (directoryItemList == null) {
            JOptionPane.showMessageDialog(null, "Could not acces to directory.");
            return directoryItemList;
        }
        this.setModel(new AbstractListModel<File>() {
            @Override
            public int getSize() {
                return directoryItemList.length;
            }

            @Override
            public File getElementAt(int i) {
                return directoryItemList[i];
            }
        });
        currentDirectory = directory;
        changePathComponentText(currentDirectory.getAbsolutePath());

        return directoryItemList;
    }

    private void checkFileBeforeList() {
        try {
            if (getSelectedValue() == null) {
                return;
            }

            File file = (File) getSelectedValue();

            if (!file.isDirectory()) {
                return;
            }

            if (!FileSystemView.getFileSystemView().isTraversable(file)) {
                JOptionPane.showMessageDialog(null, "Could not acces to directory.");
                return;
            }

            listFiles(file);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void moveToUpDirectory() {
        try {
            if (currentDirectory == null) {
                return;
            }
            if (currentDirectory.getParentFile() == null) {
                return;
            }
            if (FileSystemView.getFileSystemView().isRoot(currentDirectory)) {
                return;
            }
            if (currentDirectory.getAbsolutePath().equals(selectedRepositoryInfo.getRepositoryPath())) {
                return;
            }
            listFiles(currentDirectory.getParentFile());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void changePathComponentText(String path){
        if (pathComponent != null && selectedRepositoryInfo != null) {
            String repositoryText = selectedRepositoryInfo.getRepositoryName() + ":";
            path = path.replace(selectedRepositoryInfo.getRepositoryPath(), repositoryText);
            pathComponent.setText(path);
        }
    }
    
    public File getCurrentDirectory() {
        return currentDirectory;
    }

    public void setCurrentDirectory(File currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    public JTextField getPathComponent() {
        return pathComponent;
    }

    public void setPathComponent(JTextField pathComponent) {
        this.pathComponent = pathComponent;
    }

    public RepositoryInfo getSelectedRepositoryInfo() {
        return selectedRepositoryInfo;
    }

    public void setSelectedRepositoryInfo(RepositoryInfo selectedRepositoryInfo) {
        this.selectedRepositoryInfo = selectedRepositoryInfo;
    }

}
