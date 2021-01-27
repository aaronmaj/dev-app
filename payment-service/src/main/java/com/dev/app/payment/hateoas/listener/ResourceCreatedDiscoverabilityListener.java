package com.dev.app.payment.hateoas.listener;

import com.dev.app.payment.hateoas.event.ResourceCreatedEvent;
import com.google.common.base.Preconditions;
import org.apache.http.HttpHeaders;
import org.springframework.context.ApplicationListener;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

public class ResourceCreatedDiscoverabilityListener implements ApplicationListener<ResourceCreatedEvent> {
    @Override
    public void onApplicationEvent(ResourceCreatedEvent resourceCreatedEvent) {
        Preconditions.checkNotNull(resourceCreatedEvent);

        final HttpServletResponse response = resourceCreatedEvent.getResponse();
        final long idOfNewResource = resourceCreatedEvent.getIdOfNewResource();

        addLinkHeaderOnResourceCreation(response, idOfNewResource);
    }

    void addLinkHeaderOnResourceCreation(final HttpServletResponse response, final long idOfNewResource) {
        // final String requestUrl = request.getRequestURL().toString();
        // final URI uri = new UriTemplate("{requestUrl}/{idOfNewResource}").expand(requestUrl, idOfNewResource);

        final URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idOfNewResource}").buildAndExpand(idOfNewResource).toUri();
        response.setHeader(HttpHeaders.LOCATION, uri.toASCIIString());
    }
}
