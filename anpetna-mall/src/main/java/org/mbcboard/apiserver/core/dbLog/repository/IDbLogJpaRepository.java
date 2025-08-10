package org.mbcboard.apiserver.core.dbLog.repository;

import org.mbcboard.apiserver.core.dbLog.domain.DbLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDbLogJpaRepository extends JpaRepository<DbLog, Long> {

}
