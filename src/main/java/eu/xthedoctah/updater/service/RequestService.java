package eu.xthedoctah.updater.service;

import com.google.gson.Gson;
import eu.xthedoctah.updater.model.Version;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class RequestService {

    public Object doRequest(String url, Object parameters, Class classe) {
        Object object = null;
        HttpPost request = new HttpPost(url);
        request.addHeader("Content-Type", "application/json");
        try {
            request.setEntity(new StringEntity(new Gson().toJson(parameters)));
            HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
            object = new Gson().fromJson(EntityUtils.toString(httpResponse.getEntity()), classe);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }

    public Version doRequest(String url, Version version) {
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Content-Type", "application/json");
            httpPost.setEntity(new StringEntity(version.toString()));
            HttpResponse httpResponse = HttpClientBuilder.create().build().execute(httpPost);
            return new Gson().fromJson(EntityUtils.toString(httpResponse.getEntity()), Version.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Version.getInstance();
    }
}
