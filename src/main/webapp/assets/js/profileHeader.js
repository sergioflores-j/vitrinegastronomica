/*<![CDATA[*/
$(document).ready(function () {
	checkLogin();
});

function checkLogin(){
	let session = Cookies.get('session');
	if(session) return true;
	return false;
}

function logout() {
	let session = checkLogin();
	if(session) Cookies.remove('session', { path: '/vitrinegastronomica2' });
	else console.log("NÃO HÁ SESSÃO!");
}

/*]]>*/