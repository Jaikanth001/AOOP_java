package model;

import lombok.Builder;

import java.util.SortedSet;
import java.util.UUID;

@Builder
public record ProjectDto(UUID id, String name, SortedSet<EnvironmentDto> environments) {
}
