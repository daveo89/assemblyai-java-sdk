/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.types;

import com.assemblyai.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TranscriptIabCategoriesResult.Builder.class)
public final class TranscriptIabCategoriesResult {
    private final AudioIntelligenceModelStatus status;

    private final List<TopicDetectionResult> results;

    private final Map<String, Double> summary;

    private TranscriptIabCategoriesResult(
            AudioIntelligenceModelStatus status, List<TopicDetectionResult> results, Map<String, Double> summary) {
        this.status = status;
        this.results = results;
        this.summary = summary;
    }

    /**
     * @return Will be either success, or unavailable in the rare case that the Content Moderation model failed.
     */
    @JsonProperty("status")
    public AudioIntelligenceModelStatus getStatus() {
        return status;
    }

    /**
     * @return An array of results for the Topic Detection model.
     */
    @JsonProperty("results")
    public List<TopicDetectionResult> getResults() {
        return results;
    }

    /**
     * @return The overall relevance of topic to the entire audio file
     */
    @JsonProperty("summary")
    public Map<String, Double> getSummary() {
        return summary;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranscriptIabCategoriesResult && equalTo((TranscriptIabCategoriesResult) other);
    }

    private boolean equalTo(TranscriptIabCategoriesResult other) {
        return status.equals(other.status) && results.equals(other.results) && summary.equals(other.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.status, this.results, this.summary);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static StatusStage builder() {
        return new Builder();
    }

    public interface StatusStage {
        _FinalStage status(AudioIntelligenceModelStatus status);

        Builder from(TranscriptIabCategoriesResult other);
    }

    public interface _FinalStage {
        TranscriptIabCategoriesResult build();

        _FinalStage results(List<TopicDetectionResult> results);

        _FinalStage addResults(TopicDetectionResult results);

        _FinalStage addAllResults(List<TopicDetectionResult> results);

        _FinalStage summary(Map<String, Double> summary);

        _FinalStage putAllSummary(Map<String, Double> summary);

        _FinalStage summary(String key, Double value);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements StatusStage, _FinalStage {
        private AudioIntelligenceModelStatus status;

        private Map<String, Double> summary = new LinkedHashMap<>();

        private List<TopicDetectionResult> results = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(TranscriptIabCategoriesResult other) {
            status(other.getStatus());
            results(other.getResults());
            summary(other.getSummary());
            return this;
        }

        /**
         * <p>Will be either success, or unavailable in the rare case that the Content Moderation model failed.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("status")
        public _FinalStage status(AudioIntelligenceModelStatus status) {
            this.status = status;
            return this;
        }

        /**
         * <p>The overall relevance of topic to the entire audio file</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage summary(String key, Double value) {
            this.summary.put(key, value);
            return this;
        }

        /**
         * <p>The overall relevance of topic to the entire audio file</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage putAllSummary(Map<String, Double> summary) {
            this.summary.putAll(summary);
            return this;
        }

        @Override
        @JsonSetter(value = "summary", nulls = Nulls.SKIP)
        public _FinalStage summary(Map<String, Double> summary) {
            this.summary.clear();
            this.summary.putAll(summary);
            return this;
        }

        /**
         * <p>An array of results for the Topic Detection model.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllResults(List<TopicDetectionResult> results) {
            this.results.addAll(results);
            return this;
        }

        /**
         * <p>An array of results for the Topic Detection model.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addResults(TopicDetectionResult results) {
            this.results.add(results);
            return this;
        }

        @Override
        @JsonSetter(value = "results", nulls = Nulls.SKIP)
        public _FinalStage results(List<TopicDetectionResult> results) {
            this.results.clear();
            this.results.addAll(results);
            return this;
        }

        @Override
        public TranscriptIabCategoriesResult build() {
            return new TranscriptIabCategoriesResult(status, results, summary);
        }
    }
}
