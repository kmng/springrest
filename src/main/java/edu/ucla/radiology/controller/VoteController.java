package edu.ucla.radiology.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import edu.ucla.radiology.domain.Option;
import edu.ucla.radiology.domain.Vote;
import edu.ucla.radiology.repository.VoteRepository;

@RestController
public class VoteController {
    @Autowired
    private VoteRepository voteRepository;

    @PostMapping("/polls/{pollId}/votes")
    public ResponseEntity<?> createVote(@PathVariable Long pollId, @RequestBody Vote vote) {

        voteRepository.save(vote);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/polls/{pollId}/votes")
	public Iterable<Vote> getAllVotes(@PathVariable Long pollId) {
		return voteRepository.findByPoll(pollId);
	}	
}
