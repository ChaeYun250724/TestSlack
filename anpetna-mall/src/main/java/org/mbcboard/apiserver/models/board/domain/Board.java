package org.mbcboard.apiserver.models.board.domain;

import jakarta.persistence.*;
import lombok.*;
import org.mbcboard.apiserver.core.BaseEntity;

@Entity
@Table(name = "board_tbl")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board extends BaseEntity {

    @Id
    @Column(name = "board_index")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardIndex;

    @Column(name = "board_title",
            length = 500)
    private String title;

    @Column(name = "board_content",
            length = 2000)
    private String content;

    @Column(name = "board_view_count",
            length = 10)
    private int viewCount;

    @Column(name = "board_writer",
            length = 50)
    private String writerId;

    @Column(name = "is_deleted", nullable = false, length = 1)
    private String deletedYn;

    @PrePersist
    public void prePersist() {
        if (this.deletedYn == null) {
            this.deletedYn = "N";
        }
    }
}
