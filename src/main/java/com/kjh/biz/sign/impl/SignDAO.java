package com.kjh.biz.sign.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kjh.biz.etc.SignDocListVO;
import com.kjh.biz.sign.SignDocVO;
import com.kjh.biz.sign.SignFileVO;
import com.kjh.biz.sign.SignGroupVO;

@Repository
public class SignDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public SignDAO() {
	}
	
	// 각 결재함 목록 개수 조회     
	public int getSignTemCount(String user_id){		
		return this.sqlSession.selectOne("signList.getSignTemCount", user_id);
	}
	public int getSignBackCount(String user_id){
		return this.sqlSession.selectOne("signList.getSignBackCount", user_id);
	}
	public int getSignSenCount(String user_id){
		return this.sqlSession.selectOne("signList.getSignSenCount", user_id);
	}
	public int getSignRecCount(String user_id){
		return this.sqlSession.selectOne("signList.getSignRecCount", user_id);
	}
	public int getSignCmpCount(){
		return this.sqlSession.selectOne("signList.getSignCmpCount");
	}
	
	// 각 결재함 문서 목록 조회
	public List<SignDocVO> getSignTemList(String user_id){
		return this.sqlSession.selectList("signList.getSignTemList", user_id);
	}
	public List<SignDocVO> getSignBackList(String user_id){
		return this.sqlSession.selectList("signList.getSignBackList", user_id);
	}
	public List<SignDocVO> getSignSenList(String user_id){
		return this.sqlSession.selectList("signList.getSignSenList", user_id);
	}
	public List<SignDocVO> getSignRecList(String user_id){
		return this.sqlSession.selectList("signList.getSignRecList", user_id);
	}
	public List<SignDocVO> getSignCmpList(){
		return this.sqlSession.selectList("signList.getSignCmpList");
	}	
	
	// 기안서 작성
	public void insertSignDoc(SignDocVO vo){
		this.sqlSession.insert("signDoc.insertSignDoc", vo);
	}

	public void insertSignGroup(SignGroupVO vo){
		this.sqlSession.insert("signDoc.insertSignGroup", vo);
	}
	
	public void insertSignFile(SignFileVO vo){
		this.sqlSession.insert("signDoc.insertSignFile", vo);
	}
	
	// 결재번호에 해당하는 문서(임시저장상태) 조회
	public SignDocVO getSignDoc(int doc_code){
		return this.sqlSession.selectOne("signDoc.getSignDoc", doc_code);
	}
	
	public List<SignGroupVO> getSignGroup(int doc_code){
		return this.sqlSession.selectList("signDoc.getSignGroup", doc_code);
	}
	
	public List<SignFileVO> getSignFile(int doc_code){
		return this.sqlSession.selectList("signDoc.getSignFile", doc_code);
	}
	
	public int getGroupCount(int doc_code){
		return this.sqlSession.selectOne("signDoc.getGroupCount", doc_code);
	}
	
	// 결재문서 삭제
	public void deleteSignDoc(int doc_code){
		this.sqlSession.delete("signDoc.deleteSignDoc", doc_code);
	}	
	
	// 결재번호에 해당하는 문서 조회
	public SignDocListVO getSignDocDetail(int doc_code){
		return this.sqlSession.selectOne("signDoc.getSignDocDetail", doc_code);
	}
	
	// 결재문서, 결재자, 첨부파일 수정 및 삭제
	public void updateSignDoc(SignDocVO vo){
		this.sqlSession.update("signDoc.updateSignDoc", vo);
	}
	
	public void deleteSignGroup(int doc_code){
		this.sqlSession.delete("signDoc.deleteSignGroup", doc_code);
	}
	
	public void insertSignGroupR(SignGroupVO vo){
		this.sqlSession.insert("signDoc.insertSignGroupR", vo);
	}
	
	public void updateFile(String sysname){
		this.sqlSession.update("signDoc.updateFile", sysname);
	}
	
	// 문서상태 변경, 결재자 결재완료 처리, 결재순서 조회 및 변경
	public void updateDocStatus(SignDocListVO vo){
		this.sqlSession.update("signDoc.updateDocStatus", vo);
	}
	
	public void updateSignStatus(SignDocListVO vo){
		this.sqlSession.update("signDoc.updateSignStatus", vo);
	}
	
	public void updateDocTurn(SignDocListVO vo){
		this.sqlSession.update("signDoc.updateDocTurn", vo);
	}
	
	public int getDocTurn(SignDocListVO vo){
		return this.sqlSession.selectOne("signDoc.getDocTurn", vo);
	}

	// 첨부파일 조회(for DownLoad)
	public SignFileVO getFileInfo(String sysname) {
		return this.sqlSession.selectOne("signDoc.getFileInfo", sysname);
	}
	
}
