package com.nf.lc.service;

import com.nf.lc.exception.EmptyException;
import com.nf.lc.exception.FailureException;

public interface ExportTool {

    byte[] exportUser(int userState, int start, int end) throws EmptyException, FailureException;

    byte[] exportAdmin(int adminState,int start,int end) throws FailureException, EmptyException;

}
