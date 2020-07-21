package com.example.demo;


import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController

public class SpringFlight{

    @GetMapping("/flights/flight")
    public Flight getflights() {
//        Flight.Passenger Scott = new Flight.Passenger("Scott", "Ze");
//        Flight.Ticket first = new Flight.Ticket(Scott, "150");
//        Flight flight = new Flight(first, new Date(1984,05,27));
            Flight flight = new Flight();


        return flight;
    }

    public static class Flight{
        private Date departs;
        private Ticket ticket;
        private List<Ticket> tickets;

        Flight(){

        }

        Flight(Ticket ticket, Date departs){
            this.ticket = ticket;
            this.departs = departs;
        }


        @JsonFormat(pattern = "yyyy-MM-dd")
        public Date getDeparts() { return departs; }
        public void setDeparts(Date dateTime) { this.departs = dateTime;}

        public List<Ticket> getTickets() { return tickets;}
        public void setTickets(List<Ticket> tickets) { this.tickets = tickets;}

        public Ticket getTicket(){return this.ticket;}


        static class Passenger {
            private final String firstname;
            private final String lastname;

            Passenger(String firstname, String lastname){
                this.firstname = firstname;
                this.lastname = lastname;
            }

            public String getFirstName() {return firstname; }
            public String getLastName(){ return lastname;}

        }

        static class Ticket{

                private final Passenger passenger;
            private final String price;

                Ticket(Passenger passenger, String price){
                    this.passenger = passenger;
                    this.price = price;
                }

            public Passenger getPassenger(){ return passenger;}
            public String getPrice() { return price; }

        }
        }
    }






