package com.lenir.translate_service.communicator;

import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;
import org.apache.hc.client5.http.async.methods.SimpleHttpResponse;
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.async.HttpAsyncClients;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Future;

public class AsyncHttpRequestHelper {
    private static final Logger logger = LogManager.getLogger(AsyncHttpRequestHelper.class);

    public static Future<SimpleHttpResponse> requestAsyncHttpGet(SimpleHttpRequest simpleHttpRequest){
        CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
        client.start();

        Future<SimpleHttpResponse> futureResponse = client.execute(simpleHttpRequest, new FutureCallback<SimpleHttpResponse>() {
            @Override
            public void completed(SimpleHttpResponse result) {
                logger.info("HTTP async call completed. Status code: '{}', Body: '{}'", result.getCode(), result.getBodyText());
            }

            @Override
            public void failed(Exception e) {
                logger.error("HTTP async call failed!", e);
            }

            @Override
            public void cancelled() {
                logger.error("HTTP async call cancelled!");
            }
        });
        logger.info("HTTP async call sent.");
        return futureResponse;
    }
}
