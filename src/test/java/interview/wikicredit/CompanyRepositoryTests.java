package interview.wikicredit;

import interview.wikicredit.dto.CompanyDto;
import interview.wikicredit.exception.BusinessException;
import interview.wikicredit.model.Company;
import interview.wikicredit.repository.CompanyRepository;
import interview.wikicredit.service.CompanyServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CompanyRepositoryTests {

    @InjectMocks
    private CompanyServiceImpl companyService;

    @Mock
    private CompanyRepository companyRepository;

    @Test
    public void testCompanySave_returnsCompany() throws BusinessException {
        CompanyDto sampleCompany = new CompanyDto().withTitle("Swedbank");
        when(companyRepository.save(any(Company.class))).thenReturn(new Company().withTitle("Swedbank"));
        CompanyDto created = companyService.save(sampleCompany);
        assertThat(created.getTitle()).isEqualTo(sampleCompany.getTitle());
    }

    @Test
    public void testCompanyFindById_returnsCompany() {
        CompanyDto sampleCompany = new CompanyDto().withTitle("Swedbank").withId(1L);
        when(companyRepository.findById(1L)).thenReturn(Optional.of(new Company().withId(1L).withTitle("Swedbank")));
        CompanyDto found = companyService.findCompanyById(1L);
        assertThat(found.getTitle()).isEqualTo(sampleCompany.getTitle());
    }
}
