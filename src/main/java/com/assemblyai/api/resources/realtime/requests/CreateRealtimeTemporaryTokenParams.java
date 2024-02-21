/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.resources.realtime.requests;

import com.assemblyai.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CreateRealtimeTemporaryTokenParams.Builder.class)
public final class CreateRealtimeTemporaryTokenParams {
    private final int expiresIn;

    private final Map<String, Object> additionalProperties;

    private CreateRealtimeTemporaryTokenParams(int expiresIn, Map<String, Object> additionalProperties) {
        this.expiresIn = expiresIn;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The amount of time until the token expires in seconds
     */
    @JsonProperty("expires_in")
    public int getExpiresIn() {
        return expiresIn;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateRealtimeTemporaryTokenParams
                && equalTo((CreateRealtimeTemporaryTokenParams) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreateRealtimeTemporaryTokenParams other) {
        return expiresIn == other.expiresIn;
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.expiresIn);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ExpiresInStage builder() {
        return new Builder();
    }

    public interface ExpiresInStage {
        _FinalStage expiresIn(int expiresIn);

        Builder from(CreateRealtimeTemporaryTokenParams other);
    }

    public interface _FinalStage {
        CreateRealtimeTemporaryTokenParams build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ExpiresInStage, _FinalStage {
        private int expiresIn;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CreateRealtimeTemporaryTokenParams other) {
            expiresIn(other.getExpiresIn());
            return this;
        }

        /**
         * <p>The amount of time until the token expires in seconds</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("expires_in")
        public _FinalStage expiresIn(int expiresIn) {
            this.expiresIn = expiresIn;
            return this;
        }

        @java.lang.Override
        public CreateRealtimeTemporaryTokenParams build() {
            return new CreateRealtimeTemporaryTokenParams(expiresIn, additionalProperties);
        }
    }
}
