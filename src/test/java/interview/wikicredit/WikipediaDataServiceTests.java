package interview.wikicredit;

import interview.wikicredit.dto.CompanyDto;
import interview.wikicredit.dto.WikipediaDataDto;
import interview.wikicredit.exception.BusinessException;
import interview.wikicredit.model.Company;
import interview.wikicredit.model.WikipediaData;
import interview.wikicredit.repository.CompanyRepository;
import interview.wikicredit.repository.WikipediaDataRepository;
import interview.wikicredit.service.WikipediaDataServiceImpl;
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
public class WikipediaDataServiceTests {

    @InjectMocks
    private WikipediaDataServiceImpl wikipediaDataService;

    @Mock
    private WikipediaDataRepository wikipediaDataRepository;

    @Mock
    private CompanyRepository companyRepository;

    @Test
    public void testWikiSave_returnsWikipediaData() throws BusinessException {
        WikipediaDataDto sampleWikiData = new WikipediaDataDto().withTitle("Swedbank").withCompanyDto(new CompanyDto().withId(1L));
        when(wikipediaDataRepository.save(any(WikipediaData.class))).thenReturn(new WikipediaData().withTitle("Swedbank").withCompany(new Company().withId(1L)));
        WikipediaDataDto created = wikipediaDataService.save(sampleWikiData);
        assertThat(created.getTitle()).isEqualTo(sampleWikiData.getTitle());
    }

    @Test
    public void testWikiFindById_returnsWikipediaData() throws BusinessException {
        WikipediaDataDto sampleWikiData = new WikipediaDataDto().withTitle("Swedbank").withId(1L);
        when(wikipediaDataRepository.findById(1L)).thenReturn(Optional.of(new WikipediaData().withId(1L).withTitle("Swedbank")));
        WikipediaDataDto found = wikipediaDataService.findWikiDataById(1L);
        assertThat(found.getTitle()).isEqualTo(sampleWikiData.getTitle());
    }

    @Test
    public void testWikiFindByInternalCompanyId_returnsWikipediaData() throws BusinessException {
        WikipediaDataDto sampleWikiData = new WikipediaDataDto().withTitle("Swedbank").withId(1L);
        when(wikipediaDataRepository.findByCompanyId(1L)).thenReturn(Optional.of(new WikipediaData().withId(1L).withTitle("Swedbank")));
        WikipediaDataDto found = wikipediaDataService.findWikiDataByInternalCompanyId(1L);
        assertThat(found.getTitle()).isEqualTo(sampleWikiData.getTitle());
    }
}
