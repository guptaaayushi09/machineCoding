package machineCoding.bookMyShow;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import machineCoding.bookMyShow.seat.Seat;
import machineCoding.bookMyShow.seat.SeatStatus;
import machineCoding.bookMyShow.seat.SeatType;
import java.util.List;
import machineCoding.bookMyShow.booking.Booking;

public class BookMyShowDemo {
    public static void main(String[] args) {
        BookMyShowSystem system = BookMyShowSystem.getInstance();
        Movie Ludo = new Movie("1", "Ludo", "Mix of multiple stories", 180);
        Movie BeforeSunrise = new Movie("2", "Before Sunrise", "Romantic Calm Movies", 120);

        system.addMovies(BeforeSunrise);
        system.addMovies(Ludo);

        Theater Koramangala = new Theater("12", "PVR", "Koramangala", new ArrayList<>());
        Theater HSR = new Theater("133", "HSR_Nexus", "HSR", new ArrayList<>());
        system.addTheater(HSR);
        system.addTheater(Koramangala);

        Show show1 = new Show(
            "12",
            Ludo,
            HSR,
            LocalDateTime.now(),
            LocalDateTime.now().plusMinutes(Ludo.getDurationTimeInMinutes()),
            createSeats(10, 10)
        );
        Show show2 = new Show(
            "13",
            BeforeSunrise,
            Koramangala,
            LocalDateTime.now(),
            LocalDateTime.now().plusMinutes(BeforeSunrise.getDurationTimeInMinutes()),
            createSeats(8, 8)
        );
        system.addShow(show2);
        system.addShow(show1);

        User user = new User("U1", "Aayushi", "aayuhi0901@gmail.com");
        List<Seat> selectedSeat = Arrays.asList(
            show1.getSeats().get("1-5"),
            show1.getSeats().get("1-6")
        );

        Booking booking = system.bookTicket(user, show2, selectedSeat);

        if (booking != null) {
            System.out.println("Booking confirm");
            system.confirmBooking(booking.getId());
        } else {
            System.out.print("Ticket not booked ");
        }

        system.cancelBooking(booking.getId());
    }

    private static Map<String, Seat> createSeats(int r, int c) {
        Map<String, Seat> seats = new HashMap<>();
        for (int row = 1; row <= r; row++) {
            for (int col = 1; col <= c; col++) {
                String seatID = row + "-" + col;
                SeatType seatType = (row <= 2) ? SeatType.PREMIUM : SeatType.NORMAL;
                double price = (seatType == SeatType.PREMIUM) ? 150.0 : 100.0;
                Seat seat = new Seat(seatID, row, col, seatType, price, SeatStatus.AVAILABLE);
                seats.put(seatID, seat);
            }
        }
        return seats;
    }
}
