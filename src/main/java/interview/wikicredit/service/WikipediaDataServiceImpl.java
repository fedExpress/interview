package interview.wikicredit.service;

import interview.wikicredit.domain.EErrorCode;
import interview.wikicredit.dto.WikipediaDataDto;
import interview.wikicredit.exception.BusinessException;
import interview.wikicredit.model.Company;
import interview.wikicredit.model.WikipediaData;
import interview.wikicredit.repository.CompanyRepository;
import interview.wikicredit.repository.WikipediaDataRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class WikipediaDataServiceImpl implements WikipediaDataService {

    private final WikipediaDataRepository wikipediaDataRepository;

    private final CompanyRepository companyRepository;

    @Override
    public WikipediaDataDto save(WikipediaDataDto wikipediaDataDto) throws BusinessException {
        if (!ifSuchCompanyExists(wikipediaDataDto.getTitle())) {
            WikipediaData wikipediaData = wikipediaDataRepository.save(toWikipediaData(wikipediaDataDto));
            companyRepository.save(wikipediaData.getCompany().withWikipediaData(wikipediaData));
            return toWikipediaDataDto(wikipediaData);
        }
        throw new BusinessException().withCode(EErrorCode.WIKI_ENTRY_ALREADY_EXISTS);
    }

    @Override
    public WikipediaDataDto findWikiDataById(Long id) {
        Optional<WikipediaData> wikipediaData = wikipediaDataRepository.findById(id);
        return wikipediaData.map(this::toWikipediaDataDto).orElse(null);
    }

    @Override
    public WikipediaDataDto findWikiDataByInternalCompanyId(Long id) {
        Optional<WikipediaData> wikipediaData = wikipediaDataRepository.findByCompanyId(id);
        return wikipediaData.map(this::toWikipediaDataDto).orElse(null);
    }

    private boolean ifSuchCompanyExists(String title) {
        Optional<WikipediaData> wikipediaData = wikipediaDataRepository.findByTitle(title);
        return wikipediaData.isPresent();
    }

    private WikipediaData toWikipediaData(WikipediaDataDto dto) {
        return new WikipediaData()
                .withTitle(dto.getTitle())
                .withSummary(dto.getExtract())
                .withPageId(dto.getPageid())
                .withLoadingTimestamp(dto.getTimestamp())
                .withCompany(new Company()
                        .withId(dto.getCompanyDto().getId())
                        .withTitle(dto.getCompanyDto().getTitle()));
    }

    private WikipediaDataDto toWikipediaDataDto(WikipediaData data) {
        return new WikipediaDataDto()
                .withId(data.getId())
                .withTitle(data.getTitle())
                .withExtract(data.getSummary())
                .withPageid(data.getPageId())
                .withTimestamp(data.getLoadingTimestamp());
    }

}
