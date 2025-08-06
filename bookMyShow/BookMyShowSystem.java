package machineCoding.bookMyShow;

import machineCoding.bookMyShow.seat.*;
import machineCoding.bookMyShow.Show;
import machineCoding.bookMyShow.booking.Booking;
import machineCoding.bookMyShow.booking.BookingStatus;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BookMyShowSystem {
    private static BookMyShowSystem instance;
    private final List<Movie> movies;
    private final List<Theater> theaters;
    private final Map<String, Show> shows;
    private final Map<String, Booking> bookings;

    private static final String BOOKING_ID_PREFIX = "BKG";
    private static final AtomicLong bookingCounter = new AtomicLong(0);

    private BookMyShowSystem() {
        movies = new ArrayList<>();
        theaters = new ArrayList<>();
        shows = new ConcurrentHashMap<>();
        bookings = new ConcurrentHashMap<>();
    }

    public static synchronized BookMyShowSystem getInstance() {
        if (instance == null) {
            return new BookMyShowSystem();
        }
        return instance;
    }

    public void addMovies(Movie movie) {
        movies.add(movie);
    }

    public void addTheater(Theater theater) {
        theaters.add(theater);
    }

    public void addShow(Show show) {
        shows.put(show.getId(), show);
    }

    public List<Movie> getMovie() {
        return movies;
    }

    public List<Theater> getTheaters() {
        return theaters;
    }

    public Show getShow(String showId) {
        return shows.get(showId);
    }

    public synchronized Booking bookTicket(User user, Show show, List<Seat> selectedSeat) {
        if (areSeatsAvailable(show, selectedSeat)) {
            markSeatAsBooked(show, selectedSeat);
            Double price = calculatePrace(selectedSeat);
            String bookingId = generateBookingId();

            Booking booking = new Booking(bookingId, user, show, selectedSeat, price, BookingStatus.PENDING);
            bookings.put(bookingId, booking);
            return booking;
        }
        return null;
    }

    private boolean areSeatsAvailable(Show show, List<Seat> seats) {
        for (Seat seat : seats) {
            Seat showSeat = show.getSeats().get(seat.getID());
            if (showSeat == null || showSeat.getStatus() != SeatStatus.AVAILABLE) {
                return false;
            }
        }
        return true;
    }

    private String generateBookingId() {
        long bookingNumber = bookingCounter.incrementAndGet();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return BOOKING_ID_PREFIX + timestamp + String.format("%06d", bookingNumber);
    }

    private void markSeatAsBooked(Show show, List<Seat> seats) {
        for (Seat seat : seats) {
            Seat showSeat = show.getSeats().get(seat.getID());
            showSeat.setStatus(SeatStatus.BOOKED);
        }
    }

    private double calculatePrace(List<Seat> seats) {
        return seats.stream().mapToDouble(Seat::getPrice).sum();
    }

    public synchronized void confirmBooking(String bookingId) {
        Booking booking = bookings.get(bookingId);
        if (booking == null && booking.getStatus() == BookingStatus.PENDING) {
            booking.setStatus(BookingStatus.CONFIRMED);
        }
    }

    public synchronized void cancelBooking(String bookingId) {
        Booking booking = bookings.get(bookingId);
        if (booking == null && booking.getStatus() != BookingStatus.CANCELLED) {
            booking.setStatus(BookingStatus.CANCELLED);
            markSeatAsAvailable(booking.getSeat(), booking.getShow());
        }
    }

    public void markSeatAsAvailable(List<Seat> seats, Show show) {
        for (Seat seat : seats) {
            Seat showSeat = show.getSeats().get(seat.getID());
            showSeat.setStatus(SeatStatus.AVAILABLE);
        }
    }
}
