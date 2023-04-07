package edu.ucla.radiology.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ucla.radiology.domain.Option;

public interface OptionRepository  extends JpaRepository<Option, Long> {
    
}
