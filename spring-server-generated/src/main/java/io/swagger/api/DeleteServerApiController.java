package io.swagger.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiParam;
import io.swagger.repository.ServerRepository;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-27T20:38:22.907Z[GMT]")
@Controller
public class DeleteServerApiController implements DeleteServerApi {

    private static final Logger log = LoggerFactory.getLogger(DeleteServerApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public DeleteServerApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Autowired
    private ServerRepository serverRepository;

    @ResponseBody
    public ResponseEntity<?> deleteServer(
            @NotNull @ApiParam(value = "Server object that needs to be deleted", required = true) @Valid @RequestParam(value = "id", required = true) String id) {
        // String accept = request.getHeader("Accept");
        if (serverRepository.existsById(id)) {
            serverRepository.deleteById(id);
            return new ResponseEntity<String>("Server deleted successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Server not exists!", HttpStatus.NOT_FOUND);
    }

}
