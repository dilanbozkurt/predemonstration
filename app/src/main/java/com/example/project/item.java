package com.example.project;

public class item {
    int background;
    String titleName;
    int btn_click;


    public item(int background, String titleName) {
        this.background = background;
        this.titleName = titleName;
    }

    public int getBtn_click() {
        return btn_click;
    }

    public void setBtn_click(int btn_click) {
        this.btn_click = btn_click;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
}
