package com.hk.oa.filter;

import java.net.URI;
import java.util.LinkedHashSet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.headers.HttpHeadersFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import static org.springframework.cloud.gateway.filter.headers.XForwardedHeadersFilter.X_FORWARDED_PREFIX_HEADER;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;


/**
* @Description:
 * 缺少了admin这个路由节点。断点源码时发现在Swagger中会根据X-Forwarded-Prefix这个Header来获取BasePath，
 * 将它添加至接口路径与host中间，这样才能正常做接口测试，而Gateway在做转发的时候并没有这个Header添加进Request，
 * 所以发生接口调试的404错误。解决思路是在Gateway里加一个过滤器来添加这个header。
 *  ————————————————
 *
* @Param:
* @return:
* @Author: 陈家乐
* @Date: 2019/8/26
*/
@Component
public class SwaggerXForwardedHeadersFilter implements HttpHeadersFilter, Ordered {

    @Value("${server.servlet.context-path:/api}")
    private String contextPath;

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public boolean supports(Type type) {
        return true;
    }

    @Override
    public HttpHeaders filter(HttpHeaders input, ServerWebExchange exchange) {
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders original = input;
        HttpHeaders updated = new HttpHeaders();

        LinkedHashSet<URI> originalUris = exchange.getAttribute(GATEWAY_ORIGINAL_REQUEST_URL_ATTR);
        URI requestUri = exchange.getAttribute(GATEWAY_REQUEST_URL_ATTR);

        if (originalUris != null && requestUri != null) {

            originalUris.stream().forEach(originalUri -> {

                if (originalUri != null && originalUri.getPath() != null) {
                    String prefix = originalUri.getPath();

                    String originalUriPath = stripTrailingSlash(originalUri);
                    String requestUriPath = stripTrailingSlash(requestUri);

                    if (requestUriPath != null && (originalUriPath.endsWith(requestUriPath))) {
                        prefix = originalUriPath.replace(requestUriPath, "");
                        if (prefix != null && prefix.length() > 0 &&
                                prefix.length() <= originalUri.getPath().length()) {
                            input.add(X_FORWARDED_PREFIX_HEADER ,prefix);

                        }
                    }

                }
            });
        }

        return input;
    }
    private String stripTrailingSlash(URI uri) {
        if (uri.getPath().endsWith("/")) {
            return uri.getPath().substring(0, uri.getPath().length() - 1);
        } else {
            return uri.getPath();
        }
    }
}