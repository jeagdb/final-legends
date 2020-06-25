package utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public final class IterableUtils {

    private IterableUtils() {}

    public static <ELEM_TYPE> List<ELEM_TYPE> toList(final Iterable<ELEM_TYPE> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}