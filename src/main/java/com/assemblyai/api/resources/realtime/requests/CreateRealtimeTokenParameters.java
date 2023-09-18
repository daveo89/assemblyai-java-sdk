package com.assemblyai.api.resources.realtime.requests;

import com.assemblyai.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CreateRealtimeTokenParameters.Builder.class)
public final class CreateRealtimeTokenParameters {
    private final int expiresIn;

    private CreateRealtimeTokenParameters(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    /**
     * @return The amount of time until the token expires in seconds.
     */
    @JsonProperty("expires_in")
    public int getExpiresIn() {
        return expiresIn;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateRealtimeTokenParameters && equalTo((CreateRealtimeTokenParameters) other);
    }

    private boolean equalTo(CreateRealtimeTokenParameters other) {
        return expiresIn == other.expiresIn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.expiresIn);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ExpiresInStage builder() {
        return new Builder();
    }

    public interface ExpiresInStage {
        _FinalStage expiresIn(int expiresIn);

        Builder from(CreateRealtimeTokenParameters other);
    }

    public interface _FinalStage {
        CreateRealtimeTokenParameters build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ExpiresInStage, _FinalStage {
        private int expiresIn;

        private Builder() {}

        @Override
        public Builder from(CreateRealtimeTokenParameters other) {
            expiresIn(other.getExpiresIn());
            return this;
        }

        /**
         * <p>The amount of time until the token expires in seconds.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("expires_in")
        public _FinalStage expiresIn(int expiresIn) {
            this.expiresIn = expiresIn;
            return this;
        }

        @Override
        public CreateRealtimeTokenParameters build() {
            return new CreateRealtimeTokenParameters(expiresIn);
        }
    }
}
