package com.assemblyai.api.types;

import com.assemblyai.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TranscriptSearchResults.Builder.class)
public final class TranscriptSearchResults {
    private final Optional<String> id;

    private final Optional<Integer> totalCount;

    private final Optional<List<TranscriptSearchMatch>> matches;

    private TranscriptSearchResults(
            Optional<String> id, Optional<Integer> totalCount, Optional<List<TranscriptSearchMatch>> matches) {
        this.id = id;
        this.totalCount = totalCount;
        this.matches = matches;
    }

    /**
     * @return The ID of the transcript
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The total count of all matched instances. For e.g., word 1 matched 2 times, and word 2 matched 3 times, <code>total_count</code> will equal 5.
     */
    @JsonProperty("total_count")
    public Optional<Integer> getTotalCount() {
        return totalCount;
    }

    /**
     * @return The matches of the search
     */
    @JsonProperty("matches")
    public Optional<List<TranscriptSearchMatch>> getMatches() {
        return matches;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranscriptSearchResults && equalTo((TranscriptSearchResults) other);
    }

    private boolean equalTo(TranscriptSearchResults other) {
        return id.equals(other.id) && totalCount.equals(other.totalCount) && matches.equals(other.matches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.totalCount, this.matches);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<Integer> totalCount = Optional.empty();

        private Optional<List<TranscriptSearchMatch>> matches = Optional.empty();

        private Builder() {}

        public Builder from(TranscriptSearchResults other) {
            id(other.getId());
            totalCount(other.getTotalCount());
            matches(other.getMatches());
            return this;
        }

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.of(id);
            return this;
        }

        @JsonSetter(value = "total_count", nulls = Nulls.SKIP)
        public Builder totalCount(Optional<Integer> totalCount) {
            this.totalCount = totalCount;
            return this;
        }

        public Builder totalCount(Integer totalCount) {
            this.totalCount = Optional.of(totalCount);
            return this;
        }

        @JsonSetter(value = "matches", nulls = Nulls.SKIP)
        public Builder matches(Optional<List<TranscriptSearchMatch>> matches) {
            this.matches = matches;
            return this;
        }

        public Builder matches(List<TranscriptSearchMatch> matches) {
            this.matches = Optional.of(matches);
            return this;
        }

        public TranscriptSearchResults build() {
            return new TranscriptSearchResults(id, totalCount, matches);
        }
    }
}
