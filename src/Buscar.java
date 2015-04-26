

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zubiri.parking.ParkingVehiculos;
import com.zubiri.parking.Vehiculo;

/**
 * Servlet implementation class Buscar
 */
public class Buscar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buscar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String matri = request.getParameter("matricula");
		Vehiculo vehiculo = ParkingVehiculos.buscarVehiculo(matri);
		out.println("<link rel='StyleSheet' href='css/styles.css' type='text/css'>");
		
		if (vehiculo == null) {
			out.println("<html>");
			out.println("<head><title>Resultado búsqueda</title></head>");
			out.println("<body style='text-align:center'>");
			out.println("<h1>Lista</h1>");
			out.println("<h1 style='color:red'>El Vehículo con matrícula " + matri + " No Existe</h1>");
			out.println("<br><br><a href='buscar.html'>Volver</a>");
			out.println("</body>");
			out.println("</html>");
		}else{
		
		out.println("<html>");
		out.println("<head><title>Resultado búsqueda</title></head>");
		
		out.println("<body>");
		out.println("<h1>Resultado de búsqueda</h1>");
		out.println("<p>" + vehiculo.formatted() + "</p>");
		out.println("</body>");
		out.println("</html>");
		}
	}

}
