package servlets;

import dao.HotelDAO;
import entities.Hotel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/hotel")
public class HotelServlet extends HttpServlet {

    @Inject
    private HotelDAO hotelDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        Hotel hotel = new Hotel();
//        hotel.setName("test");
//
//        hotelDAO.addHotel(hotel);

        List<Hotel> hotels = hotelDAO.getHotels();
        request.setAttribute("hotels", hotels);

        request.getRequestDispatcher("WEB-INF/hotel.jsp").forward(request, response);
    }


}