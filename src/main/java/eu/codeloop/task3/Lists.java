package eu.codeloop.task3;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

public final class Lists {

    private Lists() {
    }

    public static <K, V> Map<K, V> mapBy(Collection<V> collection, Function<? super V, ? extends K> mapper) {
        throw new UnsupportedOperationException("TODO");
    }
}
