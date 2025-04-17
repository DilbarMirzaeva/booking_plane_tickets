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
    public Booking update(Booking booking) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Booking getById(Long id) {
        return null;
    }
}
