
package com.rs.fer.eis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.fer.eis.entity.Skills;

public interface SkillsRepository extends JpaRepository<Skills, Integer> {

	List<Skills> findByName(String name);

}
