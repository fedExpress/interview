package interview.wikicredit.controller;

import interview.wikicredit.domain.EErrorCode;
import interview.wikicredit.dto.CompanyDto;
import interview.wikicredit.dto.WikipediaDataDto;
import interview.wikicredit.exception.BusinessException;
import interview.wikicredit.service.CompanyService;
import interview.wikicredit.service.WikipediaDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RestController
@RequestMapping("/wiki")
@AllArgsConstructor
public class WikiLoadingController {

    private final WikipediaDataService wikipediaDataService;

    private final CompanyService companyService;

    private final RestTemplate restTemplate;

    @GetMapping("/load-data/{id}")
    public WikipediaDataDto getWikiDataFromAPI(@PathVariable Long id) throws BusinessException {
        CompanyDto companyDto = companyService.findCompanyById(id);

        if (Objects.isNull(companyDto)) {
            throw new BusinessException().withCode(EErrorCode.COMPANY_NOT_FOUND);
        }

        final String uri = String.format("https://en.wikipedia.org/api/rest_v1/page/summary/%s", companyDto.getTitle());

        WikipediaDataDto result = restTemplate.getForObject(uri, WikipediaDataDto.class);

        if (!Objects.isNull(result)) {
            result.setCompanyDto(companyDto);
            return wikipediaDataService.save(result);
        }
        return null;
    }

    @GetMapping("/{id}")
    public WikipediaDataDto getWikiDataLocal(@PathVariable Long id) {
        return wikipediaDataService.findWikiDataById(id);
    }

}
