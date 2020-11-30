package com.hava.satistakip.repository;

import com.hava.satistakip.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket,Long> {
    @Query(value = "SELECT ID,TICKET_NUMBER,CARD_NUMBER,SALES_DATE,PRICE_TICKET,ACTIVE,IS_SALE,FLIGHT_ID,NAME,SURNAME,PHONE_NUMBER FROM TICKET WHERE TICKET_NUMBER LIKE %?%",nativeQuery = true)
    List<Ticket> search(String search);

    Ticket findByTicketNumber(String ticketNumber);

    @Query(value = "SELECT Count(*) FROM TICKET WHERE FLIGHT_ID =?",nativeQuery = true)
    Integer listTicketByFlifhtId(Long flightId);
}
