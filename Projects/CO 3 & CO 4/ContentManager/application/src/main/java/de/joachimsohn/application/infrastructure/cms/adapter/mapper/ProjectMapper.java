package de.joachimsohn.application.infrastructure.cms.adapter.mapper;

import de.joachimsohn.application.domain.model.Project;
import model.ProjectDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.TreeSet;

@Component
public final class ProjectMapper {

    public @NotNull Project toDomain(final @NotNull ProjectDto source) {
        return Project.builder()
                .name(source.name())
                .environments(new TreeSet<>())
                .build();
    }

    public @NotNull ProjectDto toDto(final @NotNull Project source) {
        return ProjectDto.builder()
                .id(source.getId())
                .name(source.getName())
                .environments(new TreeSet<>())
                .build();
    }
}
