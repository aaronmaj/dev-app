package com.dev.app.payment.hateoas.listener;

import com.dev.app.payment.hateoas.event.ResourceRetrievedEvent;
import com.dev.app.payment.util.LinkUtil;
import com.google.common.base.Preconditions;
import com.google.common.net.HttpHeaders;
import org.springframework.context.ApplicationListener;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;

public class ResourceRetrievedDiscoverabilityListener implements ApplicationListener<ResourceRetrievedEvent> {

@Override
public void onApplicationEvent(final ResourceRetrievedEvent resourceRetrievedEvent) {
        Preconditions.checkNotNull(resourceRetrievedEvent);

final HttpServletResponse response = resourceRetrievedEvent.getResponse();
        addLinkHeaderOnSingleResourceRetrieval(response);
        }

        void addLinkHeaderOnSingleResourceRetrieval(final HttpServletResponse response) {
final String requestURL = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri().toASCIIString();
final int positionOfLastSlash = requestURL.lastIndexOf("/");
final String uriForResourceCreation = requestURL.substring(0, positionOfLastSlash);

final String linkHeaderValue = LinkUtil.createLinkHeader(uriForResourceCreation, "collection");
        response.addHeader(HttpHeaders.LINK, linkHeaderValue);
        }
}
