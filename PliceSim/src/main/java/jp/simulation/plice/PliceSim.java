package jp.simulation.plice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PliceSim
 */
@WebServlet("/sim")
public class PliceSim extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PliceSim() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	   out.println("<html><body>");
	   out.println("<center><h2>選択した料金プランの計算結果</h2></center>");
	   
	   String planIn,telPlanIn,discountIn,setDisIn,payDisIn;
	   double plan,telPlan,discount,setDis,payDis,telFee;
	   planIn = request.getParameter("plan1");
	   plan = Double.parseDouble(planIn);
	   telPlanIn = request.getParameter("telPlan1");
	   telPlan = Double.parseDouble(telPlanIn);
	   discountIn = request.getParameter("discount1");
	   discount = Double.parseDouble(discountIn);
	   setDisIn = request.getParameter("setDis1");
	   setDis = Double.parseDouble(setDisIn);
	   payDisIn = request.getParameter("payDis1");
	   payDis = Double.parseDouble(payDisIn);
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

	
      out.println("<center><font size = +1>選択したプランの料金は税込み   </font><font size = +2><font color = red><b>" + Math.round(telFee) + "円   </b></font></font><font size = +1>です。</font></center>");
	   
	}

}
