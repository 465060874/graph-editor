/*
 * Copyright (C) 2005 - 2014 by TESIS DYNAware GmbH
 */
package de.tesis.dynaware.grapheditor.demo.tree.skins;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import de.tesis.dynaware.grapheditor.GTailSkin;
import de.tesis.dynaware.grapheditor.demo.GraphEditorDemo;
import de.tesis.dynaware.grapheditor.model.GConnector;
import de.tesis.dynaware.grapheditor.utils.Arrow;

/**
 * Tail skin for the 'tree-like' graph. Pretty much just an arrow.
 *
 * <p>
 * Not part of the graph editor library, only used in the {@link GraphEditorDemo} application.
 * </p>
 */
public class TreeTailSkin extends GTailSkin {

    private static final String STYLE_CLASS = "tree-tail";
    private static final double OFFSET_DISTANCE = 15;

    private final Arrow arrow = new Arrow();

    public TreeTailSkin(final GConnector connector) {

        super(connector);

        arrow.getStyleClass().add(STYLE_CLASS);
    }

    @Override
    public Node getRoot() {
        return arrow;
    }

    @Override
    public void draw(final Point2D start, final Point2D end) {
        drawArrow(start, end);
    }

    @Override
    public void draw(final Point2D start, final Point2D end, final List<Point2D> jointPositions) {
        drawArrow(start, end);
    }

    @Override
    public List<Point2D> allocateJointPositions() {
        return new ArrayList<Point2D>();
    }

    @Override
    public void setEndpointVisible(final boolean visible) {
    }

    private void drawArrow(final Point2D start, final Point2D end) {

        if (getConnector().getType().equals(TreeSkinConstants.TREE_OUTPUT)) {
            ArrowUtils.draw(arrow, start, end, OFFSET_DISTANCE);
        } else {
            ArrowUtils.draw(arrow, end, start, OFFSET_DISTANCE);
        }
    }
}