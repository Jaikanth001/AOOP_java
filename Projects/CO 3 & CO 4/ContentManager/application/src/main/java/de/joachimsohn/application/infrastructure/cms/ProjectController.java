package de.joachimsohn.application.infrastructure.cms;

import de.joachimsohn.application.infrastructure.cms.adapter.ProjectWebAdapter;
import lombok.RequiredArgsConstructor;
import model.CmsKeyDto;
import model.EnvironmentDto;
import model.ProjectDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.TreeSet;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/projects/")
public final class ProjectController {

    private final ProjectWebAdapter adapter;

    @GetMapping
    public @NotNull ResponseEntity<List<ProjectDto>> loadAll() {
        var result = adapter.findAll();
        result.add(createRandom());
        return ResponseEntity.ok(result);
    }

    @PutMapping
    public @NotNull ResponseEntity<ProjectDto> save(@RequestBody final @NotNull ProjectDto project) {
        return ResponseEntity.ok(adapter.save(project));
    }

    @DeleteMapping(path = "/{id}")
    public @NotNull ResponseEntity<Boolean> delete(@PathVariable final @NotNull UUID id) {
        var result = adapter.delete(id);
        return ResponseEntity.status(result ? HttpStatus.OK : HttpStatus.BAD_REQUEST).build();
    }


    private ProjectDto createRandom() {
        return ProjectDto.builder()
                .id(UUID.randomUUID())
                .name("test").environments(new TreeSet<>() {{
                    add(EnvironmentDto.builder().name("dev").order(0).keys(List.of(CmsKeyDto.builder().key("just keying").value("my Value").build())).build());
                    add(EnvironmentDto.builder().name("qa").order(1).keys(List.of()).build());
                    add(EnvironmentDto.builder().name("prod").order(3).keys(List.of()).build());
                }}).build();
    }

}
