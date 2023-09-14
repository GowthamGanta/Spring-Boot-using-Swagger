
package com.rs.fer.eis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.fer.eis.entity.Skills;

public interface SkillsRepository extends JpaRepository<Skills, Integer> {

	List<Skills> findByName(String name);

	Optional<Skills> findById(int id);

}
