package interview.wikicredit.controller;

import interview.wikicredit.dto.CompanyDto;
import interview.wikicredit.dto.WikipediaDataDto;
import interview.wikicredit.exception.BusinessException;
import interview.wikicredit.domain.EErrorCode;
import interview.wikicredit.service.CompanyService;
import interview.wikicredit.service.WikipediaDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/company")
@AllArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    private final WikipediaDataService wikipediaDataService;

    @PostMapping
    public CompanyDto save(@RequestBody @Valid CompanyDto companyDto) throws BusinessException {
        return companyService.save(companyDto);
    }

    @GetMapping("/{id}")
    public CompanyDto getWikiDataLocal(@PathVariable Long id) {
        return companyService.findCompanyById(id);
    }

    @GetMapping("/summary/{id}")
    public WikipediaDataDto getCompanySummaryByInternalId(@PathVariable Long id) throws BusinessException {
        if (!Objects.isNull(companyService.findCompanyById(id))) {
            return wikipediaDataService.findWikiDataByInternalCompanyId(id);
        }
        throw new BusinessException().withCode(EErrorCode.COMPANY_NOT_FOUND);
    }


}