package projectOrganization.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import projectOrganization.dto.TicketsDTO;
import projectOrganization.entity.Tickets;
import projectOrganization.repository.TicketsRepository;

import java.util.List;

@Service
public class TicketsService {
        @Autowired
        TicketsRepository ticketsRepository;

        public List<Tickets> getAllTickets() throws Exception {
            return (List<Tickets>) ticketsRepository.findAll();
        }

        public Tickets getTickets(Integer number_ticket) { return ticketsRepository.findById(number_ticket).get(); }

        public void addTickets(TicketsDTO request) {
            Tickets tickets = new Tickets();
            tickets.setNumber_ticket(request.getNumber_ticket());
            tickets.setId_user(request.getId_user());
            tickets.setNum_library(request.getNum_library());

            ticketsRepository.save(tickets);
        }

        public void deleteTickets(Integer number_ticket) {
            Tickets tickets = ticketsRepository.findById(number_ticket).get();
            ticketsRepository.delete(tickets);
        }

        public ResponseEntity<String> editTickets(@RequestBody TicketsDTO ticketsDTO) {
            try {
                if(!ticketsRepository.existsById(ticketsDTO.getNumber_ticket())) {
                    return ResponseEntity.badRequest().body("Читательского билета не существует");
                }

                Tickets tickets = new Tickets(ticketsDTO.getNumber_ticket(), ticketsDTO.getId_user(), ticketsDTO.getNum_library());
                ticketsRepository.save(tickets);

                return ResponseEntity.ok("Успех");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Ошибка");
            }
        }
    }







