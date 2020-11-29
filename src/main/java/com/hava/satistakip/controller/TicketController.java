package com.hava.satistakip.controller;

import com.hava.satistakip.model.Ticket;
import com.hava.satistakip.repository.ITicketRepository;
import jdk.nashorn.internal.runtime.regexp.RegExp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("ticket")
public class TicketController {
    @Autowired
    private ITicketRepository ticketRepository;

    @RequestMapping("/saveOrUpdate")
    public Ticket saveorUpdateAirport(@RequestBody Ticket ticket) {
        ticket.setCardNumber(toMaskedString(ticket.getCardNumber()));
        return ticketRepository.save(ticket);
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

//    @RequestMapping("/findAll")
//    public List<Ticket> findAll(@RequestParam String search) {
//        return ticketRepository.search(search);
//    }
}
