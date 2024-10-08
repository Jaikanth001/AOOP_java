package de.joachimsohn.application.domain.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class CmsKey {

    @Id
    @NotNull
    @Column(name = "cmskeyId")
    private String key;

    @NotNull
    @Column(name = "cmskeyValue")
    private String value;

    @Nullable
    @Column
    private LocalDateTime ValidFrom;

    @Nullable
    @OneToOne
    private CmsKey child;

    @Nullable
    @OneToOne
    private CmsKey parent;

    /**
     * the child always has to be in the future to be a valid recursion, that will only be replaced
     *
     * @param child the child to be added to this CmsKey
     * @throws NotAssignableError is thrown when the parent has no validity period or when the parents validity period is in the future of the child, which is not allowed.
     */
    public void setChild(final @NotNull CmsKey child) throws NotAssignableError {
        if (parent == null) {
            this.child = child;
        } else {
            if (parent.ValidFrom != null && parent.ValidFrom.isBefore(child.ValidFrom)) {
                this.child = child;
            } else {
                throw new NotAssignableError();
            }
        }
    }


    public static class NotAssignableError extends Throwable {

    }
}
