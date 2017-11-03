import java.io.* ;
import javax.servlet.* ;
import javax.servlet.http.* ;
import javax.servlet.annotation.WebServlet ;
import java.util.* ;

@WebServlet ("/IntegralSolution")
public class Solution extends HttpServlet {

	protected void doPost (HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
			HttpSession mySession = request.getSession();

			Object sessionStartTime = null;
			int correct = 0;
			int incorrect = 0;
			if (mySession.isNew()){
				mySession.setAttribute( "CORRECT", correct );
				mySession.setAttribute( "INCORRECT", incorrect );
			}
			else{
				correct = (int)mySession.getAttribute("CORRECT");
				incorrect = (int)mySession.getAttribute("INCORRECT");
			}
			int n = Integer.parseInt (request.getParameter("maximum"));
			int m = Integer.parseInt (request.getParameter("minimum"));
			int p = Integer.parseInt (request.getParameter("exponent"));
			int numerator = Integer.parseInt (request.getParameter("numerator"));
			int denominator = Integer.parseInt (request.getParameter("denominator"));

			response.setContentType ( "text/html" );
			PrintWriter out = response.getWriter() ;
			try {

				out.println ( "<!DOCTYPE html>" ) ;
				out.println ( "<html>" ) ;
				out.println ( "  <head> " ) ;
				out.println ( "    <meta charset = 'utf-8'>" ) ;
				out.println ( "    <title>Integral</title>" ) ;
				out.println("<script type='text/javascript' async src='https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.2/MathJax.js?config=TeX-MML-AM_CHTML'></script>");
				out.println("<style type='text/css'>");
				out.println("table {margin-left:auto; margin-right:auto; border: 1.5px solid black; padding-top: 10px; padding-bottom: 10px; padding-left: 10px; padding-right: 10px}");
				out.println("td {text-align: center; border: 1.5px solid black; padding-top: 10px; padding-bottom: 10px; padding-left: 10px; padding-right: 10px;}</style>");
				out.println ( "  </head>" ) ;
				out.println ( "  <body>" ) ;
				out.println ( "<hr>" ) ;
				out.println ( "<table>" ) ;
				//print out table headers
				out.println ( "	<tr>" ) ;
				out.println ( "	<td>\\(\\Huge{ \\int_{" +Integer.toString(m) + "}^{"+ Integer.toString(n) + "}x^{" + Integer.toString(p) +"}{dx}}\\) </td>" ) ;
				out.println ( "	</tr>" ) ;
				out.println ( " <tr>" );
				int exponent = p+1;
				int calculatedNumerator = (int)Math.pow(n,exponent) - (int)Math.pow(m, exponent);
				int calculatedDenominator = exponent;
				if ((numerator == calculatedNumerator) && (denominator == calculatedDenominator )){
					//right answer
					out.println ( "<td>Yes, \\( \\dfrac { " + Integer.toString(numerator) + "}{" + Integer.toString(denominator) + "} \\)  is correct.</td>" ) ;
					correct++;
				}
				else {
					//wrong answer
					out.println ( "<td>No, \\( \\dfrac {" + Integer.toString(numerator) + "}{" + Integer.toString(denominator) + "} \\) is not correct.</td>" ) ;
					incorrect++;
				}
				out.println ( " </tr>" );
				out.println ( " <tr>" );
				out.println ( "<td>You have " + Integer.toString(correct) + " correct, and " + Integer.toString(incorrect) + " incorrect so far.</td>" ) ;
				out.println ( "	</tr>" ) ;


				out.println ( "</table>" ) ;
				out.println ( "<hr>" ) ;

				out.println("<form action = 'IntegralProblem'>") ;
				out.println("	<input type='submit' value='Return to Homepage' style='margin-left: auto; margin-right: auto;'>");
				out.println("</form>");
				out.println("<hr>");

				out.println ( "  </body>" ) ;
				out.println ( "</html>" ) ;
				mySession.setAttribute( "CORRECT", correct );
				mySession.setAttribute( "INCORRECT", incorrect );

			} // end try block
			finally {
				out.close() ;
			} // end finally

	} //end doPost

	protected void doGet (HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {


		doPost (request, response) ;
	} //end doGet

} // end Integral class
