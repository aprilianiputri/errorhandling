package com.connected.demonewerrorhandling.controller;

import com.connected.demonewerrorhandling.exception.UserNotFoundException;
import com.connected.demonewerrorhandling.modelRequest.UpdateUserDetail;
import com.connected.demonewerrorhandling.modelRequest.UserDetails;
import com.connected.demonewerrorhandling.modelResponse.DeleteResponse;
import com.connected.demonewerrorhandling.modelResponse.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {

    Map<String, UserRest> users;

    @GetMapping(value = "{userId}",
            produces = {MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
        System.out.println("getUser");

        if (users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }
    }

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetails userDetails) {
        System.out.println("postUser");
        UserRest returnValue = new UserRest();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());

        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);

        if (users == null) users = new HashMap<>();
        users.put(userId, returnValue);

        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PutMapping(value = "{userId}",
            consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<UserRest>  updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetail userDetails) {
        System.out.println("updateUser");

        if (users.containsKey(userId)) {
            UserRest storedUserDetails = users.get(userId);
            storedUserDetails.setFirstName(userDetails.getFirstName());
            storedUserDetails.setLastName(userDetails.getLastName());

            users.put(userId, storedUserDetails);
            return new ResponseEntity<>(users.put(userId, storedUserDetails), HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }

    }

    @DeleteMapping(value = "{userId}")
    public ResponseEntity<DeleteResponse> deleteUser(@PathVariable String userId) {
        System.out.println("deleteUser");

        if (users.containsKey(userId)) {
            users.remove(userId);
            return ResponseEntity.ok(new DeleteResponse("User has been deleted"));
        } else {
            throw new UserNotFoundException();
        }
    }
}
