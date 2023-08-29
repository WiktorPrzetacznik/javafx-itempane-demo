# ItemPane demo

A simple demo project presenting a specialized implementation of `javafx.scene.layout.FlowPane` that allows content to be dynamically centered ([unlike original Flowpane](https://stackoverflow.com/questions/43747405/javafx-aligning-all-content-in-a-flowpane)).

## How does it look like? 

![image](https://github.com/WiktorPrzetacznik/javafx-itempane-demo/blob/main/image.gif)

## Note

This implementation calculates items position dynamically based on `itemWidth` provided via constructor (250 px is chosen if not provided). That means, to ensure correct positioning, all items contained in `ItemPane` should be sized equally to `itemWidth`. Feel free to reimplement it.
