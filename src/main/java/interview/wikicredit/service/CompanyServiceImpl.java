package interview.wikicredit.service;

import interview.wikicredit.dto.CompanyDto;
import interview.wikicredit.exception.BusinessException;
import interview.wikicredit.domain.EErrorCode;
import interview.wikicredit.model.Company;
import interview.wikicredit.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public CompanyDto save(CompanyDto companyDto) throws BusinessException {
        if (!ifSuchCompanyExists(companyDto.getTitle())) {
            return toCompanyDto(companyRepository.save(toCompany(companyDto)));
        }
        throw new BusinessException().withCode(EErrorCode.COMPANY_ALREADY_EXISTS);
    }

    @Override
    public CompanyDto findCompanyById(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        return company.map(this::toCompanyDto).orElse(null);
    }

    private boolean ifSuchCompanyExists(String title) {
        Optional<Company> company = companyRepository.findByTitle(title);
        return company.isPresent();
    }

    private Company toCompany(CompanyDto dto) {
        return new Company()
                .withId(dto.getId())
                .withTitle(dto.getTitle());
    }

    private CompanyDto toCompanyDto(Company data) {
        return new CompanyDto()
                .withId(data.getId())
                .withTitle(data.getTitle());
    }
}
