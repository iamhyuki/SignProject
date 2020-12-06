	function goBack(){
		window.history.back();
	}
	
	function waitAlert(){
		alert("이미 결재를 하였거나, 아직 결재순서가 아닙니다.");
	}
	
	function lineUp(){
		var user = $('#user_id').val();
		var url = "getUserList.do?user_id=" + user;
		window.open(url, "결재선지정화면", "toolbar=no, menubar=no, " +
		"scrollbars=yes, resizable=no, width=510, height=400");
	}
	
	function insertTemp(){
		$('#doc_status').val(0);
		document.formm.action = "insertSignDoc.do";
		document.formm.submit();
	}
	
	
	function addFileIndex(){
		var aStr = "<div><input type='file' name='uploadFile' />" +
				"<input type='button' id='fileDelBtn' value='삭제' /></div>";
		$('#fileIndex').append(aStr);
	}
	
	$(document).on("click","#fileDelBtn", function(){
		$(this).parent().remove();
	});

	function fileDown(sysname){
		$('#file_sysname').attr("value", sysname);
		document.formm.action = "fileDown.do";
		document.formm.submit();
	}
	
	var sysnameArr = new Array();
	function fileDelBtn(sysname){
		sysnameArr.push(sysname);
		$('#del_file').attr('value', sysnameArr);
	}
	$(document).on("click","#Del_Btn", function(){
		$(this).parent().remove();
	});
	

	
	
	
	