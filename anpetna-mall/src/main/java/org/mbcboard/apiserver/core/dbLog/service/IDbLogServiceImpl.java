package org.mbcboard.apiserver.core.dbLog.service;

import org.mbcboard.apiserver.core.dbLog.domain.DbLog;
import org.mbcboard.apiserver.core.dbLog.repository.IDbLogJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IDbLogServiceImpl implements IDbLogService {

    @Autowired
    IDbLogJpaRepository dbLogJpaRepository;

    @Override
    public void postLog(String ip, String req, String res) {
        var dblog = DbLog.builder()
                .ip(ip)
                .req(req)
                .res(res)
                .build();

        dbLogJpaRepository.save(dblog);
    }
}
