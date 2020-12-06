package com.kjh.biz.sign.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.kjh.biz.sign.SignFileVO;

@Component
public class FileUtil {
	
	
	public FileUtil() {
	}
	
	private static final String FILEPATH = "C:/signfile/";
	
	public static String getRandomString(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public List<SignFileVO> parseInsertFile(SignFileVO vo) throws Exception{
		
		File file = new File(FILEPATH);
		if(file.exists() == false){
			file.mkdir();
		}
		
		String orgTempName;
		String sysTempName;
		MultipartFile[] mpFile = vo.getUploadFile();
		List<SignFileVO> list = new ArrayList<SignFileVO>();
		
		for(int i=0; i< mpFile.length; i++){
			if(mpFile[i].isEmpty() == false){
				orgTempName = mpFile[i].getOriginalFilename();
				sysTempName = getRandomString() + orgTempName.substring(orgTempName.lastIndexOf("."));
				
				vo = new SignFileVO();
				vo.setOrgname(orgTempName);
				vo.setSysname(sysTempName);
				list.add(vo);

				mpFile[i].transferTo(new File(FILEPATH + sysTempName));
			}
		}
		return list;
	}

}
