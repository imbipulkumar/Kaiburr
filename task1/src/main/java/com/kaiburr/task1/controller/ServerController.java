package com.kaiburr.task1.controller;

import java.util.List;
import java.util.Optional;

import com.kaiburr.task1.model.Server;
import com.kaiburr.task1.service.ServerServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/servers")
public class ServerController {

    @Autowired
    private ServerServiceImpl serverServiceImpl;

    @GetMapping(value = "/getServer")
    public List<Server> getAllServers() {
        return serverServiceImpl.findAll();
    }

    @GetMapping(value = "/getServer", params = "id")
    public ResponseEntity<?> getServerById(@RequestParam String id) {
        Optional<Server> server = serverServiceImpl.findById(id);
        if (server.isPresent()) {
            return new ResponseEntity<Server>(server.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Server not found!", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getServer", params = "name")
    public ResponseEntity<?> getServerByName(@RequestParam String name) {
        List<Server> servers = serverServiceImpl.findByName(name);
        if (servers.isEmpty()) {
            return new ResponseEntity<String>("Server not found!", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Server>>(servers, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/createServer")
    public ResponseEntity<?> createOrUpdateServer(@RequestBody Server server) {
        serverServiceImpl.createOrUpdateServer(server);
        return new ResponseEntity<String>("Server added successfully!", HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteServer")
    public ResponseEntity<?> deleteServer(@RequestParam String id) {
        if (serverServiceImpl.existsServerById(id)) {
            serverServiceImpl.deleteServerById(id);
            return new ResponseEntity<String>("Server deleted successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Server not exists!", HttpStatus.OK);
    }

}