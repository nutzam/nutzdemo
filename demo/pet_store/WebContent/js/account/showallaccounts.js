var showAllAccounts = {
	userid : null,
	password : null,
	firstname : null,
	lastname : null,
	phone : null,
	email : null,
	address1 : null,
	address2 : null,
	city : null,
	state : null,
	zip : null,
	country : null,
	allFields : null,
	isUpdate : false,
	onLoadEvent : function() {
		$(document).ajaxError(function(event, request, settings){
			$("#error_message span").text("Network Error");
			$("#error_message").dialog("open");
		});
		this.userid = $("#userid"),
		this.password = $("#password"),
		this.firstname = $("#firstname"),
		this.lastname = $("#lastname"),
		this.phone = $("#phone"),
		this.email = $("#email"),
		this.address1 = $("#address1"),
		this.address2 = $("#address2"),
		this.city = $("#city"),
		this.state = $("#state"),
		this.zip = $("#zip"),
		this.country = $("#country"),
		this.allFields = $([]).add(this.userid).add(this.password).add(this.firstname).add(this.lastname).add(
				this.phone).add(this.email).add(this.address1).add(this.address2).add(this.city).add(
						this.state).add(this.zip).add(this.country);
		var funcHolder = this;
		$(".userid").bind("click", function() {
			funcHolder.isUpdate=true;
			funcHolder.showAccountDetail($(this).text());
		});
		$("#check_all").bind("click", function() {
			$(":checkbox").attr("checked",$(this).attr("checked"));
		});
		$("#error_message").dialog({
			bgiframe: true,
			modal: true,
			autoOpen: false,
			buttons: {
				Ok: function() {
					$(this).dialog('close');
				}
			}
		});

		$("#dialog").dialog({
			bgiframe: true,
			autoOpen: false,
			height: 500,
			modal: true,
			buttons: {
				'OK': function() {
					funcHolder.createAccount($(this));
				},
				Cancel: function() {
					$(this).dialog('close');
				}
			},
			close: function() {
				funcHolder.allFields.val('').removeClass('ui-state-error');
			}
		});
		$('#create-user').click(function() {
			funcHolder.isUpdate=false;
			$('#dialog').attr("title","Create new user");
			$('#dialog').dialog('open');
		})
		.hover(
			function(){ 
				$(this).addClass("ui-state-hover"); 
			},
			function(){ 
				$(this).removeClass("ui-state-hover"); 
			}
		).mousedown(function(){
			$(this).addClass("ui-state-active"); 
		})
		.mouseup(function(){
				$(this).removeClass("ui-state-active");
		});
		$('#delete-user').click(function() {
			funcHolder.deleteAccount();
		})
		.hover(
			function(){ 
				$(this).addClass("ui-state-hover"); 
			},
			function(){ 
				$(this).removeClass("ui-state-hover"); 
			}
		).mousedown(function(){
			$(this).addClass("ui-state-active"); 
		})
		.mouseup(function(){
				$(this).removeClass("ui-state-active");
		});
	},
	showAccountDetail : function(useridtext) {
		var param = {};
		param.userid = useridtext;
		var funcHolder = this;
		$.ajax({
	        url:"mvc/account/showAccount.do",
	        type:"GET",
	        data:param,
	        dataType:"json",
	        success :function (result){
				if(result&&result.detailMessage){
					alert(result.detailMessage);
				}else{
					funcHolder.userid.val(result.userid);
					funcHolder.password.val("");
					funcHolder.email.val(result.email);
					funcHolder.firstname.val(result.firstName);
					funcHolder.lastname.val(result.lastName);
					funcHolder.address1.val(result.address1);
					funcHolder.address2.val(result.address2);
					funcHolder.city.val(result.city);
					funcHolder.state.val(result.state);
					funcHolder.zip.val(result.zip);
					funcHolder.country.val(result.country);
					funcHolder.phone.val(result.phone);
					$('#dialog').attr("title","Update user");
					$('#dialog').dialog('open');
				}
	        }
		});
	},
	deleteAccount : function() {
		var userids=[];
		$(":checkbox:checked").each(function(i,domEle) {
			if (domEle.id != "check_all") {
				userids.push(domEle.value);
			}
		});
		if(userids.length==0){
			alert("Please select one user.");
		}
			
		var param = {};
		param.userids = userids;
		$.ajax({
	        url:"mvc/account/deleteAccount.do",
	        type:"GET",
	        data:param,
	        dataType:"json",
	        success :function (result){
				if(result&&result.detailMessage){
					alert(result.detailMessage);
				}else{
		            alert("ok");
		            $(":checkbox:checked").each(function(i,domEle) {
		            	$(domEle).parent().parent().remove();
		    		});
				}
	        }
		});
	},
	createAccount : function(dialog) {
		if(this.isUpdate==true){
			this.updateAccount(dialog);
			return;
		}
		
		var bValid = true;
		this.allFields.removeClass('ui-state-error');

		bValid = bValid && this.checkLength(this.userid,"username",3,25);
		bValid = bValid && this.checkLength(this.password,"password",5,25);
		bValid = bValid && this.checkLength(this.firstname,"firstname",3,80);
		bValid = bValid && this.checkLength(this.lastname,"lastname",3,80);
		bValid = bValid && this.checkLength(this.email,"email",6,80);
		bValid = bValid && this.checkLength(this.address1,"address1",3,80);
		bValid = bValid && this.checkLength(this.address2,"address1",0,40);
		bValid = bValid && this.checkLength(this.city,"city",3,80);
		bValid = bValid && this.checkLength(this.state,"state",2,80);
		bValid = bValid && this.checkLength(this.zip,"zip",3,20);
		bValid = bValid && this.checkLength(this.country,"country",3,80);
		

		bValid = bValid && this.checkRegexp(this.userid,/^[a-z]([0-9a-z_])+$/i,"Username may consist of a-z, 0-9, underscores, begin with a letter.");
		bValid = bValid && this.checkRegexp(this.firstname,/^[a-z]([0-9a-z_])+$/i,"Firstname may consist of a-z, 0-9, underscores, begin with a letter.");
		bValid = bValid && this.checkRegexp(this.lastname,/^[a-z]([0-9a-z_])+$/i,"Lastname may consist of a-z, 0-9, underscores, begin with a letter.");
		// From jquery.validate.js (by joern), contributed by Scott Gonzalez: http://projects.scottsplayground.com/email_address_validation/
		bValid = bValid && this.checkRegexp(this.email,/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i,"eg. ui@jquery.com");
		bValid = bValid && this.checkRegexp(this.password,/^([0-9a-zA-Z])+$/,"Password field only allow : a-z 0-9");
		
		if (bValid) {
			var account={};
			account.userid=this.userid.val();
			account.email=this.email.val();
			account.firstName=this.firstname.val();
			account.lastName=this.lastname.val();
			account.address1=this.address1.val();
			account.address2=this.address2.val();
			account.city=this.city.val();
			account.state=this.state.val();
			account.zip=this.zip.val();
			account.country=this.country.val();
			account.phone=this.phone.val();
			$.ajax({
		        url:"mvc/account/createAccount.do",
		        type:"GET",
		        data:"account="+encodeURIComponent(JSON.stringify(account)),
		        dataType:"json",
		        success :function (result){
					if(result&&result.detailMessage){
						alert(result.detailMessage);
					}else{
			            
			            $('#users tbody').append('<tr>' +
			            		'<td><input type="checkbox" value="'+result.userid+'"/></td>' + 
			    				'<td>' + result.userid + '</td>' + 
			    				'<td>' + result.firstName + '</td>' + 
			    				'<td>' + result.lastName + '</td>' +
			    				'<td>' + result.email + '</td>' +
			    				'<td>' + result.phone + '</td>' +
			    				'</tr>');
			            dialog.dialog('close');
					}
		        }
			});
			
		}
	},
	updateAccount : function(dialog) {
		var bValid = true;
		this.allFields.removeClass('ui-state-error');

		bValid = bValid && this.checkLength(this.userid,"username",3,25);
		bValid = bValid && this.checkLength(this.password,"password",5,25);
		bValid = bValid && this.checkLength(this.firstname,"firstname",3,80);
		bValid = bValid && this.checkLength(this.lastname,"lastname",3,80);
		bValid = bValid && this.checkLength(this.email,"email",6,80);
		bValid = bValid && this.checkLength(this.address1,"address1",3,80);
		bValid = bValid && this.checkLength(this.address2,"address1",0,40);
		bValid = bValid && this.checkLength(this.city,"city",3,80);
		bValid = bValid && this.checkLength(this.state,"state",2,80);
		bValid = bValid && this.checkLength(this.zip,"zip",3,20);
		bValid = bValid && this.checkLength(this.country,"country",3,80);
		

		bValid = bValid && this.checkRegexp(this.userid,/^[a-z]([0-9a-z_])+$/i,"Username may consist of a-z, 0-9, underscores, begin with a letter.");
		bValid = bValid && this.checkRegexp(this.firstname,/^[a-z]([0-9a-z_])+$/i,"Firstname may consist of a-z, 0-9, underscores, begin with a letter.");
		bValid = bValid && this.checkRegexp(this.lastname,/^[a-z]([0-9a-z_])+$/i,"Lastname may consist of a-z, 0-9, underscores, begin with a letter.");
		// From jquery.validate.js (by joern), contributed by Scott Gonzalez: http://projects.scottsplayground.com/email_address_validation/
		bValid = bValid && this.checkRegexp(this.email,/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i,"eg. ui@jquery.com");
		bValid = bValid && this.checkRegexp(this.password,/^([0-9a-zA-Z])+$/,"Password field only allow : a-z 0-9");
		
		if (bValid) {
			var account={};
			account.userid=this.userid.val();
			account.email=this.email.val();
			account.firstName=this.firstname.val();
			account.lastName=this.lastname.val();
			account.address1=this.address1.val();
			account.address2=this.address2.val();
			account.city=this.city.val();
			account.state=this.state.val();
			account.zip=this.zip.val();
			account.country=this.country.val();
			account.phone=this.phone.val();
			$.ajax({
		        url:"mvc/account/updateAccount.do",
		        type:"GET",
		        data:"account="+encodeURIComponent(JSON.stringify(account)),
		        dataType:"json",
		        success :function (result){
					if(result&&result.detailMessage){
						alert(result.detailMessage);
					}else{
						dialog.dialog('close');
						window.location.reload(); 
					}
		        }
			});
			
		}
	},
	updateTips : function(t) {
		var tips = $("#validateTips");
		tips.text(t).effect("highlight", {}, 1500);
	},

	checkLength : function(o, n, min, max) {

		if (o.val().length > max || o.val().length < min) {
			o.addClass('ui-state-error');
			this.updateTips("Length of " + n + " must be between " + min + " and "
					+ max + ".");
			return false;
		} else {
			return true;
		}

	},
	checkRegexp : function(o, regexp, n) {

		if (!(regexp.test(o.val()))) {
			o.addClass('ui-state-error');
			this.updateTips(n);
			return false;
		} else {
			return true;
		}

	}
};