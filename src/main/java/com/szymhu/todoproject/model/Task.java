package com.szymhu.todoproject.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder
public record Task(UUID id, String name, boolean done, String description) {}
