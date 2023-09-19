/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Locale;

public final class TranscriptLanguageCode {
    public static final TranscriptLanguageCode ES = new TranscriptLanguageCode(Value.ES, "es");

    public static final TranscriptLanguageCode EN_AU = new TranscriptLanguageCode(Value.EN_AU, "en_au");

    public static final TranscriptLanguageCode DE = new TranscriptLanguageCode(Value.DE, "de");

    public static final TranscriptLanguageCode PL = new TranscriptLanguageCode(Value.PL, "pl");

    public static final TranscriptLanguageCode IT = new TranscriptLanguageCode(Value.IT, "it");

    public static final TranscriptLanguageCode JA = new TranscriptLanguageCode(Value.JA, "ja");

    public static final TranscriptLanguageCode KO = new TranscriptLanguageCode(Value.KO, "ko");

    public static final TranscriptLanguageCode NL = new TranscriptLanguageCode(Value.NL, "nl");

    public static final TranscriptLanguageCode RU = new TranscriptLanguageCode(Value.RU, "ru");

    public static final TranscriptLanguageCode HI = new TranscriptLanguageCode(Value.HI, "hi");

    public static final TranscriptLanguageCode VI = new TranscriptLanguageCode(Value.VI, "vi");

    public static final TranscriptLanguageCode EN = new TranscriptLanguageCode(Value.EN, "en");

    public static final TranscriptLanguageCode EN_US = new TranscriptLanguageCode(Value.EN_US, "en_us");

    public static final TranscriptLanguageCode ZH = new TranscriptLanguageCode(Value.ZH, "zh");

    public static final TranscriptLanguageCode FR = new TranscriptLanguageCode(Value.FR, "fr");

    public static final TranscriptLanguageCode PT = new TranscriptLanguageCode(Value.PT, "pt");

    public static final TranscriptLanguageCode TR = new TranscriptLanguageCode(Value.TR, "tr");

    public static final TranscriptLanguageCode EN_UK = new TranscriptLanguageCode(Value.EN_UK, "en_uk");

    public static final TranscriptLanguageCode FI = new TranscriptLanguageCode(Value.FI, "fi");

    public static final TranscriptLanguageCode UK = new TranscriptLanguageCode(Value.UK, "uk");

    private final Value value;

    private final String string;

    TranscriptLanguageCode(Value value, String string) {
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
                || (other instanceof TranscriptLanguageCode
                        && this.string.equals(((TranscriptLanguageCode) other).string));
    }

    @Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case ES:
                return visitor.visitEs();
            case EN_AU:
                return visitor.visitEnAu();
            case DE:
                return visitor.visitDe();
            case PL:
                return visitor.visitPl();
            case IT:
                return visitor.visitIt();
            case JA:
                return visitor.visitJa();
            case KO:
                return visitor.visitKo();
            case NL:
                return visitor.visitNl();
            case RU:
                return visitor.visitRu();
            case HI:
                return visitor.visitHi();
            case VI:
                return visitor.visitVi();
            case EN:
                return visitor.visitEn();
            case EN_US:
                return visitor.visitEnUs();
            case ZH:
                return visitor.visitZh();
            case FR:
                return visitor.visitFr();
            case PT:
                return visitor.visitPt();
            case TR:
                return visitor.visitTr();
            case EN_UK:
                return visitor.visitEnUk();
            case FI:
                return visitor.visitFi();
            case UK:
                return visitor.visitUk();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static TranscriptLanguageCode valueOf(String value) {
        String upperCasedValue = value.toUpperCase(Locale.ROOT);
        switch (upperCasedValue) {
            case "es":
                return ES;
            case "en_au":
                return EN_AU;
            case "de":
                return DE;
            case "pl":
                return PL;
            case "it":
                return IT;
            case "ja":
                return JA;
            case "ko":
                return KO;
            case "nl":
                return NL;
            case "ru":
                return RU;
            case "hi":
                return HI;
            case "vi":
                return VI;
            case "en":
                return EN;
            case "en_us":
                return EN_US;
            case "zh":
                return ZH;
            case "fr":
                return FR;
            case "pt":
                return PT;
            case "tr":
                return TR;
            case "en_uk":
                return EN_UK;
            case "fi":
                return FI;
            case "uk":
                return UK;
            default:
                return new TranscriptLanguageCode(Value.UNKNOWN, upperCasedValue);
        }
    }

    public enum Value {
        EN,

        EN_AU,

        EN_UK,

        EN_US,

        ES,

        FR,

        DE,

        IT,

        PT,

        NL,

        HI,

        JA,

        ZH,

        FI,

        KO,

        PL,

        RU,

        TR,

        UK,

        VI,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitEn();

        T visitEnAu();

        T visitEnUk();

        T visitEnUs();

        T visitEs();

        T visitFr();

        T visitDe();

        T visitIt();

        T visitPt();

        T visitNl();

        T visitHi();

        T visitJa();

        T visitZh();

        T visitFi();

        T visitKo();

        T visitPl();

        T visitRu();

        T visitTr();

        T visitUk();

        T visitVi();

        T visitUnknown(String unknownType);
    }
}
