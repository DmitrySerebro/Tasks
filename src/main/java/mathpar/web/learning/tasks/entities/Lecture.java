package mathpar.web.learning.tasks.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity(name = "lectures")
public class Lecture {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "text")
    private String text;
    @Column(name = "author_id")
    private long authorId;
    @Column(name = "creation_date")
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @JoinColumn(name = "template_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private LectureTemplate template;

    public Lecture(LectureTemplate template, long authorId) {
        this.text = template.getText();
        this.authorId = authorId;
        this.template = template;
    }
}
