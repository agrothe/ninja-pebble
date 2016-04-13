package filters;

import com.mitchellbosecke.pebble.extension.Filter;

import java.util.List;
import java.util.Map;

public class MyUpperFilter implements Filter {

  @Override
  public List<String> getArgumentNames() {
    return null;
  }

  @Override
  public Object apply(Object input, Map<String, Object> args){
    if(input == null){
      return null;
    }
    String str = (String) input;
    return str.toUpperCase();
  }

}