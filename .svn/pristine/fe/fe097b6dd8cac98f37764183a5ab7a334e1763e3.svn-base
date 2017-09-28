<html ng-app="bankOperationsModule">
<head>
<!-- <script type="text/javascript" src="public/js/angular.js"></script>
 -->
 
 <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular.js"></script>
 <script type="text/javascript">
 var app=angular.module("bankOperationsModule",[]);
   app.controller("bankOperationsController",
	function($scope,$window,$http){
	   $scope.depositWindowFlag=false;
	   $scope.accountFoundFlag=false;
	   $scope.accNumberButtonFlag=true;
	   $scope.chequeeWindowFlag=false;
	   $scope.ddWindowFlag=false;
	   $scope.showDepositWindow=function(){
	   
	  $http({
	  method:"get",
	  url:"/CBA/deposit",
	  }).then(function(result){
		  $scope.accountNumber="";
		  $scope.depositWindowFlag=true;
		  $scope.accountFoundFlag=false;
		   $scope.accNumberButtonFlag=true;
		   $scope.chequeeWindowFlag=false;
		   $scope.ddWindowFlag=false;
		   $scope.depositAmtFlag=false;
	  },function(result){
		  $window.alert("Unable to process your request!Please Try Again");  
	  });  
	   } 
	   
	  $scope.checkAccountStatus=function(){
		  $http({
			method:"get",
			url:"checkAccountStatus",
			params:{
			"accountNumber":$scope.accountNumber	
			}
		  }).then(function(result){
		$scope.response=angular.fromJson(result.data);
		$scope.accountFoundFlag=true;
		if($scope.response.status=="SUCCESS"){
			$scope.message=$scope.response.message;	
		$scope.accountStatusInfo=angular.fromJson($scope.response.data);
      if($scope.accountStatusInfo.accountStatus=="ACTIVE"){
    	  $scope.depositAmtFlag=true;
    	  $scope.accNumberButtonFlag=false;
      }else{
    	 $scope.message=$scope.accountStatusInfo.accountNumber+" is "+$scope.accountStatusInfo.accountStatus;
      }
		}else{
		$scope.message=$scope.response.message;	
		}
		  },function(result){
			  $window.alert("Unable to process your request!please try again.");
		  }); 
	   }
	  
	  $scope.cash=function(){
		  $scope.txMode="cash";
		  
		  $scope.chequeeWindowFlag=false;
		  $scope.ddWindowFlag=false;
	  }
	  $scope.chequee=function(){
		  $scope.txMode="chequee";
		  $scope.chequeeWindowFlag=true;
		  $scope.ddWindowFlag=false;
	  }
	  $scope.dd=function(){
		  $scope.txMode="dd";
		  $scope.ddWindowFlag=true;
		  $scope.chequeeWindowFlag=false;
	  }
	  $scope.deposit=function(){
		  $scope.ddORChequeeNumber="";
		  $scope.issuedBy="";
		  $scope.issuedDate="";
	   if($scope.txMode=="chequee" || $scope.txMode=="dd"){
		   $scope.ddORChequeeNumber=$scope.number;
		   $scope.issuedBy=$scope.issuedBy;
		   $scope.issuedDate=$scope.issuedDate;
	   }
	   $http({
		   method:"post",
		   url:"/CBA/deposit",
		   params:{
			   "accountNumber":$scope.accountNumber,
			   "txAmount":$scope.amount,
			   "txMode":$scope.txMode,
			   "ddOrChequeeNumber":$scope.ddOrChequeeNumber,
			   "issuedBy":$scope.issuedBy,
			   "issuedDate":$scope.issuedDate
		   }
	   }).then(function(result){},function(result){});
	  }
   });
</script>
</head>
<body ng-controller="bankOperationsController">
<div >
<button type="button" ng-click="showDepositWindow()">Deposit</button>
</div>
<div ng-show="depositWindowFlag">
  <label>Deposit Window</label>
  <table border="1">
  <tr ng-show="accountFoundFlag">
 <td colspan="3" align="center"> {{message}}</td>
  </tr>
  <tr>
  <td><label>Enter Account Number : </label>
  <input type="text" ng-model="accountNumber"/></td>
  <td ng-show="accNumberButtonFlag"><button ng-click="checkAccountStatus()">Click</button></td>
  </tr>
  <tr ng-show="depositAmtFlag">
  <td><label>Select Transaction Mode : </label>
 <input type="radio" ng-click="cash()" value="cash" ng-model="txMode">CASH</input>
 
 <input type="radio" ng-click="chequee()" value="chequee"  ng-model="txMode">CHEQUEE</input>
<input type="radio" ng-click="dd()"  value="dd"  ng-model="txMode">DD</input></td>
  </tr>
  <tr ng-show="depositAmtFlag">
  <td><label>Enter Deposit Amount : </label>
 <input type="text" ng-model="amount"/></td>
  </tr>
  <tr ng-show="chequeeWindowFlag">
  <td>Enter Chequee Number : <input type="text" ng-model="number"/><br/>
  Enter Chequee Issued Date : <input type="text" ng-model="issuedDate"/><br/>
  Enter Issued By  : <input type="text" ng-model="issuedBy"/><br/>
  </td>
  </tr>
  <tr ng-show="ddWindowFlag">
  <td>Enter DD Number : 
  <input type="text" ng-model="number"/><br/>
  
  Enter DD Issued Date : 
  <input type="text" ng-model="issuedDate"/><br/>
 Enter DD By  : 
  <input type="text" ng-model="issuedBy"/><br/>
  </td>
  </tr>
  <tr ng-show="depositAmtFlag">
  <td><button ng-click="deposit()">Deposit</button></td>
</tr>
  </table>
</div>
</body>
</html>


