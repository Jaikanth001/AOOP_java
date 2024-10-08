package de.joachimsohn.application.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.SortedSet;
import java.util.UUID;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Builder
@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Project {

    @Id
    @Builder.Default
    private UUID id = UUID.randomUUID();

    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = {MERGE, PERSIST}, targetEntity = Environment.class)
    private SortedSet<Environment> environments;


}
