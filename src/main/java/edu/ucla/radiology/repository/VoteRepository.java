package edu.ucla.radiology.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.ucla.radiology.domain.Vote;

public interface VoteRepository  extends JpaRepository<Vote, Long>  {
    
    @Query(value="select v.* from Option o, Vote v where o.POLL_ID = ?1 and v.OPTION_ID = o.ID", nativeQuery = true)
	public Iterable<Vote> findByPoll(Long pollId);
}
