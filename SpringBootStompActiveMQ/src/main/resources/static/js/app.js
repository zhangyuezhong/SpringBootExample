var stompClient = null;

function setConnected(connected) {
	$("#connect").prop("disabled", connected);
	$("#disconnect").prop("disabled", !connected);
	if (connected) {
		$("#conversation").show();
	} else {
		$("#conversation").hide();
	}
	$("#greetings").html("");
}

function connect() {
	var socket = new SockJS('/gs-guide-websocket');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		setConnected(true);
		console.log('Connected: ' + frame);

		stompClient.subscribe('/topic/greetings', function(greeting) {
			console.log("subscribe('/topic/greetings' 1 ")
			showGreeting(JSON.parse(greeting.body).content);
		});
		stompClient.subscribe('/topic/greetings', function(greeting) {
			console.log("subscribe('/topic/greetings' 2")
			showGreeting(JSON.parse(greeting.body).content);
		});
		stompClient.subscribe('/user/queue/reply', function(greeting) {
			console.log("subscribe('/user/queue/reply' 1")
			showGreeting(JSON.parse(greeting.body).content);
		});
		stompClient.subscribe('/user/queue/reply', function(greeting) {
			console.log("subscribe('/queue/reply' 2")
			showGreeting(JSON.parse(greeting.body).content);
		});
	}, function(msg) {
		alert("lost the connection " + msg);

	});
}

function disconnect() {
	if (stompClient != null) {
		stompClient.disconnect();
	}
	setConnected(false);
	console.log("Disconnected");
}

function sendName() {
	 stompClient.send("/app/hello", {}, JSON.stringify({'name' : $("#name").val() }));

	jQuery.ajax({
		url : "/greetings",
		type : "POST",
		data : JSON.stringify({
			"name" : $("#name").val()
		}),
		dataType : "json",
		contentType : "application/json; charset=utf-8",
		success : function() {
			console.log("send greeting");
		}
	});
}

function showGreeting(message) {
	$("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function() {
	$("form").on('submit', function(e) {
		e.preventDefault();
	});
	$("#connect").click(function() {
		connect();
	});
	$("#disconnect").click(function() {
		disconnect();
	});
	$("#send").click(function() {
		sendName();
	});
});