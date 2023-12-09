// Project : eaxmpaperapi -> com.nea.eaxmpaper.repository -> ExamQuestionRepository.java
// Author  : krushnakant
// Created : 9 Dec 2023 16:16:02
package com.nea.eaxmpaper.repository;

import com.nea.eaxmpaper.model.ExamQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author krushnakant
 */
public interface ExamQuestionRepository extends JpaRepository<ExamQuestion, Integer> {

}
