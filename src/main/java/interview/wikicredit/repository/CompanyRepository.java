package interview.wikicredit.repository;

import interview.wikicredit.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findById(Long id);

    Optional<Company> findByTitle(String title);
}
