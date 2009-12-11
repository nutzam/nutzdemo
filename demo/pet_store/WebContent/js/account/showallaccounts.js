var showAllAccounts = {
	onLoadEvent : function() {
		$(document).ajaxError(function(event, request, settings){
			$("#error_message span").text("Network Error");
			$("#error_message").dialog("open");
		});
		userid = $("#userid"),
		password = $("#password"),
		firstname = $("#firstname"),
		lastname = $("#lastname"),
		phone = $("#phone"),
		email = $("#email"),
		address1 = $("#address1"),
		address2 = $("#address2"),
		city = $("#city"),
		state = $("#state"),
		zip = $("#zip"),
		country = $("#country"),
		allFields = $([]).add(userid).add(password).add(firstname).add(lastname).add(
			phone).add(email).add(address1).add(address2).add(city).add(
			state).add(zip).add(country);
		var funcHolder = this;
		$(".userid").bind("click", function() {
			funcHolder.showAccountDetail($(this).text());
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

		$("#create_dialog").dialog({
			bgiframe: true,
			autoOpen: false,
			height: 500,
			modal: true,
			buttons: {
				'Create an account': function() {
					funcHolder.createAccount($(this));
				},
				Cancel: function() {
					$(this).dialog('close');
				}
			},
			close: function() {
				allFields.val('').removeClass('ui-state-error');
			}
		});
		$("#update_dialog").dialog({
			bgiframe: true,
			autoOpen: false,
			height: 300,
			modal: true,
			buttons: {
				'Update an account': function() {
					var bValid = true;
					allFields.removeClass('ui-state-error');

					bValid = bValid && funcHolder.checkLength(name,"username",3,16);
					bValid = bValid && funcHolder.checkLength(email,"email",6,80);
					bValid = bValid && funcHolder.checkLength(password,"password",5,16);

					bValid = bValid && funcHolder.checkRegexp(name,/^[a-z]([0-9a-z_])+$/i,"Username may consist of a-z, 0-9, underscores, begin with a letter.");
					// From jquery.validate.js (by joern), contributed by Scott Gonzalez: http://projects.scottsplayground.com/email_address_validation/
					bValid = bValid && funcHolder.checkRegexp(email,/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i,"eg. ui@jquery.com");
					bValid = bValid && funcHolder.checkRegexp(password,/^([0-9a-zA-Z])+$/,"Password field only allow : a-z 0-9");
					
					if (bValid) {
						$('#users tbody').append('<tr>' +
							'<td>' + name.val() + '</td>' + 
							'<td>' + email.val() + '</td>' + 
							'<td>' + password.val() + '</td>' +
							'</tr>'); 
						$(this).dialog('close');
					}
				},
				Cancel: function() {
					$(this).dialog('close');
				}
			},
			close: function() {
				allFields.val('').removeClass('ui-state-error');
			}
		});
		$('#create-user').click(function() {
			$('#create_dialog').dialog('open');
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
	showAccountDetail : function(userid) {
		$('#update_dialog').dialog('open');
	},
	createAccount : function(dialog) {
		var bValid = true;
		allFields.removeClass('ui-state-error');

		bValid = bValid && this.checkLength(userid,"username",3,16);
		bValid = bValid && this.checkLength(password,"password",5,16);
		bValid = bValid && this.checkLength(firstname,"firstname",3,16);
		bValid = bValid && this.checkLength(lastname,"lastname",3,16);
		bValid = bValid && this.checkLength(email,"email",6,80);
		bValid = bValid && this.checkLength(address1,"address1",3,16);
		bValid = bValid && this.checkLength(city,"city",3,16);
		bValid = bValid && this.checkLength(state,"state",3,16);
		bValid = bValid && this.checkLength(zip,"zip",3,16);
		bValid = bValid && this.checkLength(country,"country",3,16);
		

		bValid = bValid && this.checkRegexp(userid,/^[a-z]([0-9a-z_])+$/i,"Username may consist of a-z, 0-9, underscores, begin with a letter.");
		bValid = bValid && this.checkRegexp(firstname,/^[a-z]([0-9a-z_])+$/i,"Firstname may consist of a-z, 0-9, underscores, begin with a letter.");
		bValid = bValid && this.checkRegexp(lastname,/^[a-z]([0-9a-z_])+$/i,"Lastname may consist of a-z, 0-9, underscores, begin with a letter.");
		// From jquery.validate.js (by joern), contributed by Scott Gonzalez: http://projects.scottsplayground.com/email_address_validation/
		bValid = bValid && this.checkRegexp(email,/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i,"eg. ui@jquery.com");
		bValid = bValid && this.checkRegexp(password,/^([0-9a-zA-Z])+$/,"Password field only allow : a-z 0-9");
		
		if (bValid) {
			var account={};
			account.userid=userid.val();
			account.email=email.val();
			account.firstName=firstname.val();
			account.lastName=lastname.val();
			account.address1=address1.val();
			account.address2=address2.val();
			account.city=city.val();
			account.state=state.val();
			account.zip=zip.val();
			account.country=country.val();
			account.phone=phone.val();
			$.ajax({
		        url:"mvc/account/createAccount.do",
		        type:"GET",
		        data:"account="+encodeURIComponent(JSON.stringify(account)),
		        dataType:"json",
		        success :function (result){
					if(result.detailMessage){
						alert(result.detailMessage);
					}else{
			            
			            $('#users tbody').append('<tr>' +
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