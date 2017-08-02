package com.tusharjoshi.javatools.objectfactory;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ParameterJoiner {

  private static final String COMMA = ", ";

  private static final String CLOSE_PAREN = ")";

  private static final String OPEN_PAREN = "(";

  protected ParameterJoiner() {
    // utility class
  }

  public static <T> String join(T[] items, Function<T, String> mapper) {
    StringBuilder buffer = new StringBuilder();
    buffer.append(OPEN_PAREN);
    buffer.append(
        Arrays.stream(items)
          .map(mapper)
          .collect(Collectors.joining(COMMA))
    );
    buffer.append(CLOSE_PAREN);
    return buffer.toString();
  }
}
