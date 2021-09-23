package com.qrs.admin.utils;

import lombok.extern.slf4j.Slf4j;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author yuanweimin
 * @date 19/06/24 09:29
 * @description okHttp 工具类
 */
@Slf4j
@Component
@PropertySource("classpath:config/mqClient-config.properties")
public class OkHttpUtil {

    private final Environment env;
    private final OkHttpClient client=new OkHttpClient();

    @Autowired
    public OkHttpUtil( Environment env) {
        this.env = env;
    }


    public String postJson(String url, String jsonParams) {
        String responseBody = "";

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonParams);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .addHeader("Content-Type", "application/json")
                .addHeader("Host", "api.heclouds.com")
                .addHeader("api-key", "FWq3M4WX=1HthWq7oxFLikqR6W0=")
                .build();

        System.out.println(new String(responseBody.getBytes()));

        try (Response response = this.client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return Objects.requireNonNull(response.body()).string();
            }
        } catch (Exception e) {
            log.error("{}", e);
        }
        return responseBody;
    }
}
