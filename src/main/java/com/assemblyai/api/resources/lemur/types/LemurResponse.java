/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.resources.lemur.types;

import com.assemblyai.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.util.Objects;

@JsonDeserialize(using = LemurResponse.Deserializer.class)
public final class LemurResponse {
    private final Object value;

    private final int type;

    private LemurResponse(Object value, int type) {
        this.value = value;
        this.type = type;
    }

    @JsonValue
    public Object get() {
        return this.value;
    }

    public <T> T visit(Visitor<T> visitor) {
        if (this.type == 0) {
            return visitor.visit((LemurTaskResponse) this.value);
        } else if (this.type == 1) {
            return visitor.visit((LemurSummaryResponse) this.value);
        } else if (this.type == 2) {
            return visitor.visit((LemurQuestionAnswerResponse) this.value);
        } else if (this.type == 3) {
            return visitor.visit((LemurActionItemsResponse) this.value);
        }
        throw new IllegalStateException("Failed to visit value. This should never happen.");
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LemurResponse && equalTo((LemurResponse) other);
    }

    private boolean equalTo(LemurResponse other) {
        return value.equals(other.value);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @java.lang.Override
    public String toString() {
        return this.value.toString();
    }

    public static LemurResponse of(LemurTaskResponse value) {
        return new LemurResponse(value, 0);
    }

    public static LemurResponse of(LemurSummaryResponse value) {
        return new LemurResponse(value, 1);
    }

    public static LemurResponse of(LemurQuestionAnswerResponse value) {
        return new LemurResponse(value, 2);
    }

    public static LemurResponse of(LemurActionItemsResponse value) {
        return new LemurResponse(value, 3);
    }

    public interface Visitor<T> {
        T visit(LemurTaskResponse value);

        T visit(LemurSummaryResponse value);

        T visit(LemurQuestionAnswerResponse value);

        T visit(LemurActionItemsResponse value);
    }

    static final class Deserializer extends StdDeserializer<LemurResponse> {
        Deserializer() {
            super(LemurResponse.class);
        }

        @java.lang.Override
        public LemurResponse deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            Object value = p.readValueAs(Object.class);
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, LemurTaskResponse.class));
            } catch (IllegalArgumentException e) {
            }
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, LemurSummaryResponse.class));
            } catch (IllegalArgumentException e) {
            }
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, LemurQuestionAnswerResponse.class));
            } catch (IllegalArgumentException e) {
            }
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, LemurActionItemsResponse.class));
            } catch (IllegalArgumentException e) {
            }
            throw new JsonParseException(p, "Failed to deserialize");
        }
    }
}
