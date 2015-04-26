

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zubiri.parking.ParkingVehiculos;

/**
 * Servlet implementation class CreaCoche
 */
public class CreaCoche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaCoche() {
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
		
		boolean auto = false;
		int consumo = 0;
		int numPinones = 0;
		
		String tipoVehiculo = "Coche";
		int numRuedas = Integer.parseInt(request.getParameter("numRuedas").trim());
		boolean motor = Boolean.valueOf(request.getParameter("motor"));
		String marca = request.getParameter("marca");
		if (request.getParameter("auto") != ""){
			auto = Boolean.valueOf(request.getParameter("auto"));
		}
		if (request.getParameter("consumo") != ""){
		consumo = Integer.parseInt(request.getParameter("consumo").trim());
		}
		String matricula = request.getParameter("matricula");
		String color = request.getParameter("color");
		String codBarras = request.getParameter("codBarras");
		if (request.getParameter("numPinones") != null){
		numPinones = Integer.parseInt(request.getParameter("numPinones").trim());
		}
		String tipoBici = request.getParameter("tipo");
		
		ParkingVehiculos.addVehiculo(tipoVehiculo, numRuedas, motor, marca, auto, consumo, matricula, color, codBarras, numPinones, tipoBici);
		
		response.sendRedirect("index.html");
	}

}
