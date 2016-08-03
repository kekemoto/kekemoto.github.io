<html>
	<head>
		<!--[if lt IE 9]>
		<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
		<![endif]-->
		
		<meta name="viewport" content="width=device-width,initial-scale=1.0">
		<meta http-equiv="Content-Type" content="text/html; charset=shift_jis">
		<meta name="keywords" content="けけもと,kekemoto,KEKEMOTO">
		<meta name="author" content="kekemoto">
		<meta name="twitter:card" content="summary_large_image" />
		<meta name="twitter:site" content="@nero1166" />
		<meta property="og:title" content="Top_kekemoto" />
		<meta property="og:description" content="けけもとのHPトップ" />
		<meta property="og:url" content="http://www.asahi-net.or.jp/~yb7m-tkmt/index.html" />
		<meta property="og:image" content="http://www.asahi-net.or.jp/~yb7m-tkmt/img/twitter.png" />
		<title>OutPut</title>
		<link rel="stylesheet" type="text/css" href="Layout2.css"/>
	</head>
	
	<body>
		<h1 id="title">Out Put</h1>

		<article>
			<h3>What?</h3>
			<p><a href="http://www.asahi-net.or.jp/~yb7m-tkmt/index.html">kekemoto</a>がやっていることを発信していく。</p>
		</article>

		<article>
			<h3>List</h3>
			<?php
				foreach(glob("*.html") as $filename){
					var_dump($filename);
				}
			?>
		</article>

		<footer>
			<a href="http://www.asahi-net.or.jp/~yb7m-tkmt/index.html">Home</a>
		</footer>

		<!--　アクセス解析　-->
		<div id="analysis">
			<a href="http://analytics.qlook.net/" target="_blank"><img src="http://kekemoto.analytics.qlook.net/counter.png" alt="QLOOKアクセス解析" id="kekemoto.analytics.qlook.net" width="80" height="15" style="border:0;"></a><script charset="UTF-8" src="http://kekemoto.analytics.qlook.net/analyze.js"></script><noscript><div><iframe src="http://kekemoto.analytics.qlook.net/analyze.html" title="QLOOKアクセス解析" style="width:0;height:0;"><img src="http://kekemoto.analytics.qlook.net/analyze.gif?guid=on" alt="QLOOKアクセス解析" width="1" height="1" style="border:0;"></iframe></div></noscript>
		</div>
	</body>
</html>
