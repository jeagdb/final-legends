package utils;

import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
public interface Converter<FROM_TYPE, TO_TYPE> {
    TO_TYPE convert(final FROM_TYPE from);

    default List<TO_TYPE> convertList(final List<FROM_TYPE> fromList) {
        return fromList.stream().map(this::convert).collect(Collectors.toList());
    }

    interface Reversible<FROM_TYPE, TO_TYPE> extends Converter<FROM_TYPE, TO_TYPE> {
        FROM_TYPE revertConvert(final TO_TYPE from);
    }
}
