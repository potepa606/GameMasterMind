package GUI.widnowsSize;

public enum Size {

     WINDOW_WIDTH(850), WINDOW_HEIGHT(700);

     int size;
    Size(int i) {
        this.size = i;
    }

    public int getSize() {
        return size;
    }
}
