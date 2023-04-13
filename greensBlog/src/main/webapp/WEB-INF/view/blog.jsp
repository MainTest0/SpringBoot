<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<style>
* {
	margin: 0;
	padding: 0;
	list-style: none;
}

body {
	height: 100vh;
}

header {
	width: 1000px;
	background-color: green;
	padding: 20px;
}

nav {
	margin: 20px;
	display: flex;
	flex-direction: column;
	border: 1px solid black;
	border-radius: 10px;
	width: 170px;
	border: 1px solid black;
	height: 300px;
}

#all_nav {
	display: flex;
	margin-bottom: 5px;
}

#all_li_nav {
	display: flex;
}

li {
	margin: 2px;
}

section {
	width: 730px;
}

.bold_class {
	font-weight: bold;
}

.flex_side {
	display: flex;
}

.container {
	display: flex;
	flex-direction: column;
	justify-content: center;
}

img {
	width: 180px;
	height: 180px;
	display: flex;
	justify-content: center;
	align-items: center;
}

.images_div {
	display: flex;
}

#imgaes-div-date {
	height: 100px;
}

.images_div div div {
	width: 180px;
	flex-direction: column;
	margin-right: 30px;
	display: flex;
}

}
.images_div div div div {
	line-height: 2;
}

}
#imgaes-div-date {
	height: 30px;
}

#all_li_nav span{
	margin-left: 70px;
}
footer{
	justify-content: center;
	align-items: center;
	text-align: center;
	margin: 20px;
}

</style>
<body>
	<header>
		<div>
			<h1>Green's Blog ${principal}
			<span class="material-symbols-outlined"> settings </span>
			</h1>
			
		</div>
	</header>
	<div class="flex_side">
		<nav>
			<ul id="all_nav">
				<li id="all_li_nav">전체보기 <span class="material-symbols-outlined"> settings </span></li>
			</ul>
			<ul>
				<li>Python</li>
				<li>Java</li>
				<li>Ios</li>
				<li>소프트웨어 자료</li>
				<li>자료구조</li>
				<li>리눅스</li>
				<li>Git</li>
				<li>자기계발</li>
				<li class="bold_class">경영전략</li>
				<li>리더쉽</li>
			</ul>
		</nav>
		<section class="container">
			<div id="section-title">
				<p>경영 전략</p>
			</div>
			<div class="images_div">
				<div>
					<img src=images/cat1.jpg>
					<div>
						<p id="imgaes-div-date">팬덤 확보에 성공한 4세대 걸그룹의 차별화 전략</p>
						<div>
							<p>2022.12.30</p>
						</div>
					</div>
				</div>
				<div>
					<img src=images/cat2.jpg>
					<div>
						<p id="imgaes-div-date">불황 속에서도 기업 성장 꾀하는 전략</p>
						<div>
							<p>2022.12.08</p>
						</div>
					</div>
				</div>
				<div>
					<img src=images/cat3.jpg>
					<div>
						<p id="imgaes-div-date">CSV실행, 전략적으로 접근이 필요하다.</p>
						<div>
							<p>2022.12.07</p>
						</div>
					</div>
				</div>
				<div>
					<img src=images/cat4.jpg>
					<div>
						<p id="imgaes-div-date">뉴노멀 시대 사무실, 작은 변화로 직접 만족감 극대화하는 방법의 새로운 방법을 논하다.</p>
						<div>
							<p>2022.12.02</p>
						</div>
					</div>
				</div>
			</div>
			<div class="images_div">
				<div>
					<img src=images/cat1.jpg>
					<div>
						<p id="imgaes-div-date">팬덤 확보에 성공한 4세대 걸그룹의 차별화 전략</p>
						<div>
							<p>2022.12.30</p>
						</div>
					</div>
				</div>
				<div>
					<img src=images/cat2.jpg>
					<div>
						<p id="imgaes-div-date">불황 속에서도 기업 성장 꾀하는 전략</p>
						<div>
							<p>2022.12.08</p>
						</div>
					</div>
				</div>
				<div>
					<img src=images/cat3.jpg>
					<div>
						<p id="imgaes-div-date">CSV실행, 전략적으로 접근이 필요하다.</p>
						<div>
							<p>2022.12.07</p>
						</div>
					</div>
				</div>
				<div>
					<img src=images/cat4.jpg>
					<div>
						<p id="imgaes-div-date">뉴노멀 시대 사무실, 작은 변화로 직접 만족감 극대화하는 방법의 새로운 방법을 논하다.</p>
						<div>
							<p>2022.12.02</p>
						</div>
					</div>
				</div>
			</div>
			<div class="images_div">
				<div>
					<img src=images/cat1.jpg>
					<div>
						<p id="imgaes-div-date">팬덤 확보에 성공한 4세대 걸그룹의 차별화 전략</p>
						<div>
							<p>2022.12.30</p>
						</div>
					</div>
				</div>
				<div>
					<img src=images/cat2.jpg>
					<div>
						<p id="imgaes-div-date">불황 속에서도 기업 성장 꾀하는 전략</p>
						<div>
							<p>2022.12.08</p>
						</div>
					</div>
				</div>
				<div>
					<img src=images/cat3.jpg>
					<div>
						<p id="imgaes-div-date">CSV실행, 전략적으로 접근이 필요하다.</p>
						<div>
							<p>2022.12.07</p>
						</div>
					</div>
				</div>
				<div>
					<img src=images/cat4.jpg>
					<div>
						<p id="imgaes-div-date">뉴노멀 시대 사무실, 작은 변화로 직접 만족감 극대화하는 방법의 새로운 방법을 논하다.</p>
						<div>
							<p>2022.12.02</p>
						</div>
					</div>
				</div>
			</div>

		</section>
	</div>
	<footer>
		<re><이전 1 2 3 4 5 6 7 8 9 다음></re>
	</footer>
</body>
</html>