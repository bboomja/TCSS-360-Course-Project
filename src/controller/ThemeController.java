package src.controller;

import src.model.Theme;

public class ThemeController {
    private Theme currentTheme;

    public ThemeController(Theme defaultTheme) {
        this.currentTheme = defaultTheme;
    }

    public void setTheme(Theme theme) {
        this.currentTheme = theme;
    }

    public Theme getTheme() {
        return this.currentTheme;
    }
}
