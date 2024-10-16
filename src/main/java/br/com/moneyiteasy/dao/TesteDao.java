package br.com.moneyiteasy.dao;
import br.com.moneyiteasy.model.User;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class TesteDao {
    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDao();
//        User user = new User("Vini", "jpof99@gmail.com", "12345678902", "123", LocalDate.now(), 1000.00);
//        userDao.addUser(user);
//        List<User> listaUsers = userDao.getAllUsers();
//
//        if (!listaUsers.isEmpty()) {
//            System.out.println("Contas bancárias encontradas:");
//
//            for (User user : listaUsers) {
//                System.out.println("ID Conta: " + user.getId());
//                System.out.println("ID nome: " + user.getName());
//                System.out.println("ID cpf: " + user.getCpf());
//                System.out.println("ID email: " + user.getEmail());
//                System.out.println("ID senha: " + user.getPassword());
//                System.out.println("ID criação: " + user.getDate());
//                System.out.println("ID balance: " + user.getBalance());
//                System.out.println("---------------------------------");
//            }
//        } else {
//            System.out.println("Nenhuma conta bancária encontrada.");
//        }
        userDao.deleteUser("12345678902");



    }
}



