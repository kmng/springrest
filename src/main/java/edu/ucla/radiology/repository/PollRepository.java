package edu.ucla.radiology.repository;

import edu.ucla.radiology.domain.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll, Long> {
    
}
