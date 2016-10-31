package rUBERn.Menus;

// Created by nico on 10/23/16.

public abstract class OptionsMenu extends Menu{
    private String title;
    private String options[];

    public OptionsMenu(String title, String... options) {
        this.title = title;
        this.options = options;
    }

    @Override
    public void drawTitle() {
        System.out.println(title);
    }

    @Override
    public void drawContent() {
        int i =0;

        for(;i<options.length;i++) {
            System.out.println( (i+1) + options[i]);
        }
    }
}
