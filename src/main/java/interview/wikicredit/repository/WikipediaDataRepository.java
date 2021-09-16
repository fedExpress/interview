package interview.wikicredit.repository;

import interview.wikicredit.model.WikipediaData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WikipediaDataRepository extends JpaRepository<WikipediaData, Long> {
    Optional<WikipediaData> findById(Long id);

    Optional<WikipediaData> findByTitle(String title);

    Optional<WikipediaData> findByCompanyId(Long id);
}
