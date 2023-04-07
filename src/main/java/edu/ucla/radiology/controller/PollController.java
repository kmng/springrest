package edu.ucla.radiology.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import edu.ucla.radiology.domain.Poll;
import edu.ucla.radiology.repository.PollRepository;

@RestController
public class PollController {
    @Autowired
    private PollRepository pollRepository;

    @GetMapping("/polls")
    public ResponseEntity<List<Poll>> getAllPolls() {
        List<Poll> polls = pollRepository.findAll();
        return new ResponseEntity<>(polls, HttpStatus.OK);
    }
    
}
