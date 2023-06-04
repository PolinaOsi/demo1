package projectOrganization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projectOrganization.dto.TicketsDTO;
import projectOrganization.models.TicketsModel;
import projectOrganization.services.TicketsService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/tickets")
public class TicketsController {
        @Autowired
        private TicketsService ticketsService;

        @GetMapping("/all")
        public ResponseEntity<?> getAllTickets() {
            try {
                List<TicketsModel> ticketsModelList = new ArrayList<>();
                ticketsService.getAllTickets().forEach(tickets -> ticketsModelList.add(TicketsModel.toModel(tickets)));
                return ResponseEntity.ok(ticketsModelList);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @GetMapping("/{number_ticket}")
        public ResponseEntity<?> getTickets (@PathVariable Integer number_ticket) {
            try {
                return ResponseEntity.ok(ticketsService.getTickets(number_ticket));
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @DeleteMapping("/{number_ticket}")
        public ResponseEntity<?> deleteTickets(@PathVariable Integer number_ticket) {
            try {
                ticketsService.deleteTickets(number_ticket);
                return ResponseEntity.ok("Читательский билет удален");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/add")
        public ResponseEntity<?> addTickets (@RequestBody TicketsDTO request) {
            try {
                ticketsService.addTickets(request);
                return ResponseEntity.ok("Читательский билет добавлен");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/edit")
        public ResponseEntity<?> editTickets (@RequestBody TicketsDTO request) {
            try {
                ticketsService.editTickets(request);
                return ResponseEntity.ok("Читательский билет изменен");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
    }



