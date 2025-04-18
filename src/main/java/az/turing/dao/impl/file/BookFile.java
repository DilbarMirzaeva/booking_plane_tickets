package az.turing.dao.impl.file;

import az.turing.dao.BookingDao;
import az.turing.model.Booking;
import az.turing.util.FileUtil;

import java.util.List;

public class BookFile extends BookingDao {
   private final FileUtil<Booking> bookingFileUtil;

    public BookFile(FileUtil<Booking> bookingFileUtil) {
        this.bookingFileUtil = bookingFileUtil;
    }

    @Override
    public List<Booking> getAll() {
        return bookingFileUtil.readFromFile();
    }

    @Override
    public Booking create(Booking booking) {
        List<Booking> list=bookingFileUtil.readFromFile();
        list.add(booking);
        bookingFileUtil.writeToFile(list);
        return booking;
    }

    @Override
    public void update(Booking booking) {
        List<Booking> list=bookingFileUtil.readFromFile();
        list.stream().filter(b->b.getId().equals(booking.getId()))
                .findFirst()
                .ifPresent(b->{
                    b.setFlightId(booking.getFlightId());
                    b.setPassengers(booking.getPassengers());
                    bookingFileUtil.writeToFile(list);
                });
    }

    @Override
    public void delete(Long id) {
        List<Booking> list=bookingFileUtil.readFromFile();
        list.removeIf(booking -> booking.getId().equals(id));
        bookingFileUtil.writeToFile(list);
    }

    @Override
    public Booking getById(Long id) {
        return bookingFileUtil.readFromFile().stream().filter(b->b.getId().equals(id)).findFirst().orElse(null);
    }
}
