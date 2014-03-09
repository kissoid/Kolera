/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lantis.kolera.ui.model;

import java.util.Map;
import java.util.Set;
import org.eclipse.jgit.lib.IndexDiff.StageState;

/**
 *
 * @author Adem
 */
public class RepositoryStatus {

    private Set<String> addedItems;
    private Set<String> changedItems;
    private Set<String> conflictingItems;
    private Map<String, StageState> conflictingStageStateItems;
    private Set<String> ignoredNotInIndexItems;
    private Set<String> missingItems;
    private Set<String> modifiedItems;
    private Set<String> removedItems;
    private Set<String> untrackedItems;
    private Set<String> untrackedFolders;

    public RepositoryStatus() {

    }

    public Set<String> getAddedItems() {
        return addedItems;
    }

    public void setAddedItems(Set<String> addedItems) {
        this.addedItems = addedItems;
    }

    public Set<String> getChangedItems() {
        return changedItems;
    }

    public void setChangedItems(Set<String> changedItems) {
        this.changedItems = changedItems;
    }

    public Set<String> getConflictingItems() {
        return conflictingItems;
    }

    public void setConflictingItems(Set<String> conflictingItems) {
        this.conflictingItems = conflictingItems;
    }

    public Map<String, StageState> getConflictingStageStateItems() {
        return conflictingStageStateItems;
    }

    public void setConflictingStageStateItems(Map<String, StageState> conflictingStageStateItems) {
        this.conflictingStageStateItems = conflictingStageStateItems;
    }

    public Set<String> getIgnoredNotInIndexItems() {
        return ignoredNotInIndexItems;
    }

    public void setIgnoredNotInIndexItems(Set<String> ignoredNotInIndexItems) {
        this.ignoredNotInIndexItems = ignoredNotInIndexItems;
    }

    public Set<String> getMissingItems() {
        return missingItems;
    }

    public void setMissingItems(Set<String> missingItems) {
        this.missingItems = missingItems;
    }

    public Set<String> getModifiedItems() {
        return modifiedItems;
    }

    public void setModifiedItems(Set<String> modifiedItems) {
        this.modifiedItems = modifiedItems;
    }

    public Set<String> getRemovedItems() {
        return removedItems;
    }

    public void setRemovedItems(Set<String> removedItems) {
        this.removedItems = removedItems;
    }

    public Set<String> getUntrackedItems() {
        return untrackedItems;
    }

    public void setUntrackedItems(Set<String> untrackedItems) {
        this.untrackedItems = untrackedItems;
    }

    public Set<String> getUntrackedFolders() {
        return untrackedFolders;
    }

    public void setUntrackedFolders(Set<String> untrackedFolders) {
        this.untrackedFolders = untrackedFolders;
    }

}
