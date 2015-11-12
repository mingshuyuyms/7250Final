<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html ng-app="myApp" class="no-js">
<head>
<link href="resources/css/styles.css" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Open+Sans:500,400,300,600"
	rel="stylesheet" type="text/css">
<title>Home</title>
</head>
<body>
	<header>
		<div class="overlay"></div>
		<div class="wrapper center row">
			<div class="left icon">
				<img src="resources/img/icon.png">
			</div>
			<nav>
				<a href="#/about">About</a> <a href="#">BI Platform</a>
			</nav>
			<div class="align-center center">
				<h1>Raising Money to Fund an Organizational Mission</h1>
				<h4>Help worthy organizations more efficiently target and
					recruit loyal donors to support their causes.</h4>
			</div>
			<div class="downArrow center" id="down">
				<a ng-click="gotoFirst()">See More</a> <img
					src="resources/img/down.png">
			</div>
		</div>
	</header>
	<div ng-controller="HelloCtrl">
		<a id="majot"></a>
		<section>
			<div class="center row">
				<div class="quote">
					<h3>Candidate VS Non-Profit</h3>
					<p>Nonprofit donation is higher than the candidates. We can
						conclude that many nonprofit organizations fear involvement in
						election could violate legal restrictions. But the law clearly
						allows nonprofits to engage in voter education, voter
						registration, and get-out-the-vote activities. For what we can do
						is helping them to more non Candidate and Nonprofit have the
						similar rate in the pit chart. It has a fair balance of this two
						different donation major.</p>
					<br />
					<br />
					<p class="bright">
						<input type="radio" ng-model="test1.type" value="column2d"
							ng-click="renderNow1()">BAR&nbsp;&nbsp;&nbsp;</input> <input
							type="radio" ng-model="test1.type" value="doughnut2D"
							ng-click="renderNow1()">PIE</input>
					</p>
				</div>
				<div id="chartContainer" class="chart"></div>
			</div>
		</section>
		<section>
			<div class="center row wrapper">
				<div id="chartContainer2" class="chart"></div>
				<div class="quote">
					<h3>Donation Compared by Vector Minor</h3>
					<p>They are CNP Council for National Policy (CNP),Congress,
						DEF,IMM,MEM, MIL,PAC,POLICY,REL,Senate,State, TAX POLICY
						contributes much more than others. It is three times of congress!
						And we can also see the states contribute the least. The pie chart
						shows that the POLICY has done half part of the donation. That's
						amazing. Military , PAC , Senate and tax, they have the similar
						rate. Every politician loves to talk about all the "small"
						donations they've received, But the money that really pays for
						elections comes from big donors, not little ones.</p>
					<br />
					<br />
					<p class="bright">
						<input type="radio" ng-model="test2.type" value="column2d"
							ng-click="renderNow2()">BAR&nbsp;&nbsp;&nbsp;&nbsp;</input> <input
							type="radio" ng-model="test2.type" value="doughnut2D"
							ng-click="renderNow2()">PIE&nbsp;&nbsp;&nbsp;</input>
					</p>
				</div>
			</div>
		</section>
		<section>
			<div class="center row wrapper">
				<div class="quote">
					<h3>Donation Variation Trend in {{year}}</h3>
					<p>Third result is about the trend and lifecycle of the
						donation There lines shows the three different years. The 2012 is
						the election year. This is the three years before it. We can see
						the 2011 have less in total year than other two years. And we can
						see every march is a turning point. This tells the candidates, if
						you want to raise money, please start earlier.</p>
					<br />
					<br />
					<p class="bright">
						<input type="radio" ng-model="year" value="2009"
							ng-click="getTrend()">2009&nbsp;&nbsp;&nbsp;</input> <input
							type="radio" ng-model="year" value="2010" ng-click="getTrend()">2010&nbsp;&nbsp;&nbsp;</input>
						<input type="radio" ng-model="year" value="2011"
							ng-click="getTrend()">2011&nbsp;&nbsp;&nbsp;</input> <input
							type="radio" ng-model="year" value="all" ng-click="getTrend()">Compare
						All</input>
					</p>
				</div>
				<div id="chartContainer3" class="chart"></div>
			</div>
		</section>
		<section>
			<div class="row center wrapper">
				<div id="chart-container" class="chart">An angular guage will
					load here!</div>
				<div class="quote">
					<h3>Count Top 10 Donation Prospect</h3>
					<p>left side is there donation id. There organizations are
						generous. It's really important for Citizens United v. Federal
						Election Commission to know who are the most generous donors. The
						most often donors. Service Employees International Union, ActBlue, 
						American Fedn of St/Cnty/Munic Employees, National Education
						Assn, American Federation of Teachers, National Assn of Realtors, Las
						Vegas Sands, AT&T Inc.</p>
				</div>
			</div>
		</section>
		<section>
			<div class="row center wrapper" id="formSec">
				<div class="quote">
					<h3>Donation Compared by Project</h3>
					<p>In many cases, the state requires that contributors provide
						the campaigns with their occupation and/or employer. When that
						information is available, the Institute uses it to assign a
						category code for individual contributors. When that information
						is not required or candidates do not provide it, the staff uses
						standard research tools to determine an economic or political
						identity. Contributors for whom researchers cannot determine an
						economic interest from the information available receive a code
						indicating their interest is Unknown.</p>
					<br />
					<br />
					<p class="bright">
						Sample Projects <input type="radio" ng-model="projectId"
							value="13" ng-click="getRecommendForm()" id="firstTrigger">13&nbsp;&nbsp;</input>
						<input type="radio" ng-model="projectId" value="14"
							ng-click="getRecommendForm()">14&nbsp;&nbsp;</input> <input
							type="radio" ng-model="projectId" value="15"
							ng-click="getRecommendForm()">15&nbsp;&nbsp;</input> <input
							type="radio" ng-model="projectId" value="16"
							ng-click="getRecommendForm()">16&nbsp;&nbsp;</input> <input
							type="radio" ng-model="projectId" value="17"
							ng-click="getRecommendForm()">17&nbsp;&nbsp;</input>
					</p>
				</div>

				<div id="recommendForm" ng-model="recommendForm">
					<table class="CSSTableGenerator">
						<tbody>
							<tr>
								<td>Project Id</td>
								<td>Prospect Id</td>
							</tr>
							<tr ng-repeat="obj in recommendForm">
								<td>{{obj.projectId}}</td>
								<td>{{obj.prospectId}}</td>
							</tr>
						</tbody>
					</table>

				</div>
			</div>
		</section>

		<section>
			<div class="row center wrapper">
				<div id="mapContainer" class="chart">FusionMaps XT will load s
					map here!</div>
				<div class="quote">
					<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Donation
						Compared by State</h3>
					<p>Dark to bright shows the contribution of the states. You can
						also use a zip code to find out who's making political donations
						in your area, which candidates your neighbors are supporting,
						who's funding your elected officials and more. In the remaining 39
						states, contributions to candidates from individuals, political
						parties, PACs, corporations and unions are typically limited or,
						in the case of corporations and unions, prohibited outright. At
						least 14 states (Arizona, California, Colorado, Georgia, Illinois,
						Maine, Montana, Nebraska, New Jersey, New Mexico, New York, Ohio,
						Tennesse and Washington) index their contribution limits. All
						adjust their limits periodically according to the Consumer Price
						Index.</p>
				</div>
			</div>
		</section>
	</div>

	<script src="resources/js/angular.min.js"></script>
	<script src="resources/js/myApp.js"></script>
	<script type="text/javascript"
		src="resources/js/fusioncharts/fusioncharts.js"></script>
	<script type="text/javascript"
		src="resources/js/fusioncharts/fusioncharts.charts.js"></script>
	<script type="text/javascript"
		src="resources/js/fusioncharts/fusioncharts.gantt.js"></script>
	<script type="text/javascript"
		src="resources/js/fusioncharts/fusioncharts.powercharts.js"></script>
	<script type="text/javascript"
		src="resources/js/fusioncharts/fusioncharts.widgets.js"></script>
	<script type="text/javascript"
		src="resources/js/fusioncharts/fusioncharts.maps.js"></script>
	<script type="text/javascript"
		src="resources/js/fusioncharts/themes/fusioncharts.theme.fint.js"></script>
	<script type="text/javascript"
		src="resources/js/fusioncharts/themes/fusioncharts.theme.carbon.js"></script>
	<script type="text/javascript"
		src="resources/js/fusioncharts/themes/fusioncharts.theme.ocean.js"></script>
	<script type="text/javascript"
		src="resources/js/fusioncharts/themes/fusioncharts.theme.zune.js"></script>
	<script type="text/javascript"
		src="resources/js/fusioncharts/maps/fusioncharts.usa.js"></script>
	<script type="text/javascript"
		src="resources/js/fusioncharts/maps/fusioncharts.world.js"></script>
</body>
</html>
