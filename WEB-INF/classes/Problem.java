import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;

@WebServlet("/Calculate")
public class Problem extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException{

    Random numberGen = new Random();
    int m = numberGen.nextInt(5);
    int n = numberGen.nextInt(5-m)+m;
    int p = numberGen.nextInt(4)+1;
    response.setContentType ("text/html");
    PrintWriter out = response.getWriter();
    try{
      out.println("<!DOCTYPE html><html><head><script type='text/javascript' async src='https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.2/MathJax.js?config=TeX-MML-AM_CHTML'></script>");
      out.println("<meta charset = 'utf-8'><title>Calculate</title></head><body>");
      out.println("\\(\\int_{" + Integer.toString(m) + "}^{" + Integer.toString(n) + "}x^{" + Integer.toString(p) + "}{dx}\\)");
      out.println("<form method='GET' action='Calculate'>");
      out.println("Numerator<input type='number' name='numererator'/>&nbsp;<br />");
      out.println("Denominator<input type='number' name='denominator'/>&nbsp;<br />");
      out.println("<input type='submit' value='Submit' />");
      out.println("</form>");
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
