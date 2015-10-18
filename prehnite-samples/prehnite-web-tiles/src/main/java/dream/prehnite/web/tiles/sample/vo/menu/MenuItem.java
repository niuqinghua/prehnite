package dream.prehnite.web.tiles.sample.vo.menu;

/**
 * Created by niuqinghua on 15/8/24.
 */
public class MenuItem {

    private String url;

    private String caption;

    public MenuItem(String caption, String url) {
        this.caption = caption;
        this.url = url;
    }

    public String getUrl() {return url;}

    public String getCaption() {return caption;}

    @Override
    public String toString() {
        return "MenuItem{" +
                "url='" + url + '\'' +
                ", caption='" + caption + '\'' +
                '}';
    }
}
