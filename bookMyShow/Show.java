package machineCoding.bookMyShow;

import java.util.Map;
import machineCoding.bookMyShow.seat.Seat;
import java.time.LocalDateTime;

public class Show {
    private final String id;
    private final Movie movie;
    private final Theater theater;
    private final LocalDateTime startTime;
    private final LocalDateTime endTIme;
    private final Map<String, Seat> seats;

    public Show(String id, Movie movie, Theater theater, LocalDateTime startTIme, LocalDateTime endTime, Map<String, Seat> seats) {
        this.id = id;
        this.movie = movie;
        this.theater = theater;
        this.startTime = startTIme;
        this.endTIme = endTime;
        this.seats = seats;
    }

    public String getId() {
        return this.id;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public Theater getTheater() {
        return this.theater;
    }

    public LocalDateTime getSDateTime() {
        return this.startTime;
    }

    public LocalDateTime getEndDatTime() {
        return this.endTIme;
    }

    public Map<String, Seat> getSeats() {
        return this.seats;
    }
}
