package model;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CmsKeyDto(String key, String value, LocalDateTime ValidFrom, CmsKeyDto child, int children,
                        CmsKeyDto parent) {
}
