package edu.ucla.radiology.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.HttpHeaders;
import java.util.List;
import java.util.Optional;

import edu.ucla.radiology.domain.Poll;
import edu.ucla.radiology.domain.Option;
import edu.ucla.radiology.repository.OptionRepository;
import edu.ucla.radiology.repository.PollRepository;

@RestController
public class PollController {
    @Autowired
    private PollRepository pollRepository;
    @Autowired
    private OptionRepository optionRepository;

    @GetMapping("/polls")
    public ResponseEntity<List<Poll>> getAllPolls() {
        List<Poll> polls = pollRepository.findAll();
        return new ResponseEntity<>(polls, HttpStatus.OK);
    }

    @PostMapping("/polls")
    public ResponseEntity<Poll> createPoll(@RequestBody Poll poll) {
        Poll savedPoll = pollRepository.save(poll);
        List<Option> options = poll.getOptions();
        if (options != null) {
            for (Option option : options) {
                option.setPoll(savedPoll);
                option = optionRepository.save(option);
            }
        }

        HttpHeaders headers = new HttpHeaders();

        headers.setLocation(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPoll.getId())
                .toUri());

        return new ResponseEntity<>(savedPoll, headers, HttpStatus.CREATED);
    }

    @GetMapping("/polls/{pollId}")
    public ResponseEntity<?> getPoll(@PathVariable Long pollId) throws Exception {
        Optional<Poll> poll = pollRepository.findById(pollId);
        if (!poll.isPresent()){
           throw new Exception("poll not found"); 
        }
        return new ResponseEntity<>(poll.get(), HttpStatus.OK);
    }

    @DeleteMapping("/polls/{pollId}")
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
        pollRepository.deleteById(pollId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
