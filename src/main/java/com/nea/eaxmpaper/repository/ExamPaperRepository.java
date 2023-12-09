// Project : eaxmpaperapi -> com.nea.eaxmpaper.repository -> ExamPaperRepository.java
// Author  : krushnakant
// Created : 9 Dec 2023 16:15:14
package com.nea.eaxmpaper.repository;

import com.nea.eaxmpaper.model.ExamPaper;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author krushnakant
 */
public interface ExamPaperRepository extends JpaRepository<ExamPaper, Integer> {

}
