package com.hava.satistakip.controller;

import com.hava.satistakip.model.Flight;
import com.hava.satistakip.model.Ticket;
import com.hava.satistakip.repository.IFlightRepository;
import com.hava.satistakip.repository.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;


@RestController
@RequestMapping("ticket")
public class TicketController {
    static int ix = 0;
    @Autowired
    private ITicketRepository ticketRepository;

    @Autowired
    private IFlightRepository flightRepository;

    @RequestMapping("/saveOrUpdate")
    public Ticket saveorUpdateAirport(@RequestBody Ticket ticket) {
        ticket.setCardNumber(toMaskedString(ticket.getCardNumber()));
        ticket.setTicketNumber(createTicketNumber());
        Flight flight = flightRepository.findByIdFlight(ticket.getFlight().getId());
        ticket.setFlight(flight);
        try {
            CalculateTicket(ticket);
            return ticketRepository.save(ticket);
        }catch (Exception e){
            return null; //the quota is full or wrong flight
        }
    }

    @RequestMapping("/findAll")
    public List<Ticket> findAll(@RequestParam String search) {
        return ticketRepository.search(search);
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String ticketNumber) {
        Ticket ticket = ticketRepository.findByTicketNumber(ticketNumber);
        String returnValue = "";
        try {
            ticketRepository.delete(ticket);
            returnValue = "Ticket cancellation has been successfully completed";
        }catch (Exception e){
            returnValue = "An error occurred during ticket cancellation. Please contact us!";
        }
        return returnValue;
    }

    public void CalculateTicket(Ticket ticket){
        Integer countTicket = ticketRepository.listTicketByFlifhtId(ticket.getFlight().getId());
        Integer quote = ticket.getFlight().getQuota();
        int percent= countTicket*100/quote;
        if(percent == 0){
            return;
        }
        //Kontenjan %10 dolduğunda bilet fiyatı %10 artacak
        if(percent % 10 == 0){
            Flight flight = flightRepository.findByIdFlight(ticket.getFlight().getId());
            Double newPrice = flight.getPrice() + flight.getPrice()*0.1;
            flight.setPrice(newPrice);
            flightRepository.save(flight);
        }
    }

    public String toMaskedString(String value){
        String[] rStr = new String[]{"-",","};
        for (String r: rStr) {
            value = value.replaceAll(r,"");
        }
        char[] c = value.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if(i>5 && i<12){
                c[i] = '*';
            }
        }
        value = new String(c);
        return value;
    }

    public String createTicketNumber(){
        String key = "TICKET NO"+ (Math.random()*10)*(ix++);
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] array = digest.digest(key.getBytes());
            StringBuffer buffer = new StringBuffer();
            for (int i=0;i < array.length ; i++){
                buffer.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
