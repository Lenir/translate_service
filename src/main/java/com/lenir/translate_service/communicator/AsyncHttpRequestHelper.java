package com.lenir.translate_service.communicator;

import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;
import org.apache.hc.client5.http.async.methods.SimpleHttpResponse;
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.async.HttpAsyncClients;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManager;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManagerBuilder;
import org.apache.hc.client5.http.ssl.ClientTlsStrategyBuilder;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.http.nio.ssl.TlsStrategy;
import org.apache.hc.core5.ssl.SSLContexts;
import org.apache.hc.core5.ssl.TrustStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.Future;

@Component
public class AsyncHttpRequestHelper {
    private static final Logger logger = LogManager.getLogger(AsyncHttpRequestHelper.class);

    @Value("${ssl.ignore-ssl}")
    boolean ignoreSSL;

    public Future<SimpleHttpResponse> requestAsyncHttpGet(SimpleHttpRequest simpleHttpRequest){
//        CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
        CloseableHttpAsyncClient client = null;
        try {
            client = getCloseableHttpAsyncClient();
        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            logger.error("get http client failed.", e);
        }
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
        logger.info("HTTP async call sent: {}", simpleHttpRequest);
        return futureResponse;
    }

    private CloseableHttpAsyncClient getCloseableHttpAsyncClient() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        if(ignoreSSL){
            // ##TEST## For bypass SSL certification. (like proxy environment)
            final SSLContext sslcontext = SSLContexts.custom()
                    .loadTrustMaterial(new TrustStrategy() {
                        @Override
                        public boolean isTrusted(
                                final X509Certificate[] chain,
                                final String authType) throws CertificateException {
                            final X509Certificate cert = chain[0];
                            return true;
                        }
                    })
                    .build();
            final TlsStrategy tlsStrategy = ClientTlsStrategyBuilder.create()
                    .setSslContext(sslcontext)
                    .build();
            final PoolingAsyncClientConnectionManager cm = PoolingAsyncClientConnectionManagerBuilder.create()
                    .setTlsStrategy(tlsStrategy)
                    .build();
            return HttpAsyncClients.custom()
                    .setConnectionManager(cm)
                    .build();
        }else{
            return HttpAsyncClients.createDefault();
        }
    }
}
