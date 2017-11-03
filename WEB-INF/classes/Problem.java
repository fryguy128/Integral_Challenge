import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;

@WebServlet("/IntegralProblem")
public class Problem extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException{

    Random numberGen = new Random();
    int m = numberGen.nextInt(6);
    int n = numberGen.nextInt(6-m)+m;
    int p = numberGen.nextInt(5)+1;
    response.setContentType ("text/html");
    PrintWriter out = response.getWriter();
    try{
      out.println("<!DOCTYPE html><html><head><script type='text/javascript' async src='https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.2/MathJax.js?config=TeX-MML-AM_CHTML'></script>");
      out.println("<style type='text/css'>");
      out.println("table {margin-left:auto; margin-right:auto; border: 1.5px solid black; padding-top: 10px; padding-bottom: 10px; padding-left: 10px; padding-right: 10px}");
      out.println("td {text-align: center; border: 1.5px solid black; padding-top: 10px; padding-bottom: 10px; padding-left: 10px; padding-right: 10px;}</style>");
      out.println("<meta charset = 'utf-8'><title>Integral Problem</title></head><body>");
      out.println("<HR />");
      out.println("<table>");
      out.println("<tr><td colspan='2'>\\(\\Huge{\\int_{" + Integer.toString(m) + "}^{" + Integer.toString(n) + "}x^{" + Integer.toString(p) + "}{dx}}\\)</td></tr>");
      out.println("<form method='GET' action='IntegralSolution'>");
      out.println("<tr><td>Numerator</td><td><input type='number' name='numerator'/></td></tr>");
      out.println("<tr><td>Denominator</td><td><input type='number' name='denominator'/></td></tr>");
      out.println("<input type='hidden' name='exponent' value='" + Integer.toString(p) + "'>");
      out.println("<input type='hidden' name='minimum' value='" + Integer.toString(m) + "'>");
      out.println("<input type='hidden' name='maximum' value='" + Integer.toString(n) + "'>");
      out.println("<tr><td colspan='2'><input type='submit' value='Submit' style='width: 80%' /></td></tr>");
      out.println("</form>");
      out.println("</table>");
      out.println("<HR />");
      out.println("</body></html>");
    }
      finally{
        out.close();
      }
  } //End of doPost method


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException{
      doPost(request, response);
    } //End of doGet method
} //End of TestServlet class
