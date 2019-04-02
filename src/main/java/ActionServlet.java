import dao.HotelBean;
import entities.Hotel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hotel/*")
public class ActionServlet extends HttpServlet {
    private static final long serialVersionUID = -5832176047021911038L;

    @Inject
    private HotelBean hotelBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Hotel hotel = new Hotel();
        hotel.setName("test");

        hotelBean.addHotel(hotel);

        request.getRequestDispatcher("WEB-INF/hotel.jsp").forward(request, response);
    }
}