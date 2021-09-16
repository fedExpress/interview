package interview.wikicredit.service;

import interview.wikicredit.dto.WikipediaDataDto;
import interview.wikicredit.exception.BusinessException;

public interface WikipediaDataService {
    WikipediaDataDto save(WikipediaDataDto wikipediaDataDto) throws BusinessException;

    WikipediaDataDto findWikiDataById(Long id);

    WikipediaDataDto findWikiDataByInternalCompanyId(Long id);
}
