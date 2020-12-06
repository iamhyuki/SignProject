package com.kjh.view.sign;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kjh.biz.etc.SignDocListVO;
import com.kjh.biz.sign.SignDocVO;
import com.kjh.biz.sign.SignFileVO;
import com.kjh.biz.sign.SignGroupVO;
import com.kjh.biz.sign.SignService;
import com.kjh.biz.user.UserVO;


@Controller
public class SignContoller {
	
	@Autowired
	private SignService signService;
	
	public SignContoller() {
	}

// menu 관련 요청사항
	/**
	 * 메인 화면 시 요청사항 
	 * 보관함 목록개수 selectOne / main.jsp로 이동
	 **/
	@RequestMapping(value = "/getSignMain.do")
	public String getSignMain(HttpSession session, Model model) {
		UserVO user = (UserVO) session.getAttribute("user");
		String user_id = user.getUser_id();
		
		model.addAttribute("signCount", this.signService.getSignMain(user_id));
		return "main.jsp";
	}

	/**
	 * 임시저장함 클릭 시 요청사항 
	 * 기안자본인만 보이는, 임시저장 상태의 목록 selectList / signTemList.jsp로 이동
	 **/
	@RequestMapping(value = "/getSignTemList.do")
	public String getSignTemList(HttpSession session, Model model) {
		UserVO user = (UserVO) session.getAttribute("user");
		String user_id = user.getUser_id();
		
		model.addAttribute("temList", this.signService.getSignTemList(user_id));
		return "signTemList.jsp";
	}

	/**
	 * 반려문서함 클릭 시 요청사항 
	 * 기안자본인만 보이는, 반려 상태의 목록 selectList / signBackList.jsp로 이동
	 **/
	@RequestMapping(value = "/getSignBackList.do")
	public String getSignBackList(HttpSession session, Model model) {
		UserVO user = (UserVO) session.getAttribute("user");
		String user_id = user.getUser_id();
		
		model.addAttribute("backList", this.signService.getSignBackList(user_id));
		return "signBackList.jsp";
	}

	/**
	 * 결재상신함 클릭 시 요청사항 
	 * 기안자본인만 보이는, 심사중,대기중 상태의 목록 selectList / signSenList.jsp로 이동
	 **/
	@RequestMapping(value = "/getSignSenList.do")
	public String getSignSenList(HttpSession session, Model model) {
		UserVO user = (UserVO) session.getAttribute("user");
		String user_id = user.getUser_id();
		
		model.addAttribute("senList", this.signService.getSignSenList(user_id));
		return "signSenList.jsp";
	}

	/**
	 * 결재수신함 클릭 시 요청사항
	 * 결재선인원만 보이는, 심사중,대기중 상태의 목록 selectList / signRecList.jsp로 이동
	 **/
	@RequestMapping(value = "/getSignRecList.do")
	public String getSignRecList(HttpSession session, Model model) {
		UserVO user = (UserVO) session.getAttribute("user");
		String user_id = user.getUser_id();
		
		model.addAttribute("recList", this.signService.getSignRecList(user_id));
		return "signRecList.jsp";
	}

	/**
	 * 완료문서함 클릭 시 요청사항 
	 * 전체인원들에게 보이는, 결재완료 상태의 목록 selectList / signCmpList.jsp로 이동
	 **/
	@RequestMapping(value = "/getSignCmpList.do")
	public String getSignCmpList(Model model) {
		model.addAttribute("cmpList", this.signService.getSignCmpList());
		return "signCmpList.jsp";
	}

// 각 보관함 관련 요청사항
	/**
	 * 임시보관함에서 목록 제목 클릭 시 요청사항 
	 * 해당 결재번호의 문서 selectOne&DocCode= / signUpdateForm.jsp로 이동
	 **/
	@RequestMapping(value = "/getSignUpdateForm.do")
	public String getSignUpdateForm(int doc_code, Model model) {
		model.addAttribute("doc", this.signService.getSignDoc(doc_code));
		model.addAttribute("group", this.signService.getSignGroup(doc_code));
		model.addAttribute("file", this.signService.getSignFile(doc_code));
		model.addAttribute("G_COUNT", this.signService.getGroupCount(doc_code));
		return "signUpdateForm.jsp";
	}
	
	/**
	 * 반려문서함, 결재상신함, 결재수신함, 완료문서함에서 목록 제목 클릭 시 요청사항
	 * 결재번호의 문서 selectOne&DocCode= / signDocDetail.jsp로 이동
	 **/
	@RequestMapping(value = "/getSignDocDetail.do")
	public String getSignDocDetail(int doc_code, Model model) {
		model.addAttribute("doc", this.signService.getSignDocDetail(doc_code));
		model.addAttribute("group", this.signService.getSignGroup(doc_code));
		model.addAttribute("file", this.signService.getSignFile(doc_code));
		return "signDocDetail.jsp";
	}
	
// 기안서 문서 관련 요청사항
	/**
	 * 기안서 작성클릭 시 요청사항 
	 * signForm.jsp로 이동
	 **/
	@RequestMapping(value = "/signForm.do")
	public String signForm() {
		return "signForm.jsp";
	}

	/**
	 * 결재요청 또는 임시저장 클릭 시 요청사항 
	 * 결재문서 insert / 결재자 insert / getSignSenList.do or getSignTemList.do 요청
	 **/
	@RequestMapping(value = "/insertSignDoc.do")
	public String insertSignDoc(SignDocVO doc, SignGroupVO group, SignFileVO file, HttpServletRequest request) throws Exception{
		// 결재문서
		this.signService.insertSignDoc(doc);

		// 결재자
		String[] idArr = request.getParameterValues("s_id[]");
		String[] turnArr = request.getParameterValues("s_turn[]");
		String[] typeArr = request.getParameterValues("s_type[]");
		group.setUser_id(doc.getUser_id());
		
		for(int i=0; i< idArr.length; i++){
			group.setSign_id(idArr[i]);
			group.setSign_turn(Integer.parseInt(turnArr[i]));
			group.setSign_type(typeArr[i]);
			this.signService.insertSignGroup(group);
		}

		// 결재첨부파일
		this.signService.insertSignFile(file);
		
		if(doc.getDoc_status()==0){
			return "getSignTemList.do";
		} else {
			return "getSignSenList.do";
		}
	}

	/**
	 * 기안서 삭제 클릭 시 요청사항 
	 * 해당 결재문서 및 결재자 delete / getSignTemList.do 요청
	 **/
	@RequestMapping(value = "/deleteSignDoc.do")
	public String deleteSignDoc(int doc_code) {
		this.signService.deleteSignDoc(doc_code);
		return "getSignTemList.do";
	}

	/**
	 * 임시저장문서에서 결재요청 클릭 시 요청사항 
	 * 해당 결재문서 update / 결재자 delete&insert / getSignSenList.do 요청
	 **/
	@RequestMapping(value = "/updateSignDoc.do")
	public String updateSignDoc(SignDocVO doc, SignGroupVO group, SignFileVO file, HttpServletRequest request) throws Exception{
		int doc_code = doc.getDoc_code();
		
		// 결재문서
		this.signService.updateSignDoc(doc);
		// 결재자
		this.signService.deleteSignGroup(doc_code);
		
		String[] idArr = request.getParameterValues("s_id[]");
		String[] turnArr = request.getParameterValues("s_turn[]");
		String[] typeArr = request.getParameterValues("s_type[]");
		group.setUser_id(doc.getUser_id());
		group.setDoc_code(doc_code);
		for(int i=0; i< idArr.length; i++){
			group.setSign_id(idArr[i]);
			group.setSign_turn(Integer.parseInt(turnArr[i]));
			group.setSign_type(typeArr[i]);
			this.signService.insertSignGroupR(group);
		}
		
		// 결재파일
		String del_file = request.getParameter("del_file[]");
		String[] del_file_list = del_file.split(",");
		this.signService.updateSignFile(file, del_file_list);
		
		return "getSignSenList.do";
	}

	/**
	 * 회수  / 반려 / 결재클릭 시 요청사항
	 * getSignTemList.do / getSignRecList.do / 요청
	 **/
	@RequestMapping(value = "/updateStatus.do")
	public String updateStatus(SignDocListVO vo) {
		vo.setComplete_date("");
		// 회수
		if(vo.getDoc_status() == 0){
			this.signService.updateDocStatus(vo);
			return "getSignTemList.do";
		}
		// 반려
		else if (vo.getDoc_status() == 3){
			this.signService.updateDocStatus(vo);
			return "getSignRecList.do";
		}
		//
		else if(vo.getDoc_status() == 5){
			this.signService.updateSignStatus(vo);
			this.signService.updateDocTurn(vo);
			int turn = this.signService.getDocTurn(vo);
			if(turn != -1){
				if(vo.getDoc_status() != 2){
					vo.setDoc_status(2);
					this.signService.updateDocStatus(vo);
					this.signService.updateSignStatus(vo);
					return "getSignRecList.do";
				} 
			}
			if(turn == -1){
				vo.setDoc_status(4);
				SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
				vo.setComplete_date(sd.format(new Date()));
				this.signService.updateDocStatus(vo);
				return "getSignCmpList.do";
			}
			
		}
		return "getSignRecList.do";
	}
	
	/**
	 * 기안서 수정에서 파일제목 클릭 시 요청사항
	 * 첨부파일 다운로드
	 * */
	@RequestMapping(value="/fileDown.do")
	public void fileDown(String file_sysname, SignFileVO vo,HttpServletResponse response) throws IOException{
		SignFileVO file = this.signService.getFileInfo(file_sysname);
	
		byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:/signfile/" + file.getSysname()));
		
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition",  "attachment; fileName=\""+URLEncoder.encode(file.getOrgname(), "UTF-8")+"\";");
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
}
