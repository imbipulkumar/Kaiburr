package io.swagger.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Server;
import io.swagger.repository.ServerRepository;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-27T20:38:22.907Z[GMT]")
@Controller
public class CreateServerApiController implements CreateServerApi {

    private static final Logger log = LoggerFactory.getLogger(CreateServerApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CreateServerApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Autowired
    private ServerRepository serverRepository;

    public ResponseEntity<?> createServer(
            @ApiParam(value = "Server object", required = true) @Valid @RequestBody Server body) {
        // String accept = request.getHeader("Accept");
        serverRepository.save(body);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

}
