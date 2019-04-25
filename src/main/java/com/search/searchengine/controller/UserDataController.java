package com.search.searchengine.controller;

import com.search.searchengine.exception.ResourceNotFoundException;
import com.search.searchengine.model.UserData;
import com.search.searchengine.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserDataController {

    @Autowired
    UserDataRepository userDataRepository;

    // get all userdata
    @GetMapping("/userData")
    public List<UserData> getAllUserData(){
        return userDataRepository.findAll();
    }

    // create new userData
   @PostMapping("/userData")
   public UserData createUserData(@Valid @RequestBody UserData userData){
        return userDataRepository.save(userData);
   }

   // get 1 row of userData based on sessionID
    @GetMapping("/userData/{sessionID}")
    public UserData getUserDataById(@PathVariable(value ="sessionID") Long userDataId){
        return userDataRepository.findById(userDataId)
                .orElseThrow(() -> new ResourceNotFoundException("userData","sessionID", userDataId));
    }

    // update some userdata
    @PutMapping("/userData/{sessionID}")
    public UserData updateUserData(@PathVariable(value = "sessionID") Long userDataId, @Valid @RequestBody UserData
                                   userDataDetails){
        UserData userdata = userDataRepository.findById(userDataId)
                .orElseThrow(() -> new ResourceNotFoundException("userData", "sessionID", userDataId));

        userdata.setQuery(userDataDetails.getQuery());
        userdata.setContent(userDataDetails.getContent());

        UserData updatedUserData = userDataRepository.save(userdata);
        return updatedUserData;
    }

    // delate some userdata
    @DeleteMapping("/notes/{sessionID}")
    public ResponseEntity<?> deleteUserData(@PathVariable(value = "sessionID") Long userDataId){
        UserData userData = userDataRepository.findById(userDataId)
                .orElseThrow(() -> new ResourceNotFoundException("UserData", "sessionID", userDataId));

        userDataRepository.delete(userData);
        return ResponseEntity.ok().build();
    }

}
