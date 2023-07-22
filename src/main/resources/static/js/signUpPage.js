$(document).ready(function() {
	$("#buttonCancel").on("click", function() {
		window.location = "[[@{/sign}]]";
	});
});

var formSubmitting = false;

function checkEmailUniqueButton(userId, userEmail) {
	if (formSubmitting) return; // 폼 제출 중이라면 함수 실행 중지
	formSubmitting = true; // 폼 제출 상태로 변경
	
	url = "@{/sign/check_email}";
	csrfValue = $("input[name='_csrf']").val();
	params = {id: userId, email: userEmail, _csrf: csrfValue};

	$.post(url, params, function(response) {
		if (response == "OK") {
			showModalDialog("Possible", userEmail + "this email is available");
		} else if (response == "Duplicated") {
			showModalDialog("Warning", userEmail + " is already existed");
		} else {
			showModalDialog("Error", "Unknown response from server");
		}
	}).fail(function() {
		showModalDialog("Error", "Could not connect to the server");
	}).always(function() {
		formSubmitting = false; // 폼 제출 상태를 다시 false로 변경
	});
}

function showModalDialog(title, message) {
	$("#modalTitle").text(title);
	$("#modalBody").text(message);
	$("#modalDialog").modal();
}

$(document).ready(function() {
	$('button#duplicateCheckButton').click(function(event) {
		event.preventDefault();
		checkEmailUniqueButton($('#userId').val(), $('#email').val());
	});
});


function sample6_execDaumPostcode() {
	new daum.Postcode({
		oncomplete: function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수

			//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}

			// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			if (data.userSelectedType === 'R') {
				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if (extraAddr !== '') {
					extraAddr = ' (' + extraAddr + ')';
				}
				// 조합된 참고항목을 해당 필드에 넣는다.
				document.getElementById("sample6_extraAddress").value = extraAddr;

			} else {
				document.getElementById("sample6_extraAddress").value = '';
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById('sample6_postcode').value = data.zonecode;
			document.getElementById("sample6_address").value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("sample6_detailAddress").focus();
		}
	}).open();
}

function checkPassword() {
	var password1 = document.getElementById("password").value;
	var password2 = document.getElementById("password_check").value;
	if (password1 != password2) {
		document.getElementById("passwordError").innerHTML = "비밀번호가 일치하지 않습니다.";
	} else {
		document.getElementById("passwordError").innerHTML = "";
	}
}