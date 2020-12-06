package com.kjh.biz.sign;

import java.util.List;

import com.kjh.biz.etc.SignDocListVO;

public interface SignService {

	int[] getSignMain(String user_id);	
	
	List<SignDocVO> getSignTemList(String user_id);
	
	List<SignDocVO> getSignBackList(String user_id);
	
	List<SignDocVO> getSignSenList(String user_id);
	
	List<SignDocVO> getSignRecList(String user_id);
	
	List<SignDocVO> getSignCmpList();	
	
	void insertSignDoc(SignDocVO vo);
	
	void insertSignGroup(SignGroupVO vo);
	
	void insertSignFile(SignFileVO vo) throws Exception;
	
	SignDocVO getSignDoc(int doc_code);
	
	List<SignGroupVO> getSignGroup(int doc_code);
	
	List<SignFileVO> getSignFile(int doc_code);
	
	int getGroupCount(int doc_code);
	
	void deleteSignDoc(int doc_code);
	
	SignDocListVO getSignDocDetail(int doc_code);
	
	void updateSignDoc(SignDocVO vo);
	
	void deleteSignGroup(int doc_code);
	
	void insertSignGroupR(SignGroupVO vo);	
	
	void updateSignFile(SignFileVO vo, String[] del_file_list) throws Exception;
	
	void updateDocStatus(SignDocListVO vo);
	
	void updateSignStatus(SignDocListVO vo);
	
	int getDocTurn(SignDocListVO vo);
	
	void updateDocTurn(SignDocListVO vo);
	
	SignFileVO getFileInfo(String sysname);
	
}