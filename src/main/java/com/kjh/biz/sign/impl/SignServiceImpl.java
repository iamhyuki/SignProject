package com.kjh.biz.sign.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kjh.biz.etc.SignDocListVO;
import com.kjh.biz.sign.SignDocVO;
import com.kjh.biz.sign.SignFileVO;
import com.kjh.biz.sign.SignGroupVO;
import com.kjh.biz.sign.SignService;

@Service
public class SignServiceImpl implements SignService {

	@Autowired
	private SignDAO signDAO;
	
	@Autowired
	private FileUtil fileUtil;
	
	public SignServiceImpl() {
	}
	
	@Override
	public int[] getSignMain(String user_id) {
		int[] listCount = {this.signDAO.getSignTemCount(user_id),
							this.signDAO.getSignBackCount(user_id),
							this.signDAO.getSignSenCount(user_id),
							this.signDAO.getSignRecCount(user_id),
							this.signDAO.getSignCmpCount()
							};
		return listCount;
	}	

	@Override
	public List<SignDocVO> getSignTemList(String user_id) {
		return this.signDAO.getSignTemList(user_id);
	}

	@Override
	public List<SignDocVO> getSignBackList(String user_id) {
		return this.signDAO.getSignBackList(user_id);
	}

	@Override
	public List<SignDocVO> getSignSenList(String user_id) {
		return this.signDAO.getSignSenList(user_id);
	}

	@Override
	public List<SignDocVO> getSignRecList(String user_id) {
		return this.signDAO.getSignRecList(user_id);
	}

	@Override
	public List<SignDocVO> getSignCmpList() {
		return this.signDAO.getSignCmpList();
	}
	
	@Override
	public void insertSignDoc(SignDocVO vo){
		this.signDAO.insertSignDoc(vo);
	}

	@Override
	public void insertSignGroup(SignGroupVO vo) {
		this.signDAO.insertSignGroup(vo);
	}

	@Override
	public void insertSignFile(SignFileVO vo) throws Exception {
		if(vo.getUploadFile() != null){
			List<SignFileVO> list = this.fileUtil.parseInsertFile(vo);
			
			for(int i=0; i<list.size(); i++){
				this.signDAO.insertSignFile(list.get(i));	
			}
		}
	}	

	@Override
	public SignDocVO getSignDoc(int doc_code) {
		return this.signDAO.getSignDoc(doc_code);
	}
	
	@Override
	public List<SignGroupVO> getSignGroup(int doc_code) {
		return this.signDAO.getSignGroup(doc_code);
	}

	@Override
	public List<SignFileVO> getSignFile(int doc_code) {
		return this.signDAO.getSignFile(doc_code);
	}
	
	@Override
	public int getGroupCount(int doc_code) {
		return this.signDAO.getGroupCount(doc_code);
	}

	@Override
	public void deleteSignDoc(int doc_code) {
		this.signDAO.deleteSignDoc(doc_code);
	}	
	
	@Override
	public SignDocListVO getSignDocDetail(int doc_code) {
		return this.signDAO.getSignDocDetail(doc_code);
	}	
	
	@Override
	public void updateSignDoc(SignDocVO vo) {
		this.signDAO.updateSignDoc(vo);
	}

	@Override
	public void deleteSignGroup(int doc_code) {
		this.signDAO.deleteSignGroup(doc_code);
	}

	@Override
	public void insertSignGroupR(SignGroupVO vo) {
		this.signDAO.insertSignGroupR(vo);
	}

	@Override
	public void updateSignFile(SignFileVO vo, String[] del_file) throws Exception {
		if(del_file != null){
			for(int i=0; i<del_file.length; i++){
				this.signDAO.updateFile(del_file[i]);
			}
		}
		if(vo.getUploadFile() != null){
			List<SignFileVO> list = this.fileUtil.parseInsertFile(vo);
			
			for(int i=0; i<list.size(); i++){
				this.signDAO.insertSignFile(list.get(i));	
			}
		}
	}

	@Override
	public void updateDocStatus(SignDocListVO vo) {
		this.signDAO.updateDocStatus(vo);
	}

	@Override
	public void updateSignStatus(SignDocListVO vo) {
		this.signDAO.updateSignStatus(vo);
		
	}

	@Override
	public int getDocTurn(SignDocListVO vo) {
		return this.signDAO.getDocTurn(vo);
	}

	@Override
	public void updateDocTurn(SignDocListVO vo) {
		this.signDAO.updateDocTurn(vo);
		
	}	
	
	@Override
	public SignFileVO getFileInfo(String sysname) {
		return this.signDAO.getFileInfo(sysname);
	}

}
