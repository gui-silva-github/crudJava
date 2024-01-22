package aplicacao;

import model.Usuario;
import dao.Crud;
import java.util.Date;
import java.sql.SQLException;

public class Main {
    
    public static void main(String[] args) throws SQLException {

        // Instantiating crud

        Crud crud = new Crud();

        // Instantiating user

        Usuario usuario = new Usuario("Guilherme Ferreira dos Santos", 18, "guisantosferreira@gmail.com", "santosgui10", new Date());

        // Using create

        crud.save(usuario);

        Usuario usuario2 = new Usuario("Joaquim da Gama Carvalho", 32, "joaquimcarvalho@hotmail.com", "carvalhojoaquim", new Date());

        crud.save(usuario2);

        // Using read

        for (Usuario u : crud.getUsuarios()){
            System.out.println("---------------");
			System.out.println(u.getId());
			System.out.println(u.getNome());
			System.out.println(u.getEmail());
			System.out.println(u.getSenha());
			System.out.println(u.getDt_cadastro());
			System.out.println("---------------");
        }

        // Using update

        usuario2.setNome("Alfredo da Gama Carvalho");
        usuario2.setIdade(33);
        usuario2.setEmail("alfredocarvalho@gmail.com");
        usuario2.setSenha("carvalhoalfredo");
        usuario2.setDt_cadastro(new Date());
		usuario2.setId(2);

        crud.update(usuario2);

        // Using delete

        crud.deleteById(2);

    }

}
