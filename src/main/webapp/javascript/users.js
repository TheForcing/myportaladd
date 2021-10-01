function checkEmail(obj, url) {
	//obj:object
	//url:  ajax api 호출하기 위한 url
	
	if (obj.form.email.value.trim().length === 0) {
		 alert("이베일을 입력하세여")
	      return;
	}
	
	// TODO: Ajax로 url에 중복 이메일 검사
}