/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.resources.files;

import com.assemblyai.api.core.AssemblyAIApiException;
import com.assemblyai.api.core.AssemblyAIException;
import com.assemblyai.api.core.ClientOptions;
import com.assemblyai.api.core.InputStreamRequestBody;
import com.assemblyai.api.core.ObjectMappers;
import com.assemblyai.api.core.RequestOptions;
import com.assemblyai.api.errors.BadRequestError;
import com.assemblyai.api.errors.GatewayTimeoutError;
import com.assemblyai.api.errors.InternalServerError;
import com.assemblyai.api.errors.NotFoundError;
import com.assemblyai.api.errors.ServiceUnavailableError;
import com.assemblyai.api.errors.TooManyRequestsError;
import com.assemblyai.api.errors.UnauthorizedError;
import com.assemblyai.api.resources.files.types.UploadedFile;
import com.assemblyai.api.types.Error;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class FilesClient {
    protected final ClientOptions clientOptions;

    public FilesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Upload a media file to AssemblyAI's servers.
     */
    public UploadedFile upload(InputStream request) {
        return upload(request, null);
    }

    /**
     * Upload a media file to AssemblyAI's servers.
     */
    public UploadedFile upload(InputStream request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/upload")
                .build();
        RequestBody body = new InputStreamRequestBody(MediaType.parse("application/octet-stream"), request);
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), UploadedFile.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                switch (response.code()) {
                    case 400:
                        throw new BadRequestError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 401:
                        throw new UnauthorizedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 404:
                        throw new NotFoundError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 429:
                        throw new TooManyRequestsError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 500:
                        throw new InternalServerError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 503:
                        throw new ServiceUnavailableError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 504:
                        throw new GatewayTimeoutError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                }
            } catch (JsonProcessingException ignored) {
                // unable to map error response, throwing generic error
            }
            throw new AssemblyAIApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new AssemblyAIException("Network error executing HTTP request", e);
        }
    }

    /**
     * Upload a media file to AssemblyAI's servers.
     */
    public UploadedFile upload(byte[] request) {
        return upload(new ByteArrayInputStream(request));
    }

    /**
     * Upload a media file to AssemblyAI's servers.
     */
    public UploadedFile upload(byte[] request, RequestOptions requestOptions) {
        return upload(new ByteArrayInputStream(request), requestOptions);
    }
}
