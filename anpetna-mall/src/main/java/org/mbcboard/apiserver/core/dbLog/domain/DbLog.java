package org.mbcboard.apiserver.core.dbLog.domain;

import jakarta.persistence.*;
import lombok.*;
import org.mbcboard.apiserver.core.BaseEntity;

@Entity
@Table(name = "dblog_tbl")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DbLog extends BaseEntity {

    @Id
    @Column(name = "dblog_index")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logIndex;

    @Column(name = "dblog_ip")
    private String ip;

    @Column(name = "dblog_req")
    private String req;

    @Column(name = "dblog_res")
    private String res;
}
