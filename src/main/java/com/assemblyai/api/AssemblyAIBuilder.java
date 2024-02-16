/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api;

import com.assemblyai.api.core.ClientOptions;
import com.assemblyai.api.core.Environment;

public final class AssemblyAIBuilder {
    private final ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();
    private final ClientOptions.Builder lemurClientOptionsBuilder = ClientOptions.builder();

    private Environment environment = Environment.DEFAULT;

    public AssemblyAIBuilder apiKey(String apiKey) {
        this.clientOptionsBuilder.addHeader("Authorization", apiKey);
        this.lemurClientOptionsBuilder.addHeader("Authorization", apiKey);
        return this;
    }

    public AssemblyAIBuilder environment(Environment environment) {
        this.environment = environment;
        return this;
    }

    public AssemblyAIBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    public AssemblyAI build() {
        clientOptionsBuilder.environment(this.environment);
        lemurClientOptionsBuilder
                .environment(this.environment)
                .disableTimeouts();
        return new AssemblyAI(clientOptionsBuilder.build(), lemurClientOptionsBuilder.build());
    }
}
