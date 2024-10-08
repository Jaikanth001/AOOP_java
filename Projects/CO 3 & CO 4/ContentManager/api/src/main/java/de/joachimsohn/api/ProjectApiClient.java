package de.joachimsohn.api;

import lombok.RequiredArgsConstructor;
import model.ProjectDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class ProjectApiClient {

    @Value("projectApiUrl")
    private static final String url = "http://localhost:8080/projects/";
    private final RestTemplate rest;
    private final Logger LOGGER = LoggerFactory.getLogger(ProjectApiClient.class);

    public ProjectDto get() {
        ProjectDto user = rest.getForObject(url, ProjectDto.class);
        LOGGER.debug("Request: {}", user);
        return user;
    }
}
