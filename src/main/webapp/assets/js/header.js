/*<![CDATA[*/
$(document).ready(function () {
	menuToggle();
});

function checkLogin(){
	let session = Cookies.get('session');
	if(session) return true;
	return false;
}

function menuToggle() {
	let cross = $('.cross');
	let hamburger = $('.hamburger');
	let menu = $('.menu');
	let logout = $('.btn-logout');
	let login = $('.btn-login');
	let register = $('.btn-register');
	let profile = $('.btn-profile');
	let isLogged = checkLogin();
	console.log("READY");

	cross.hide();
	hamburger.hide();
	
	if(!isLogged) {
		logout.hide();
		profile.hide();
	}
	else {
		login.hide();
		register.hide();
	}
	
	$(window).resize(function(){ 
		let windowWidth = $(window).width();
		if(windowWidth <= 730 && cross.is(':hidden')){
			
			if(!isLogged){
				login.hide();
				register.hide();
			} else {
				logout.hide();
				profile.hide();
			}
			
			menu.hide();
			hamburger.show();
			cross.hide();
			
		} else if(windowWidth >= 731) {
			
			if(!isLogged){
				login.show();
				register.show();
			} else {
				logout.show();
				profile.show();
			}
			
			menu.show();
			hamburger.hide();
			cross.hide();
		}
	})
	
    hamburger.click(function() {
    	
    	if(!isLogged){
			login.show();
			register.show();
		} else {
			logout.show();
			profile.show();
		}
    	
        menu.slideToggle('slow', function() {
        	hamburger.hide();
            cross.show();
        });
    });
    
    cross.click(function () {
        menu.slideToggle('slow', function() {
            cross.hide();
            if(!isLogged){
    			login.hide();
    			register.hide();
    		} else {
    			logout.hide();
    			profile.hide();
    		}
            hamburger.show();
        })
    });
}

function logout() {
	let session = Cookies.get('session');
	if(session) Cookies.remove('session', { path: '/vitrinegastronomica2' });
	else console.log("NÃO HÁ SESSÃO!");
}

/*]]>*/