package eu.codeloop.task3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class Lists {

    private Lists() {
    }

    public static <K, V> Map<K, V> mapBy(Collection<V> collection, Function<? super V, ? extends K> mapper) {
        if(collection == null || mapper == null)
            throw new IllegalArgumentException();

        Map<K, V> resultMap = new HashMap<>();

        if(collection.isEmpty())
            return resultMap;

        for(V value : collection)
            resultMap.put(mapper.apply(value), value);

        return resultMap;
    }

    public static <K, V> Map<K, V> mapByV2(Collection<V> collection, Function<? super V, ? extends K> mapper) {
        if(collection == null || mapper == null)
            throw new IllegalArgumentException();
        if(collection.isEmpty())
            return new HashMap<>();
        return collection.stream().collect(Collectors.toMap(mapper, Function.identity(), (vOld, vNew) -> vNew));
    }
}