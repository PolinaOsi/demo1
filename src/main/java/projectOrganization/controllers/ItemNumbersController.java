package projectOrganization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projectOrganization.dto.*;
import projectOrganization.models.ItemNumberModel;
import projectOrganization.services.ItemNumbersService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/itemNumbers")

public class ItemNumbersController {
        @Autowired
        ItemNumbersService itemNumbersService;

        @GetMapping("/all")
        public ResponseEntity<?> getAllItemNumbers() {
            try {
                List<ItemNumberModel> itemNumberModelList = new ArrayList<>();
                itemNumbersService.getAllItemNumbers().forEach(itemNumbers -> itemNumberModelList.add(ItemNumberModel.toModel(itemNumbers)));
                return ResponseEntity.ok(itemNumberModelList);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @GetMapping("/{number}")
        public ResponseEntity<?>  getItemNumbers (@PathVariable Integer number) {
            try {
                return ResponseEntity.ok(itemNumbersService.getItemNumbers(number));
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @DeleteMapping("/{number}")
        public ResponseEntity<?>  deleteItemNumbers(@PathVariable Integer number) {
            try {
                itemNumbersService.deleteItemNumbers(number);
                return ResponseEntity.ok("Номенклатурный номер удален");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/add")
        public ResponseEntity<?>  addItemNumbers(@RequestBody ItemNumbersDTO request ) {
            try {
                itemNumbersService.addItemNumbers(request);
                return ResponseEntity.ok("Номенклатурный номер добавлен");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/edit")
        public ResponseEntity<?>  editItemNumbers(@RequestBody ItemNumbersDTO request) {
            try {
                itemNumbersService.editItemNumbers(request);
                return ResponseEntity.ok("Номенклатурный номер изменен");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

    }
