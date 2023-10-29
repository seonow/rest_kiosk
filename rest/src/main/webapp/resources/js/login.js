const loginForm = document.loginForm;
const loginBtn = document.getElementById('loginBtn');
const inputs = document.querySelectorAll('input');

loginBtn.addEventListener('click', ()=> {
	let loginSuccess = true;
	inputs.forEach(input => {
		let inputStr = input.value
		if(inputStr.length == 0){
			loginSuccess = false;
		}
	});
	if(loginSuccess == false){
	alert('아이디와 비밀번호를 입력하세요');
	}
	if(loginSuccess == true){
	loginForm.action = '/login'
	loginForm.method = 'post';
	loginForm.submit();
	}
});