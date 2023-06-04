package projectOrganization.entity;

import lombok.Getter;
import lombok.Setter;
import projectOrganization.keys.LendingId;

import javax.persistence.*;
import java.util.Date;
@Entity
@Setter
@Getter
@IdClass(LendingId.class)
@Table(name = "Выдача")
public class Lending {

        @Id
        @Column(name = "Номенклатурный_номер_издания")
        private Integer item_number_publication;

        @Id
        @Column(name = "\"№_читательского_билета\"")
        private Integer num_ticket;

        @Column(name = "Дата_выдачи")
        private Date issue_date;

        @Column(name = "Срок_возврата")
        private Date return_period;

        @Column(name = "Дата_возврата")
        private Date return_date;
        @Id
        @Column(name = "\"№_сотрудника\"")
        private Integer num_employee;

//        @ManyToMany
//        @JoinTable(name = "empl_lend",
//                joinColumns = @JoinColumn (name = "num_employee"),
//                inverseJoinColumns = @JoinColumn (name = "id_employee"))
//        private List<Employees> employees;
//
//        @ManyToMany
//        @JoinTable(name = "num_lend",
//                joinColumns = @JoinColumn (name = "number"),
//                inverseJoinColumns = @JoinColumn (name = "item_number_publication"))
//        private List<ItemNumbers> itemNumbers;

//        @ManyToMany
//        @JoinTable(name = "ticket_lend",
//                joinColumns = @JoinColumn (name = "number_ticket"),
//                inverseJoinColumns = @JoinColumn (name = "num_ticket"))
//        private List<Tickets> tickets;

        public Lending(Integer item_number_publication, Integer num_ticket, Date issue_date, Date return_period, Date return_date, Integer num_employee) {
            this.item_number_publication = item_number_publication;
            this.num_ticket = num_ticket;
            this.issue_date = issue_date;
            this.return_period = return_period;
            this.return_date = return_date;
            this.num_employee = num_employee;
        }

        public Lending() { }

    public Integer getItem_number_publication() { return item_number_publication; }

    public void setItem_number_publication(Integer item_number_publication) { this.item_number_publication = item_number_publication; }

    public Integer getNum_ticket() { return num_ticket; }

    public void setNum_ticket(Integer num_ticket) { this.num_ticket = num_ticket; }

    public Date getIssue_date() { return issue_date; }

    public void setIssue_date(Date issue_date) { this.issue_date = issue_date; }

    public Date getReturn_period() { return return_period; }

    public void setReturn_period(Date return_period) { this.return_period = return_period; }

    public Date getReturn_date() { return return_date; }

    public void setReturn_date(Date return_date) { this.return_date = return_date; }

    public Integer getNum_employee() { return num_employee; }

    public void setNum_employee(Integer num_employee) { this.num_employee = num_employee; }

//    public List<Employees> getEmployees() { return employees; }
//
//    public void setEmployees(List<Employees> employees) { this.employees = employees; }
//
//    public List<ItemNumbers> getItemNumbers() { return itemNumbers; }
//
//    public void setItemNumbers(List<ItemNumbers> itemNumbers) { this.itemNumbers = itemNumbers; }
//
//    public List<Tickets> getTickets() { return tickets; }
//
//    public void setTickets(List<Tickets> tickets) { this.tickets = tickets; }
}

