var element = document.querySelector("#greeting");
element.innerText = "Test of Editor";

var canvas = document.querySelector("#canvasID");
var context = canvas.getContext("2d");

if(!context){element.innerText = "Error-1";}

var image = new Image();
image.src="http://www.asahi-net.or.jp/~yb7m-tkmt/img/appleview_icon.png";
image.onload = function(){
  context.drawImage(this, 0, 0);
};