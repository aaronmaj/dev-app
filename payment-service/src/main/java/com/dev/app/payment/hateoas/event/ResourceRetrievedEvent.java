package com.dev.app.payment.hateoas.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class ResourceRetrievedEvent extends ApplicationEvent {

    private final HttpServletResponse response;

    public ResourceRetrievedEvent(Object source, HttpServletResponse response) {
        super(source);
        this.response = response;
    }

    public HttpServletResponse getResponse() {
        return response;
    }
}
