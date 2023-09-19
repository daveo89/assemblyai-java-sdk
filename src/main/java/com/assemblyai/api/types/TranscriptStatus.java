/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Locale;

public final class TranscriptStatus {
    public static final TranscriptStatus ERROR = new TranscriptStatus(Value.ERROR, "error");

    public static final TranscriptStatus QUEUED = new TranscriptStatus(Value.QUEUED, "queued");

    public static final TranscriptStatus PROCESSING = new TranscriptStatus(Value.PROCESSING, "processing");

    public static final TranscriptStatus COMPLETED = new TranscriptStatus(Value.COMPLETED, "completed");

    private final Value value;

    private final String string;

    TranscriptStatus(Value value, String string) {
        this.value = value;
        this.string = string;
    }

    public Value getEnumValue() {
        return value;
    }

    @Override
    @JsonValue
    public String toString() {
        return this.string;
    }

    @Override
    public boolean equals(Object other) {
        return (this == other)
                || (other instanceof TranscriptStatus && this.string.equals(((TranscriptStatus) other).string));
    }

    @Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case ERROR:
                return visitor.visitError();
            case QUEUED:
                return visitor.visitQueued();
            case PROCESSING:
                return visitor.visitProcessing();
            case COMPLETED:
                return visitor.visitCompleted();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static TranscriptStatus valueOf(String value) {
        String upperCasedValue = value.toUpperCase(Locale.ROOT);
        switch (upperCasedValue) {
            case "error":
                return ERROR;
            case "queued":
                return QUEUED;
            case "processing":
                return PROCESSING;
            case "completed":
                return COMPLETED;
            default:
                return new TranscriptStatus(Value.UNKNOWN, upperCasedValue);
        }
    }

    public enum Value {
        QUEUED,

        PROCESSING,

        COMPLETED,

        ERROR,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitQueued();

        T visitProcessing();

        T visitCompleted();

        T visitError();

        T visitUnknown(String unknownType);
    }
}
