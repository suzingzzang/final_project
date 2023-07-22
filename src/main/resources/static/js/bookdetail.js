function increment() {
	var value = parseInt(document.getElementById("number").value, 10);
	value++;
	document.getElementById("number").value = value;
}

function decrement() {
	var value = parseInt(document.getElementById("number").value, 10);
	if (value > 1) {
		value--;
	}
	document.getElementById("number").value = value;
}

function incrementbook() {
	var value = parseInt(document.getElementById("bookquantity").value, 10);
	value++;
	document.getElementById("bookquantity").value = value;
}

function decrementbook() {
	var value = parseInt(document.getElementById("bookquantity").value, 10);
	if (value > 1) {
		value--;
	}
	document.getElementById("bookquantity").value = value;
}

function openTab(evt, tabName) {
	var i, tabcontent, tablinks;
	tabcontent = document.getElementsByClassName("tabcontent");
	for (i = 0; i < tabcontent.length; i++) {
		tabcontent[i].style.display = "none";
	}
	tablinks = document.getElementsByClassName("tablinks");
	for (i = 0; i < tablinks.length; i++) {
		tablinks[i].className = tablinks[i].className.replace(" active", "");
	}
	document.getElementById(tabName + "-content").style.display = "block";
	evt.currentTarget.className += " active";
}