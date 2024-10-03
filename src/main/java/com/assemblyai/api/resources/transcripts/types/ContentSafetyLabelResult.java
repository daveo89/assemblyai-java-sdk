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
@JsonDeserialize(builder = ContentSafetyLabelResult.Builder.class)
public final class ContentSafetyLabelResult {
    private final String text;

    private final List<ContentSafetyLabel> labels;

    private final int sentencesIdxStart;

    private final int sentencesIdxEnd;

    private final Timestamp timestamp;

    private final Map<String, Object> additionalProperties;

    private ContentSafetyLabelResult(
            String text,
            List<ContentSafetyLabel> labels,
            int sentencesIdxStart,
            int sentencesIdxEnd,
            Timestamp timestamp,
            Map<String, Object> additionalProperties) {
        this.text = text;
        this.labels = labels;
        this.sentencesIdxStart = sentencesIdxStart;
        this.sentencesIdxEnd = sentencesIdxEnd;
        this.timestamp = timestamp;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The transcript of the section flagged by the Content Moderation model
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * @return An array of safety labels, one per sensitive topic that was detected in the section
     */
    @JsonProperty("labels")
    public List<ContentSafetyLabel> getLabels() {
        return labels;
    }

    /**
     * @return The sentence index at which the section begins
     */
    @JsonProperty("sentences_idx_start")
    public int getSentencesIdxStart() {
        return sentencesIdxStart;
    }

    /**
     * @return The sentence index at which the section ends
     */
    @JsonProperty("sentences_idx_end")
    public int getSentencesIdxEnd() {
        return sentencesIdxEnd;
    }

    /**
     * @return Timestamp information for the section
     */
    @JsonProperty("timestamp")
    public Timestamp getTimestamp() {
        return timestamp;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ContentSafetyLabelResult && equalTo((ContentSafetyLabelResult) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ContentSafetyLabelResult other) {
        return text.equals(other.text)
                && labels.equals(other.labels)
                && sentencesIdxStart == other.sentencesIdxStart
                && sentencesIdxEnd == other.sentencesIdxEnd
                && timestamp.equals(other.timestamp);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.text, this.labels, this.sentencesIdxStart, this.sentencesIdxEnd, this.timestamp);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TextStage builder() {
        return new Builder();
    }

    public interface TextStage {
        SentencesIdxStartStage text(@NotNull String text);

        Builder from(ContentSafetyLabelResult other);
    }

    public interface SentencesIdxStartStage {
        SentencesIdxEndStage sentencesIdxStart(int sentencesIdxStart);
    }

    public interface SentencesIdxEndStage {
        TimestampStage sentencesIdxEnd(int sentencesIdxEnd);
    }

    public interface TimestampStage {
        _FinalStage timestamp(@NotNull Timestamp timestamp);
    }

    public interface _FinalStage {
        ContentSafetyLabelResult build();

        _FinalStage labels(List<ContentSafetyLabel> labels);

        _FinalStage addLabels(ContentSafetyLabel labels);

        _FinalStage addAllLabels(List<ContentSafetyLabel> labels);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements TextStage, SentencesIdxStartStage, SentencesIdxEndStage, TimestampStage, _FinalStage {
        private String text;

        private int sentencesIdxStart;

        private int sentencesIdxEnd;

        private Timestamp timestamp;

        private List<ContentSafetyLabel> labels = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(ContentSafetyLabelResult other) {
            text(other.getText());
            labels(other.getLabels());
            sentencesIdxStart(other.getSentencesIdxStart());
            sentencesIdxEnd(other.getSentencesIdxEnd());
            timestamp(other.getTimestamp());
            return this;
        }

        /**
         * <p>The transcript of the section flagged by the Content Moderation model</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("text")
        public SentencesIdxStartStage text(@NotNull String text) {
            this.text = Objects.requireNonNull(text, "text must not be null");
            return this;
        }

        /**
         * <p>The sentence index at which the section begins</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("sentences_idx_start")
        public SentencesIdxEndStage sentencesIdxStart(int sentencesIdxStart) {
            this.sentencesIdxStart = sentencesIdxStart;
            return this;
        }

        /**
         * <p>The sentence index at which the section ends</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("sentences_idx_end")
        public TimestampStage sentencesIdxEnd(int sentencesIdxEnd) {
            this.sentencesIdxEnd = sentencesIdxEnd;
            return this;
        }

        /**
         * <p>Timestamp information for the section</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("timestamp")
        public _FinalStage timestamp(@NotNull Timestamp timestamp) {
            this.timestamp = Objects.requireNonNull(timestamp, "timestamp must not be null");
            return this;
        }

        /**
         * <p>An array of safety labels, one per sensitive topic that was detected in the section</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addAllLabels(List<ContentSafetyLabel> labels) {
            this.labels.addAll(labels);
            return this;
        }

        /**
         * <p>An array of safety labels, one per sensitive topic that was detected in the section</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addLabels(ContentSafetyLabel labels) {
            this.labels.add(labels);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "labels", nulls = Nulls.SKIP)
        public _FinalStage labels(List<ContentSafetyLabel> labels) {
            this.labels.clear();
            this.labels.addAll(labels);
            return this;
        }

        @java.lang.Override
        public ContentSafetyLabelResult build() {
            return new ContentSafetyLabelResult(
                    text, labels, sentencesIdxStart, sentencesIdxEnd, timestamp, additionalProperties);
        }
    }
}
