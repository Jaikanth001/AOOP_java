package de.joachimsohn.application.infrastructure.cms.adapter;

import de.joachimsohn.application.domain.ProjectService;
import de.joachimsohn.application.infrastructure.cms.adapter.mapper.ProjectMapper;
import lombok.RequiredArgsConstructor;
import model.ProjectDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public final class ProjectWebAdapter {

    private final ProjectService service;
    private final ProjectMapper mapper;

    public @NotNull List<ProjectDto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public @NotNull ProjectDto save(final @NotNull ProjectDto project) {
        return mapper.toDto(service.save(mapper.toDomain(project)));
    }

    public boolean delete(final @NotNull UUID id) {
        return service.findById(id)
                .map(service::delete)
                .orElse(false);
    }
}
