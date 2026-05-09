package com.bootcamp.tw.p4;

public class Assistant implements Viewer {
    private String status;

    public Assistant(String status) {
        this.status = status;
    }

    @Override
    public void updateView(View view) {
        status = view.viewStatus();
    }

    public String view() {
        return status;
    }
}
