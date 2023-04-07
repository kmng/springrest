package edu.ucla.radiology.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ucla.radiology.domain.Vote;

public interface VoteRepository  extends JpaRepository<Vote, Long>  {
    
}
