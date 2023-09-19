/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.types;

import com.assemblyai.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Entity.Builder.class)
public final class Entity {
    private final String entityType;

    private final String text;

    private final int start;

    private final int end;

    private Entity(String entityType, String text, int start, int end) {
        this.entityType = entityType;
        this.text = text;
        this.start = start;
        this.end = end;
    }

    /**
     * @return The type of entity for the detected entity
     */
    @JsonProperty("entity_type")
    public String getEntityType() {
        return entityType;
    }

    /**
     * @return The text for the detected entity
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * @return The starting time, in milliseconds, at which the detected entity appears in the audio file
     */
    @JsonProperty("start")
    public int getStart() {
        return start;
    }

    /**
     * @return The ending time, in milliseconds, for the detected entity in the audio file
     */
    @JsonProperty("end")
    public int getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Entity && equalTo((Entity) other);
    }

    private boolean equalTo(Entity other) {
        return entityType.equals(other.entityType)
                && text.equals(other.text)
                && start == other.start
                && end == other.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.entityType, this.text, this.start, this.end);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static EntityTypeStage builder() {
        return new Builder();
    }

    public interface EntityTypeStage {
        TextStage entityType(String entityType);

        Builder from(Entity other);
    }

    public interface TextStage {
        StartStage text(String text);
    }

    public interface StartStage {
        EndStage start(int start);
    }

    public interface EndStage {
        _FinalStage end(int end);
    }

    public interface _FinalStage {
        Entity build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements EntityTypeStage, TextStage, StartStage, EndStage, _FinalStage {
        private String entityType;

        private String text;

        private int start;

        private int end;

        private Builder() {}

        @Override
        public Builder from(Entity other) {
            entityType(other.getEntityType());
            text(other.getText());
            start(other.getStart());
            end(other.getEnd());
            return this;
        }

        /**
         * <p>The type of entity for the detected entity</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("entity_type")
        public TextStage entityType(String entityType) {
            this.entityType = entityType;
            return this;
        }

        /**
         * <p>The text for the detected entity</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("text")
        public StartStage text(String text) {
            this.text = text;
            return this;
        }

        /**
         * <p>The starting time, in milliseconds, at which the detected entity appears in the audio file</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("start")
        public EndStage start(int start) {
            this.start = start;
            return this;
        }

        /**
         * <p>The ending time, in milliseconds, for the detected entity in the audio file</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("end")
        public _FinalStage end(int end) {
            this.end = end;
            return this;
        }

        @Override
        public Entity build() {
            return new Entity(entityType, text, start, end);
        }
    }
}
