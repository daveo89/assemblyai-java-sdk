/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.resources.transcripts.types;

import com.assemblyai.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = WordSearchMatch.Builder.class)
public final class WordSearchMatch {
    private final String text;

    private final int count;

    private final List<List<Integer>> timestamps;

    private final List<Integer> indexes;

    private final Map<String, Object> additionalProperties;

    private WordSearchMatch(
            String text,
            int count,
            List<List<Integer>> timestamps,
            List<Integer> indexes,
            Map<String, Object> additionalProperties) {
        this.text = text;
        this.count = count;
        this.timestamps = timestamps;
        this.indexes = indexes;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The matched word
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * @return The total amount of times the word is in the transcript
     */
    @JsonProperty("count")
    public int getCount() {
        return count;
    }

    /**
     * @return An array of timestamps
     */
    @JsonProperty("timestamps")
    public List<List<Integer>> getTimestamps() {
        return timestamps;
    }

    /**
     * @return An array of all index locations for that word within the <code>words</code> array of the completed transcript
     */
    @JsonProperty("indexes")
    public List<Integer> getIndexes() {
        return indexes;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof WordSearchMatch && equalTo((WordSearchMatch) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(WordSearchMatch other) {
        return text.equals(other.text)
                && count == other.count
                && timestamps.equals(other.timestamps)
                && indexes.equals(other.indexes);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.text, this.count, this.timestamps, this.indexes);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TextStage builder() {
        return new Builder();
    }

    public interface TextStage {
        CountStage text(@NotNull String text);

        Builder from(WordSearchMatch other);
    }

    public interface CountStage {
        _FinalStage count(int count);
    }

    public interface _FinalStage {
        WordSearchMatch build();

        _FinalStage timestamps(List<List<Integer>> timestamps);

        _FinalStage addTimestamps(List<Integer> timestamps);

        _FinalStage addAllTimestamps(List<List<Integer>> timestamps);

        _FinalStage indexes(List<Integer> indexes);

        _FinalStage addIndexes(Integer indexes);

        _FinalStage addAllIndexes(List<Integer> indexes);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TextStage, CountStage, _FinalStage {
        private String text;

        private int count;

        private List<Integer> indexes = new ArrayList<>();

        private List<List<Integer>> timestamps = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(WordSearchMatch other) {
            text(other.getText());
            count(other.getCount());
            timestamps(other.getTimestamps());
            indexes(other.getIndexes());
            return this;
        }

        /**
         * <p>The matched word</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("text")
        public CountStage text(@NotNull String text) {
            this.text = Objects.requireNonNull(text, "text must not be null");
            return this;
        }

        /**
         * <p>The total amount of times the word is in the transcript</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("count")
        public _FinalStage count(int count) {
            this.count = count;
            return this;
        }

        /**
         * <p>An array of all index locations for that word within the <code>words</code> array of the completed transcript</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addAllIndexes(List<Integer> indexes) {
            this.indexes.addAll(indexes);
            return this;
        }

        /**
         * <p>An array of all index locations for that word within the <code>words</code> array of the completed transcript</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addIndexes(Integer indexes) {
            this.indexes.add(indexes);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "indexes", nulls = Nulls.SKIP)
        public _FinalStage indexes(List<Integer> indexes) {
            this.indexes.clear();
            this.indexes.addAll(indexes);
            return this;
        }

        /**
         * <p>An array of timestamps</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addAllTimestamps(List<List<Integer>> timestamps) {
            this.timestamps.addAll(timestamps);
            return this;
        }

        /**
         * <p>An array of timestamps</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addTimestamps(List<Integer> timestamps) {
            this.timestamps.add(timestamps);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "timestamps", nulls = Nulls.SKIP)
        public _FinalStage timestamps(List<List<Integer>> timestamps) {
            this.timestamps.clear();
            this.timestamps.addAll(timestamps);
            return this;
        }

        @java.lang.Override
        public WordSearchMatch build() {
            return new WordSearchMatch(text, count, timestamps, indexes, additionalProperties);
        }
    }
}
