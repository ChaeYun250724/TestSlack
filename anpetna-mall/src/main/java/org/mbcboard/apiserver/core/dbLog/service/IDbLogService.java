package org.mbcboard.apiserver.core.dbLog.service;

public interface IDbLogService {
    void postLog(String ip, String req, String res);
}
