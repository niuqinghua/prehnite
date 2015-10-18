package dream.prehnite.web.tiles.sample.view;

import dream.prehnite.web.tiles.sample.vo.menu.MenuItem;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by niuqinghua on 15/8/24.
 */
@Component("viewPreparerSample")
public class ViewPreparerSample implements ViewPreparer {

    @Override
    public void execute(Request request, AttributeContext attributeContext) {
        Map<String, Object> requestScope = request.getContext(Request.REQUEST_SCOPE);
        List<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem("Home", "/home"));
        menu.add(new MenuItem("About", "/about"));
        requestScope.put("menu", menu);
    }

}
