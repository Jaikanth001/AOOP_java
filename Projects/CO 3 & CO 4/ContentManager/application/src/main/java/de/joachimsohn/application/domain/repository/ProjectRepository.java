package de.joachimsohn.application.domain.repository;


import de.joachimsohn.application.domain.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {

}
