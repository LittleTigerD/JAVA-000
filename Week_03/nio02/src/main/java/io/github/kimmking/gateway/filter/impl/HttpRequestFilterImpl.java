package io.github.kimmking.gateway.filter.impl;

import io.github.kimmking.gateway.filter.HttpRequestFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequest;

import java.lang.reflect.Method;

/**
 * 功能描述:
 *
 * @Author: 窦虎
 * @Date: 2020/11/2 22:23
 */

public class HttpRequestFilterImpl implements HttpRequestFilter {

    private String name;

    public HttpRequestFilterImpl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void filter(FullHttpRequest request, ChannelHandlerContext ctx) {
//        request = new DefaultFullHttpRequest(request.getProtocolVersion(),
//                request.getMethod(), request.getUri(), request.content(), request.headers(), request.trailingHeaders());
        request.headers().add("nio", name);
    }


}
