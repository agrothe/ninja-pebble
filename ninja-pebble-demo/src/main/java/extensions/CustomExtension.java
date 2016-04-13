package extensions;

import com.mitchellbosecke.pebble.extension.AbstractExtension;
import com.mitchellbosecke.pebble.extension.Filter;
import filters.MyUpperFilter;

import java.util.HashMap;
import java.util.Map;

public class CustomExtension extends AbstractExtension {

  @Override
  public Map<String, Filter> getFilters() {

    Map<String, Filter> map = new HashMap<>();
    map.put("myUpper", new MyUpperFilter());

    return map;
  }
}
