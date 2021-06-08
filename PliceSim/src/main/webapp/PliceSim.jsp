<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
	String value1 = request.getParameter("plan1");
	String value2 = request.getParameter("telPlan1");
	String value3 = request.getParameter("discount1");
	String value4 = request.getParameter("setDis1");
	String value5 = request.getParameter("payDis1");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>携帯のプランを計算するページ</title>
</head>
<body>
<h1>シミュレーションの結果</h1>
<h3>
<%
		double plan,telPlan,discount,setDis,payDis,telFee;
			plan = Double.parseDouble(value1);
			telPlan = Double.parseDouble(value2);
			discount = Double.parseDouble(value3);
			setDis = Double.parseDouble(value4);
			payDis = Double.parseDouble(value5);
			
			if(plan == 3150 && setDis == 1000){
				setDis -= 1000;
			}else if(plan == 4150 && setDis == 1000){
				setDis -= 500;
			}else{
				setDis -=0;
			}
			double tax = 1.1;
			
			telFee = (plan + telPlan - discount - setDis - payDis);
			telFee *= tax;

		
			out.println("あなたのケータイプランの料金は税込み" + Math.round(telFee) + "円です");
		

%></h3>


</body>
</html>