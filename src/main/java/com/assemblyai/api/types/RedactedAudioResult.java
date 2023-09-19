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
@JsonDeserialize(builder = RedactedAudioResult.Builder.class)
public final class RedactedAudioResult {
    private final String status;

    private final String redactedAudioUrl;

    private RedactedAudioResult(String status, String redactedAudioUrl) {
        this.status = status;
        this.redactedAudioUrl = redactedAudioUrl;
    }

    /**
     * @return The status of the redacted audio
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * @return The URL of the redacted audio file
     */
    @JsonProperty("redacted_audio_url")
    public String getRedactedAudioUrl() {
        return redactedAudioUrl;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RedactedAudioResult && equalTo((RedactedAudioResult) other);
    }

    private boolean equalTo(RedactedAudioResult other) {
        return status.equals(other.status) && redactedAudioUrl.equals(other.redactedAudioUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.status, this.redactedAudioUrl);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static StatusStage builder() {
        return new Builder();
    }

    public interface StatusStage {
        RedactedAudioUrlStage status(String status);

        Builder from(RedactedAudioResult other);
    }

    public interface RedactedAudioUrlStage {
        _FinalStage redactedAudioUrl(String redactedAudioUrl);
    }

    public interface _FinalStage {
        RedactedAudioResult build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements StatusStage, RedactedAudioUrlStage, _FinalStage {
        private String status;

        private String redactedAudioUrl;

        private Builder() {}

        @Override
        public Builder from(RedactedAudioResult other) {
            status(other.getStatus());
            redactedAudioUrl(other.getRedactedAudioUrl());
            return this;
        }

        /**
         * <p>The status of the redacted audio</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("status")
        public RedactedAudioUrlStage status(String status) {
            this.status = status;
            return this;
        }

        /**
         * <p>The URL of the redacted audio file</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("redacted_audio_url")
        public _FinalStage redactedAudioUrl(String redactedAudioUrl) {
            this.redactedAudioUrl = redactedAudioUrl;
            return this;
        }

        @Override
        public RedactedAudioResult build() {
            return new RedactedAudioResult(status, redactedAudioUrl);
        }
    }
}
