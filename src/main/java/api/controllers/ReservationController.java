package api.controllers;

import api.dto.HotelDTO;
import dao.HotelDAO;
import entities.Hotel;
import interceptors.MyInterceptor;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/hotel")
public class ReservationController {

    @Inject
    @Setter
    @Getter
    private HotelDAO hotelDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @MyInterceptor
    public Response get(@PathParam("id") final Long id) {
        Hotel hotel = hotelDAO.findHotel(id);
        if (hotel == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        HotelDTO hotelDTO = new HotelDTO();

        hotelDTO.setName(hotel.getName());
        hotelDTO.setStreetAddress(hotel.getStreetAddress());

        return Response.ok(hotelDTO).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @MyInterceptor
    @Transactional
    public Response put(
            @PathParam("id") final Long id,
            HotelDTO hotelDTO) {
        try {
            Hotel hotel = hotelDAO.findHotel(id);
            if (hotel == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            hotel.setName(hotelDTO.getName());
            hotel.setStreetAddress(hotelDTO.getStreetAddress());

            hotelDAO.updateHotel(hotel);

            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @MyInterceptor
    @Transactional
    public Response post(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();

        hotel.setName(hotelDTO.getName());
        hotel.setStreetAddress(hotelDTO.getStreetAddress());

        hotelDAO.addHotel(hotel);

        return Response.ok().build();
    }
}