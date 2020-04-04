package io.swagger.api;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Server;
import io.swagger.repository.ServerRepository;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-27T20:38:22.907Z[GMT]")
@Controller
public class GetServerApiController implements GetServerApi {

    private static final Logger log = LoggerFactory.getLogger(GetServerApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public GetServerApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Autowired
    private ServerRepository serverRepository;

    @ResponseBody
    public List<Server> getServer() {
        // String accept = request.getHeader("Accept");

        return serverRepository.findAll();
    }

    @ResponseBody
    public ResponseEntity<?> getServerById(
            @ApiParam(value = "Server id that needs to be found", required = true) @PathVariable("id") String id) {
        // String accept = request.getHeader("Accept");
        Optional<Server> server = serverRepository.findById(id);

        if (server.isPresent()) {
            return new ResponseEntity<Server>(server.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Server not found!", HttpStatus.NOT_FOUND);
        }
    }

    @ResponseBody
    public ResponseEntity<?> getServerByName(
            @ApiParam(value = "Server name that needs to be found", required = true) @PathVariable("name") String name) {
        // String accept = request.getHeader("Accept");
        List<Server> servers = serverRepository.findByName(name);
        if (servers.isEmpty()) {
            return new ResponseEntity<String>("Server not found!", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Server>>(servers, HttpStatus.OK);
        }
    }

}
