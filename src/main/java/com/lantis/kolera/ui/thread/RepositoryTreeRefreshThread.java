/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lantis.kolera.ui.thread;

import com.lantis.kolera.ui.component.RepositoryTree;
import com.lantis.kolera.db.entity.RepositoryInfo;
import com.lantis.kolera.service.RepositoryService;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
/**
 *
 * @author 1001299
 */
public class RepositoryTreeRefreshThread extends Thread {

    private RepositoryTree repositoryTree;
    
    public RepositoryTreeRefreshThread(RepositoryTree repositoryTree) {
        this.repositoryTree = repositoryTree;
    }

    @Override
    public void run() {
        loadRepositories();
    }

    private void loadRepositories() {
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)repositoryTree.getModel().getRoot();
        root.removeAllChildren();
        RepositoryService repositoryService = new RepositoryService();
        List<RepositoryInfo> repositoryList = repositoryService.retrieveRepositories();
        for (RepositoryInfo repository : repositoryList) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode();
            node.setUserObject(repository);
            root.add(node);
        }
        DefaultTreeModel model = (DefaultTreeModel) (repositoryTree.getModel());
        model.reload();
    }
    
}
