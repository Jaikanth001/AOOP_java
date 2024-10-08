package model;

import lombok.Builder;

import java.util.List;

@Builder
public record EnvironmentDto(String name, int order, List<CmsKeyDto> keys) implements Comparable<EnvironmentDto> {

    @Override public int compareTo(final EnvironmentDto other) {
        return Integer.compare(order, other.order);
    }
}
