package com.hk.oa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;


import java.util.List;

@Component
@RefreshScope
public class IgnoreTokenConfig {

    @Value("#{'${gate.ignore.url}'.split(',')}")
    private  List<String> LIST;

    private  final AntPathMatcher ANT_PATH_MATCHER = new AntPathMatcher();

    public  boolean isIgnoreToken(String currentUri) {
        return isIgnore(LIST, currentUri);
    }

    public  boolean isIgnore(List<String> list, String currentUri) {
        if (list.isEmpty()) {
            return false;
        }
        return list.stream().anyMatch((url) ->
                currentUri.startsWith(url) || ANT_PATH_MATCHER.match(url, currentUri)
        );
    }
}
