angular.module('myApp', [])
.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/', {
        controller: 'HomeCtrl'
    })
    .when('/about',{
      templateUrl:'../../WEB-INF/views/about.html',
      controller:'aboutCtrl'
  })
            .otherwise({redirectTo: '/'});//default open page
        }])
.controller('HomeCtrl',['$scope','$location', '$anchorScroll',function($scope,$location,$anchorScroll){
}])
.controller('HelloCtrl', ['$scope','$http','$q',function($scope,$http,$q) {
  /*call API get datas in advance*/
	/*section one compare vector major*/
	$scope.test1 = {"type":"column2d",
			"chart":{"caption": "Compared by Vector Major",
	                 "subCaption": "",
	                 "xAxisName": "Major",
	                 "yAxisName": "Total",
	                 "theme": "fint",
	                 "yAxisMinValue":"700000000"}
		};//bar chart is default one
	$scope.test2 = {"type":"column2d",
			"chart":{"caption": "Compared by Vector Minor",
	                 "subCaption": "",
	                 "xAxisName": "Minor",
	                 "yAxisName": "Total",
	                 "canvasBgAlpha": "0",
	                 "bgColor": "#DDDDDD",
	                 "bgAlpha": "50",
	                 "theme": "fint"
	                	 }
		};//bar chart is default one
	$scope.getBar1 = function(){
		$http.get('compareVectorMajorService').//get compared by vector major
        success(function(data) {
            $scope.compareVectorMajor= data;
            var revenueChart = new FusionCharts({//sample column diagram
            	"type": $scope.test1.type,
                "renderAt": "chartContainer",//destinate element to show this chart
                "width": "500",
                "height": "400",
                "dataFormat": "json",
                "dataSource":  {
                  "chart": $scope.test1.chart,
                  "data": $scope.compareVectorMajor
            }
        });
            revenueChart.render();
        });
	};
	$scope.getBar2 = function(){
		$http.get('compareVectorMinorService').//get compared by vector major
        success(function(data) {
            $scope.compareVectorMinor= data;
            var revenueChart = new FusionCharts({//sample column diagram
            	"type": $scope.test2.type,
                "renderAt": "chartContainer2",//destinate element to show this chart
                "width": "500",
                "height": "400",
                "dataFormat": "json",
                "dataSource":  {
                  "chart": $scope.test2.chart,
                  "data": $scope.compareVectorMinor
            }
        });
            revenueChart.render();
        });
	};
	$scope.getBar1();
	$scope.getBar2();
	$scope.renderNow1 = function(){
		switch($scope.test1.type){
		case "column2d":
			$scope.test1.chart = {
				"caption": "Donation Count by Vector Major",
	            "subCaption": "BAR",
	            "xAxisName": "Vector Major",
	            "yAxisName": "Total",
	            "theme": "fint",
	            "yAxisMinValue":"700000000"
		       };
			break;
		case "doughnut2D":
			$scope.test1.chart = {
	            "caption": "Donation Count by Vector Major",
	            "subCaption": "PIE",
	            "numberPrefix": "",
	            "showBorder": "0",
	            "use3DLighting": "0",
	            "enableSmartLabels": "0",
	            "startingAngle": "310",
	            "showLabels": "0",
	            "showPercentValues": "1",
	            "showLegend": "1",
	            "defaultCenterLabel": "Total Donation: 1.7B",
	            "centerLabel": "Donation from $label: $value",
	            "centerLabelBold": "1",
	            "showTooltip": "0",
	            "decimals": "0",
	            "useDataPlotColorForLabels": "1",
	            "theme": "fint"
		}
		    break;
		}
        var revenueChart = new FusionCharts({//sample column diagram
        	"type": $scope.test1.type,
            "renderAt": "chartContainer",//destinate element to show this chart
            "width": "500",
            "height": "400",
            "dataFormat": "json",
            "dataSource":  {
              "chart": $scope.test1.chart,
               "data": $scope.compareVectorMajor
        }
    });
        revenueChart.render();
	};
	$scope.renderNow2 = function(){
		switch($scope.test2.type){
		case "column2d":
			$scope.test2.chart = {
				"caption": "Donation Count by Vector Minor",
	            "subCaption": "BAR",
	            "xAxisName": "Vector Minor",
	            "yAxisName": "Total",
                "canvasBgAlpha": "0",
                "bgColor": "#DDDDDD",
                "baseFontColor":"#000000",
                "bgAlpha": "50",
	            "theme": "fint"
	           // "yAxisMinValue":"700000000"            	
		       };
			break;
		case "doughnut2D":
			$scope.test2.chart = {
	            "caption": "Donation Count by Vector Minor",
	            "subCaption": "PIE",
	            "numberPrefix": "",
	            "showBorder": "0",
	            "use3DLighting": "0",
	            "enableSmartLabels": "0",
	            "startingAngle": "310",
	            "showLabels": "0",
	            "showPercentValues": "1",
	            "showLegend": "1",
	            "defaultCenterLabel": "Total Donation: ",
	            "centerLabel": "Donation from $label: $value",
	            "centerLabelBold": "1",
	            "showTooltip": "0",
	            "bgColor": "#dddddd",
	            "decimals": "0",
	            "useDataPlotColorForLabels": "1",
	            "theme": "fint"
		}
		    break;
		}
        var revenueChart = new FusionCharts({//sample column diagram
        	"type": $scope.test2.type,
            "renderAt": "chartContainer2",//destinate element to show this chart
            "width": "500",
            "height": "400",
            "dataFormat": "json",
            "dataSource":  {
              "chart": $scope.test2.chart,
               "data": $scope.compareVectorMinor
        }
    });
        revenueChart.render();
	};
	/*section one & two compare vector major & minor end*/
	$scope.getRecommendForm = function(){
		$http.get('listRecommService', {
		    params: { "projectId":$scope.projectId}
		}).success(function(data){
			$scope.recommendForm = data;
		});
	};
	$scope.projectId = 13;
    $scope.getRecommendForm();//default form is for project 13
    //trend section
    $scope.getTrend = function(){
    	if($scope.year!=="all"){//single year chart
    		var thisService = "year" + $scope.year +"Service";
        	$http.get(thisService).success(function(data){
        		$scope.thisServiceData = data;
        		$scope.thisServiceData.sort(function(a,b){return parseInt(a.label) - parseInt(b.label);});
        		var chart = new FusionCharts({
        			"type": "area2d",
                    "renderAt": "chartContainer3",//destinate element to show this chart
                    "width": "500",
                    "height": "400",
                    "dataFormat": "json",
                    "yAxisMinValue":400000,
                    "linethickness": "3",
                    "dataSource":  {
                      "chart": {
                        "caption": $scope.year +" Donation variation trend monthly",
                        "subCaption": "",
                        "xAxisName": "Minor",
                        "yAxisName": "Total",
                        "theme": "fint"
                    },
                    "dataset":[{
                      "renderAs": "line",
                      "data": $scope.thisServiceData
                  }] 
              }
        		});	
        		chart.render();	
        	});
    	}else{
    		$scope.year2009 = $http.get('year2009Service', {cache: false});
    		$scope.year2010 = $http.get('year2010Service', {cache: false});
    		$scope.year2011 = $http.get('year2011Service', {cache: false});

    		$q.all([$scope.year2009, $scope.year2010,$scope.year2011]).then(function(values) {
    		    $scope.year2009 = values[0].data;
    		    for(obj in $scope.year2009){
    		    	delete obj.label;
    		    }
    		    console.log($scope.year2009);
       		    $scope.year2010 = values[1].data;
       		    for(obj in $scope.year2010){
 		    	    delete obj.label;
 		        }
    		    $scope.year2011 = values[2].data;
    		    for(obj in $scope.year2011){
 		    	    delete obj.label;
 		        }
    		    var chart = new FusionCharts({
        			"type": "msline",
                    "renderAt": "chartContainer3",//destinate element to show this chart
                    "width": "500",
                    "height": "400",
                    "dataFormat": "json",
                    "yAxisMinValue":400000,
                    "linethickness": "3",
                    "dataSource":  {
                    	"chart": {
                            "caption": "Donation Trend Compared by Years",
                            "subcaption": "line chart",
                            "xaxisname": "Month",
                            "yaxisname": "Donation",
                            "palette": "3",
                            "bgcolor": "FFFFFF",
                            "canvasbgcolor": "66D6FF",
                            "canvasbgalpha": "5",
                            "canvasborderthickness": "1",
                            "canvasborderalpha": "20",
                            "legendshadow": "0",
                            "showvalues": "0",
                            "alternatehgridcolor": "ffffff",
                            "alternatehgridalpha": "100",
                            "showborder": "0",
                            "legendborderalpha": "0",
                            "legendiconscale": "1.5",
                            "divlineisdashed": "1"
                        },
                        "categories": [
                            {
                                "category": [
                                    {
                                        "label": "Jan"
                                    },
                                    {
                                        "label": "Feb"
                                    },
                                    {
                                        "label": "Mar"
                                    },
                                    {
                                        "label": "Apr"
                                    },
                                    {
                                        "label": "May"
                                    },
                                    {
                                        "label": "Jun"
                                    },
                                    {
                                        "label": "Jul"
                                    },
                                    {
                                        "label": "Aug"
                                    },
                                    {
                                        "label": "Sep"
                                    },
                                    {
                                        "label": "Oct"
                                    },
                                    {
                                        "label": "Nov"
                                    },
                                    {
                                        "label": "Dec"
                                    }
                                ]
                            }
                        ],
                        "dataset": [
                            {
                                "seriesname": "Year 2009",
                                "color": "F97D10",
                                "data":$scope.year2009
                            },
                            {
                                "seriesname": "Year 2010",
                                "data": $scope.year2010
                            },
                            {
                                "seriesname": "Year 2011",
                                "color": "3994F9",
                                "data": $scope.year2011
                            }
                        ],
                        "styles": {
                            "definition": [
                                {
                                    "name": "captionFont",
                                    "type": "font",
                                    "size": "15"
                                }
                            ],
                            "application": [
                                {
                                    "toobject": "caption",
                                    "styles": "captionfont"
                                }
                            ]
                        }
              }
        		});	
        		chart.render();	
    		});
    	}
    	
    	//chart.render();
    };
    $scope.year = 2009;
    $scope.getTrend();//default display 2009 trend

$http.get('prospectCountTopService').
success(function(data) {
    $scope.propspectCountTop= data;
    $scope.propspectCountTop.sort(function(a,b) { return parseInt(b.value) - parseInt(a.value); } );
    var revenueChart = new FusionCharts({//sample column diagram
    	"type": "bar3d",
        "renderAt": "chart-container",//destinate element to show this chart
        "width": "500",
        "height": "500",
        "dataFormat": "json",
        /*"yAxisMinValue":400000,*/
        "linethickness": "3",
        "dataSource":  {
          "chart": {
        	  "caption": "Donation Count Top 10",
              "subCaption": "Bar Chart",
              "xAxisName": "Prospect ID",
              "yAxisName": "Donation",
              "numberPrefix": "",
              "canvasBgAlpha": "0",
              "bgColor": "#DDDDDD",
              "bgAlpha": "50",
              "theme": "fint"
        },
        "dataset":[{
          "renderAs": "line",
          "data": $scope.propspectCountTop
      }] 
  }
});
    revenueChart.render();  
});
//$http.get('ZipCountService').success(function(data) {
//    $scope.zipCount= data;
//    console.log($scope.zipCount);
//});
var salesMap = new FusionCharts({
    type: 'usa',
    renderAt: 'mapContainer',
    width: '600',
    height: '400',
    dataFormat: 'json',
    dataSource: {
        "chart": {
            "caption": "Donation Count by States in USA",
            "subcaption": "Year 2009-2011 ", 
            "showLabels": "1",                      
            "numberScaleValue": "1,1000,1000",
            "numberScaleUnit": "K,M,B",
            "numberPrefix": "",
            "entityFillHoverColor": "#d35400",
            "entityFillHoverAlpha": "30",
            "canvasBgAlpha": "0",
            "bgColor": "#DDDDDD",
            "bgAlpha": "50",
            "theme" : "fint"
        },
        "colorrange": {
            "gradient": "1",
            "startLabel": "Low",
            "endLabel": "High",
            "code": "#f39c12",
            "minvalue": "920000",
            "maxValue": "102828000" 
        },
        "data": [
            {
                "id": "HI",
                "value": "3189000"
            },
            {
                "id": "DC",
                "value": "8879000"
            },
            {
                "id": "MD",
                "value": "93592000"
            },
            {
                "id": "DE",
                "value": "4607000"
            },
            {
                "id": "RI",
                "value": "4890000"
            },
            {
                "id": "WA",
                "value": "34927000"
            },
            {
                "id": "OR",
                "value": "65798000"
            },
            {
                "id": "CA",
                "value": "77400000"
            },
            {
                "id": "AK",
                "value": "58911000"
            },
            {
                "id": "ID",
                "value": "42662000"
            },
            {
                "id": "NV",
                "value": "78041000"
            },
            {
                "id": "AZ",
                "value": "41558000"
            },
            {
                "id": "MT",
                "value": "62942000"
            },
            {
                "id": "WY",
                "value": "78834000"
            },
            {
                "id": "UT",
                "value": "50512000"
            },
            {
                "id": "CO",
                "value": "73026000"
            },
            {
                "id": "NM",
                "value": "78865000"
            },
            {
                "id": "ND",
                "value": "50554000"
            },
            {
                "id": "SD",
                "value": "35922000"
            },
            {
                "id": "NE",
                "value": "43736000"
            },
            {
                "id": "KS",
                "value": "32681000"
            },
            {
                "id": "OK",
                "value": "79038000"
            },
            {
                "id": "TX",
                 "value": "97344000"
            },
            {
                "id": "MN",
                "value": "43485000"
            },
            {
                "id": "IA",
                "value": "46515000"
            },
            {
                "id": "MO",
                "value": "63715000"
            },
            {
                "id": "AR",
                "value": "34497000"
            },
            {
                "id": "LA",
                "value": "70706000"
            },
            {
                "id": "WI",
                "value": "42382000"
            },
            {
                "id": "IL",
                "value": "73202000" 
            },
            {
                "id": "KY",
                "value": "79118000"
            },
            {
                "id": "TN",
                "value": "44657000"
            },
            {
                "id": "MS",
                "value": "66205000"
            },
            {
                "id": "AL",
                "value": "75873000"
            },
            {
                "id": "GA",
                "value": "76895000"
            },
            {
                "id": "MI",
                "value": "67695000"
            },
            {
                "id": "IN",
                "value": "920000"
            },
            {
                "id": "OH",
                "value": "32960000"
            },
            {
                "id": "PA",
                "value": "84346000"
            },
            {
                "id": "NY",
                "value": "102828000"
            },
            {
                "id": "VT",
                "value": "77411000"
            },
            {
                "id": "NH",
                "value": "41403000"
            },
            {
                "id": "ME",
                "value": "64636000"
            },
            {
                "id": "MA",
                "value": "91767000"
            },
            {
                "id": "CT",
                "value": "57353000"
            },
            {
                "id": "NJ",
                "value": "97344000"
            },
            {
                "id": "WV",
                "value": "75890000"
            },
            {
                "id": "VA",
                "value": "83140000"
            },
            {
                "id": "NC",
                "value": "75425000"
            },
            {
                "id": "SC",
                "value": "88234000"
            },
            {
                "id": "FL",
                "value": "68234000"
            }
        ]
    }
});
salesMap.render();
}]);