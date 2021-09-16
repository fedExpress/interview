package interview.wikicredit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.persistence.*;
import java.sql.Timestamp;


@With
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WikipediaData {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Long pageId;
    @Lob
    private String summary;
    private Timestamp loadingTimestamp;

    @OneToOne(mappedBy = "wikipediaData")
    private Company company;
}
