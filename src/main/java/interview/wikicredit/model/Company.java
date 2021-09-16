package interview.wikicredit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.persistence.*;

@With
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wikipedia_data_id", referencedColumnName = "id")
    private WikipediaData wikipediaData;
}
