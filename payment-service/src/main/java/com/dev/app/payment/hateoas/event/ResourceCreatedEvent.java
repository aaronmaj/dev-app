package com.dev.app.payment.hateoas.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class ResourceCreatedEvent extends ApplicationEvent {
    private final HttpServletResponse response;
    private final long idOfNewResource;

    public ResourceCreatedEvent(Object source, HttpServletResponse response, long idOfNewResource) {
        super(source);
        this.response = response;
        this.idOfNewResource = idOfNewResource;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public long getIdOfNewResource() {
        return idOfNewResource;
    }
}
