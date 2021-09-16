package interview.wikicredit.service;

import interview.wikicredit.dto.CompanyDto;
import interview.wikicredit.exception.BusinessException;

public interface CompanyService {
    CompanyDto save(CompanyDto companyDto) throws BusinessException;

    CompanyDto findCompanyById(Long id);
}
