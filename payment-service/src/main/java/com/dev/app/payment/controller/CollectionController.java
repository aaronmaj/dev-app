package com.dev.app.payment.controller;

import com.dev.app.common.resources.dto.CollectionDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.dev.app.common.resources.util.Web.API;

@RestController
@RequestMapping(value = API+"/collections")
public class CollectionController {

    @RequestMapping(method = RequestMethod.GET)
    public List<CollectionDto> getAll(){
        return null;
    }
}
