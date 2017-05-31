package entities.pages;

import entities.Entity;
import utils.Config;

public abstract class BasePage extends Entity {
    public final String BASE_URL = Config.BASE_URL;
    public final String COOKIES = Config.COOKIES;
}
