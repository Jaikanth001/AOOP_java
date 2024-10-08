package de.joachimsohn.application.domain;

import de.joachimsohn.application.domain.model.Project;
import de.joachimsohn.application.domain.repository.ProjectRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public final class ProjectService {

    private final ProjectRepository repository;

    public @NotNull List<Project> findAll() {
        return repository.findAll();
    }

    public @NotNull Project save(final @NotNull Project project) {
        return repository.save(project);
    }

    public boolean delete(final @NotNull Project project) {
        try {
            repository.delete(project);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public Optional<Project> findById(final @NotNull UUID id) {
        return repository.findById(id);
    }
}
