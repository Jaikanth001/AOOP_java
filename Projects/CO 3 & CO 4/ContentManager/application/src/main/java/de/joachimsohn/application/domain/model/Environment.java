package de.joachimsohn.application.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static java.lang.Integer.compare;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public final class Environment implements Comparable<Environment> {

    @Id
    @NotNull
    private String name;

    /**
     * Cannot be "order" due to it beiung an SQL reserved Keyword.
     */
    @Column
    private int orderNum;

    @OneToMany(fetch = FetchType.LAZY, cascade = {MERGE, PERSIST}, targetEntity = CmsKey.class)
    private List<CmsKey> keys;

    @Override
    public int compareTo(final Environment other) {
        return compare(orderNum, other.orderNum);
    }
}
