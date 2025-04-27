package az.turing.service.impl;

import az.turing.dao.impl.inter.BookingDao;
import az.turing.dto.BookingDto;
import az.turing.dto.PassengerDto;
import az.turing.exception.AlreadyExistException;
import az.turing.mapper.BookingMapper;
import az.turing.model.Booking;
import az.turing.service.BookingService;

import java.util.List;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {
    private final BookingDao bookingDao;
    private final BookingMapper bookingMapper;

    public BookingServiceImpl(BookingDao bookingDao, BookingMapper bookingMapper) {
        this.bookingDao = bookingDao;
        this.bookingMapper = bookingMapper;
    }

    public List<BookingDto> getAll(){
        return bookingDao.getAll().stream()
                .map(bookingMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public BookingDto create(BookingDto entity) {
        if(bookingDao.existsByFlightId(entity.getFlightId())){
            throw new AlreadyExistException("Flight already exists!");
        }
        Booking booking= bookingDao.create(bookingMapper.toEntity(entity));
        return entity;
    }

    @Override
    public void update(BookingDto entity) {
        bookingDao.update(bookingMapper.toEntity(entity));
    }

    @Override
    public void delete(long id) {
        bookingDao.delete(id);
    }

    @Override
    public BookingDto getById(long id) {
        Booking booking= bookingDao.getById(id);
        return bookingMapper.toDto(booking);
    }
}
