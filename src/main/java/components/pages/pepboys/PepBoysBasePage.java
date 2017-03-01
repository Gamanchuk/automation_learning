package components.pages.pepboys;

import components.Component;

public abstract class PepBoysBasePage extends Component {
    public final String BASE_URL = "https://mstage.stage.pepboys.com/";
    public final String COOKIES = "?_mwexperienceid=75b123b0-6444-4893-9825-1303473bc59f";
    public final String START_URL = BASE_URL + COOKIES;
}
