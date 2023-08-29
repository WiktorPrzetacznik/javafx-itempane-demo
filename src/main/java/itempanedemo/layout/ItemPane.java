package itempanedemo.layout;

import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Rectangle;

public class ItemPane extends FlowPane {

    public static final double DEFAULT_HGAP = 10.0,
            DEFAULT_VGAP = 10.0,
            DEFAULT_ITEM_WIDTH = 250.0;

    private final double hgap, vgap, itemWidth;

    public ItemPane() {
        this(DEFAULT_HGAP, DEFAULT_VGAP, DEFAULT_ITEM_WIDTH);
    }

    public ItemPane(Node... nodes) {
        this(DEFAULT_HGAP, DEFAULT_VGAP, DEFAULT_ITEM_WIDTH, nodes);
    }

    public ItemPane(double hgap,
                            double vgap,
                            double itemWidth,
                            Node... nodes) {
        setHgap(this.hgap = hgap);
        setVgap(this.vgap = vgap);
        this.itemWidth = itemWidth;
        initResizing();
        getChildren().addAll(nodes);
        initItemsAddition(); //test/debug only
    }

    //-----ITEM ADDITION - TEST/DEBUG ONLY

    private void initItemsAddition() {
        setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                Rectangle tile = new Rectangle();
                tile.setWidth(250.0);
                tile.setHeight(350.0);

                getChildren().add(tile);
                adjustSize(getWidth());
            } else {
                if (!getChildren().isEmpty()) {
                    getChildren().remove(getChildren().size() - 1);
                    adjustSize(getWidth());
                }
            }
        });
    }

    //-----PRIVATE

    private void initResizing() {
        widthProperty().addListener(((observable, oldValue, newValue) -> adjustSize(newValue.doubleValue())));
        getChildren().addListener((ListChangeListener<? super Node>) change -> {
            while (change.next()) {
                if (change.wasPermutated()) {
                    return;
                } else {
                    adjustSize(getWidth());
                }
            }
        });
    }

    private void adjustSize(double width) {
        int fittingTiles =  getFittingTiles(width);
        int allTiles = getChildren().size();
        int tiles = Math.min(allTiles, fittingTiles);
        if (tiles < 1)
            return;
        double sidePadding = (width - getTilesWidth(tiles)) / 2;
        setPadding(new Insets(getPadding().getTop(), sidePadding,
                getPadding().getBottom(), sidePadding));
    }

    private double getTilesWidth(int tiles) {
        return itemWidth + (--tiles * (itemWidth + hgap));
    }

    private int getFittingTiles(double width) {
        return ((int) ((width - itemWidth) / (itemWidth + hgap))) + 1;
    }

}